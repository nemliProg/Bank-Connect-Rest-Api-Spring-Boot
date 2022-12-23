package ma.bankconnect.contoller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.bankconnect.dto.ClientDto;
import ma.bankconnect.dto.ClientVerify;
import ma.bankconnect.dto.ErrorMessage;
import ma.bankconnect.dto.LoginSuccess;
import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.client.ClientNotFoundException;
import ma.bankconnect.error.exception.client.ClientRegisterFailedException;
import ma.bankconnect.security.UserDetailService;
import ma.bankconnect.service.client.ClientService;
import ma.bankconnect.utils.JwtUtil;
import ma.bankconnect.utils.TwilioUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final ClientService clientService;
    private final TwilioUtil twilioUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailService userDetailsService;
    private final JwtUtil jwtUtil;



    @PostMapping("/register")
    public ResponseEntity<ErrorMessage> register(@Valid @RequestBody ClientDto clientDto) throws ClientRegisterFailedException {

        if(clientService.checkIfClientExistByEmail(clientDto.getEmail())){
            throw new ClientRegisterFailedException("Email already exist");
        }

        if(clientService.checkIfClientExistByCin(clientDto.getCin())){
            throw new ClientRegisterFailedException("CIN already exist");
        }

        if(clientService.checkIfClientExistByPhoneNumber(clientDto.getPhoneNumber())){
            throw new ClientRegisterFailedException("Phone number already exist");
        }

        Client client = Client.builder()
                .email(clientDto.getEmail())
                .password(passwordEncoder.encode(clientDto.getPassword()))
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .adresse(clientDto.getAddress())
                .cin(clientDto.getCin())
                .photoCinR(clientDto.getPhotoCinR())
                .photoCinV(clientDto.getPhotoCinV())
                .phoneNumber(clientDto.getPhoneNumber())
                .codeSms(generateCode())
                .timeCodeSms(LocalDateTime.now().plusMinutes(3))
                .build();

        clientService.saveClient(client);
        twilioUtil.sendSMS(client.getPhoneNumber(), "BankConnect : Your verification code is " + client.getCodeSms());
        return ResponseEntity.ok(new ErrorMessage(HttpStatus.OK, "Verify your account by providing the code sent to your phone number"));
    }

    @PostMapping("/verify")
    public ResponseEntity<HashMap<String, String>> verify(@Valid @RequestBody ClientVerify clientVerify) throws ClientNotFoundException{

        // check if phone number exists
        Client client = clientService.getClientByPhoneNumber(clientVerify.getPhoneNumber())
                .orElseThrow(() -> new ClientNotFoundException("Phone number does not exists"));

        // check if SMS code is valid
        if(!client.getCodeSms().equals(clientVerify.getVerificationCode())){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(
                            new HashMap<>(){{
                                put("status", String.valueOf(HttpStatus.BAD_REQUEST));
                                put("message", "Verification code is invalid");
                            }}
                    );
        }

        // check if SMS code is expired
        if(LocalDateTime.now().isAfter(client.getTimeCodeSms())){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(
                            new HashMap<>(){{
                                put("status", String.valueOf(HttpStatus.UNAUTHORIZED));
                                put("message", "Verification code is expired");
                            }}
                    );
        }

        String emailAndType = client.getEmail() + ":client";

        // authenticate new client
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(emailAndType, clientVerify.getPassword());
        authenticationManager.authenticate(token);
        UserDetails user = userDetailsService.loadUserByUsername(emailAndType);

        // generate jwt token
        String jwtToken = jwtUtil.generateToken(
                new HashMap<>() {{
                    put("userType", "client");
                }},
                user);

        return ResponseEntity.ok(
                new HashMap<>(){{
                    put("token", jwtToken);
                }}
        );

    }

    private String generateCode() {
        String code = String.valueOf((int) Math.floor(Math.random() * 1000000));
        if(code.length() < 6){
            code = "0" + code;
        }
        return code;
    }

}
