package ma.bankconnect.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientVerify {
    @Size(min = 13, max = 13)
    String phoneNumber;

    @NotBlank
    String password;

    @Size(min = 6, max = 6)
    String verificationCode;
}
