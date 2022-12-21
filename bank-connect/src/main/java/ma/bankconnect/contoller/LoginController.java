package ma.bankconnect.contoller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ma.bankconnect.dto.LoginCredentials;
import ma.bankconnect.dto.LoginSuccess;
import ma.bankconnect.error.exception.LoginFailedException;
import ma.bankconnect.security.UserDetailService;
import ma.bankconnect.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailService userDetailsService;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/agent")
    public ResponseEntity<LoginSuccess> agentLogin(@Valid @RequestBody LoginCredentials loginCredentials) throws LoginFailedException {
        return login (loginCredentials, "agent");
    }

    @PostMapping("/client")
    public ResponseEntity<LoginSuccess> clientLogin(@Valid @RequestBody LoginCredentials loginCredentials) throws LoginFailedException {
        return login (loginCredentials, "client");
    }

    private ResponseEntity<LoginSuccess> login(LoginCredentials loginCredentials, String userType) throws LoginFailedException {
        log.info("Login request received for user {}", loginCredentials.getEmail());

        String emailAndType = loginCredentials.getEmail()+ ":" + userType;
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(emailAndType, loginCredentials.getPassword()));
        } catch (Exception e) {
            throw new LoginFailedException("Login failed for user " + loginCredentials.getEmail());
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(emailAndType, loginCredentials.getPassword());
        authenticationManager.authenticate(token);
        UserDetails user = userDetailsService.loadUserByUsername(emailAndType);

        String jwtToken = jwtUtil.generateToken(
                new HashMap<>() {{
                    put("userType", "agent");
                }},
                user);

        return ResponseEntity.ok(new LoginSuccess(jwtToken));
    }

}
