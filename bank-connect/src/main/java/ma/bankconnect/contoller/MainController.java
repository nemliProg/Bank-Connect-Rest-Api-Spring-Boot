package ma.bankconnect.contoller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ma.bankconnect.dto.LoginCredentials;
import ma.bankconnect.security.UserDetailService;
import ma.bankconnect.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class MainController {


    @GetMapping("/")
    public String home() {
        return "Welcome to BankConnect";
    }
}
