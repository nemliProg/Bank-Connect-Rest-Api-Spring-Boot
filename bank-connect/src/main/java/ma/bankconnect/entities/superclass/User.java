package ma.bankconnect.entities.superclass;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long id;

    @Column( name = "first_name" )
    String firstName;

    @Column( name = "last_name" )
    String lastName;

    String email;

    String password;

}
