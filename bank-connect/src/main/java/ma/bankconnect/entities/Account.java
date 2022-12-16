package ma.bankconnect.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private long id;

    @Column( name = "rib" , nullable = false , unique = true )
    private String rib;

    private double solde;


    @Column( name = "code_verification" )
    private String codeVerification;


    private String type;

    @ManyToOne
    @JoinColumn( name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "account")
    private ArchiveAccount archiveCompte;

    @OneToMany(mappedBy = "sender")
    private List<Transaction> transactionsSender;

    @OneToMany(mappedBy = "receiver")
    private List<Transaction> transactionsReceiver;
}
