package ma.bankconnect.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArchiveClient {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @OneToOne
    @JoinColumn( name = "client_id")
    private Client client;


    private String reason;
}
