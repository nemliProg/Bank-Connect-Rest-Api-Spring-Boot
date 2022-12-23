package ma.bankconnect.entities.superclass;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    protected Long id;

    @Column( name = "first_name" )
    protected String firstName;

    @Column( name = "last_name" )
    protected String lastName;

    protected String email;

    protected String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


}
