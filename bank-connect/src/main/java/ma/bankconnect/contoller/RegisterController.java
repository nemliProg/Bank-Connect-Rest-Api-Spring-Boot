package ma.bankconnect.contoller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.bankconnect.dto.ClientDto;
import ma.bankconnect.dto.ErrorMessage;
import ma.bankconnect.dto.LoginSuccess;
import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.client.ClientRegisterFailedException;
import ma.bankconnect.service.client.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final ClientService clientService;

    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<ErrorMessage> register(@Valid @RequestBody ClientDto clientDto) throws ClientRegisterFailedException {


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
                .timeCodeSms(LocalDateTime.now())
                .build();

        if(clientService.checkIfClientExistByEmail(clientDto.getEmail())){
            throw new ClientRegisterFailedException("Email already exist");
        }

        if(clientService.checkIfClientExistByCin(clientDto.getCin())){
            throw new ClientRegisterFailedException("CIN already exist");
        }

        if(clientService.checkIfClientExistByPhoneNumber(clientDto.getPhoneNumber())){
            throw new ClientRegisterFailedException("Phone number already exist");
        }

        clientService.saveClient(client);
        return ResponseEntity.ok(new ErrorMessage(HttpStatus.OK, "Verify your account by providing the code sent to your phone number"));
    }

    private String generateCode() {
        String code = String.valueOf((int) Math.floor(Math.random() * 1000000));
        if(code.length() < 6){
            code = "0" + code;
        }
        return code;
    }

}
