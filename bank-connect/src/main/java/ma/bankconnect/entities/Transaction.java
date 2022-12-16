package ma.bankconnect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn( name = "sender")
    private Account sender;

    @ManyToOne
    @JoinColumn( name = "receiver")
    private Account receiver;

    private double amount;

    private LocalDateTime date;
}
