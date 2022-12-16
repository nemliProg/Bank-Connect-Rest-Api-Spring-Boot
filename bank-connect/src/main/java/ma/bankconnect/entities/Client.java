package ma.bankconnect.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.bankconnect.entities.superclass.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {

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
