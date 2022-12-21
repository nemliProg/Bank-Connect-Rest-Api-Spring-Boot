package ma.bankconnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginCredentials {

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    String userType;
}
