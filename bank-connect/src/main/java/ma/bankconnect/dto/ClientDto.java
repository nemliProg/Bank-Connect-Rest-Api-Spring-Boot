package ma.bankconnect.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
public class ClientDto {

    @NotBlank
    @Size(min = 4)
    private String firstName;

    @NotBlank
    @Size(min = 4)
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotBlank
    private String address;

    @NotBlank
    private String cin;

    @NotBlank
    String photoCinR;

    @NotBlank
    String photoCinV;
}
