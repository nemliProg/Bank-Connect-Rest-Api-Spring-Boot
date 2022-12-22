package ma.bankconnect.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import ma.bankconnect.entities.superclass.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {

    @Builder
    public Client(
            String firstName,
            String lastName,
            String email,
            String password,
            String cin,
            String photoCinR,
            String photoCinV,
            String phoneNumber,
            String adresse,
            String codeSms,
            LocalDateTime timeCodeSms,
            List<Account> accounts)
    {
        super(firstName, lastName, email, password);
        this.cin = cin;
        this.photoCinR = photoCinR;
        this.photoCinV = photoCinV;
        this.phoneNumber = phoneNumber;
        this.adresse = adresse;
        this.codeSms = codeSms;
        this.timeCodeSms = timeCodeSms;
        this.accounts = accounts;
    }

    String cin;

    @Column( name = "photo_cin_r" )
    String photoCinR;

    @Column( name = "photo_cin_v" )
    String photoCinV;

    @Column( name = "phone_number" )
    String phoneNumber;

    String adresse;

    @Column( name = "code_sms" )
    String codeSms;

    @Column( name = "time_code_sms" )
    LocalDateTime timeCodeSms;

    @OneToMany(mappedBy = "client")
    List<Account> accounts;

}
