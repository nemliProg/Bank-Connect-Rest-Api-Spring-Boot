package ma.bankconnect.service.client;

import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.archive_client.ArchiveClientNotFoundException;

import java.util.Optional;

public interface ClientService {
    Optional<Client> getClientByEmail(String email);
    Optional<Client> getClientByPhoneNumber(String phoneNumber);
    Client saveClient(Client client);
    Client updateClient(Client client);
    boolean archiveClient(Long clientId, String reason) throws ArchiveClientNotFoundException;

    boolean checkIfClientExistByEmail(String email);
    boolean checkIfClientExistByCin(String cin);
    boolean checkIfClientExistByPhoneNumber(String phoneNumber);

}
