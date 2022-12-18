package ma.bankconnect.service;

import ma.bankconnect.entities.Client;

import java.util.Optional;

public interface ClientService {
    Optional<Client> getClientByEmail(String email);
    Client saveClient(Client client);
    Client updateClient(Client client);
    boolean archiveClient(Long clientId, String reason);
}
