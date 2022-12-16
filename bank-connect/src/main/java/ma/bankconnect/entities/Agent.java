package ma.bankconnect.entities;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.bankconnect.entities.superclass.User;

@Entity
@AllArgsConstructor
public class Agent extends User {
}
