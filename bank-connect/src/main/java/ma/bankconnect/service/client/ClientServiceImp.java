package ma.bankconnect.service.client;

import ma.bankconnect.entities.ArchiveClient;
import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.ArchiveClientNotFoundException;

import java.util.Optional;

public class ClientServiceImp implements ClientService {

    @Override
    public Optional<Client> getClientByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Client saveClient(Client client) {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public Optional<ArchiveClient> archiveClient(Long clientId, String reason) throws ArchiveClientNotFoundException {
        return Optional.empty();
    }

}
