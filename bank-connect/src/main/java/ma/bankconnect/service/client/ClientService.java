package ma.bankconnect.service.client;

import ma.bankconnect.entities.ArchiveClient;
import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.ArchiveClientNotFoundException;

import java.util.Optional;

public interface ClientService {
    Optional<Client> getClientByEmail(String email);
    Client saveClient(Client client);
    Client updateClient(Client client);
    boolean archiveClient(Long clientId, String reason) throws ArchiveClientNotFoundException;
}
