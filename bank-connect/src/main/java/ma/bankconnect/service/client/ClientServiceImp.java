package ma.bankconnect.service.client;

import ma.bankconnect.entities.ArchiveClient;
import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.archive_client.ArchiveClientNotFoundException;
import ma.bankconnect.repository.ClientRepository;
import ma.bankconnect.service.archive_client.ArchiveClientServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ClientServiceImp implements ClientService {
    private final ClientRepository clientRepository;

    private final ArchiveClientServiceImp  archiveClientServiceImp;

    ClientServiceImp(ClientRepository clientRepository, ArchiveClientServiceImp archiveClientServiceImp) {
        this.clientRepository = clientRepository;
        this.archiveClientServiceImp = archiveClientServiceImp;
    }

    @Override
    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
    public Optional<Client> getClientByPhoneNumber(String phoneNumber) {
        return clientRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean archiveClient(Long clientId, String reason) throws ArchiveClientNotFoundException {
        //  check if client is exist
        Client client = clientRepository.findById(clientId).get();
        if (client == null){
            return false;
        }
        //  archive client
        ArchiveClient archiveClient = archiveClientServiceImp.archiveClient(clientId, reason);
        return archiveClient != null;
    }

    @Override
    public boolean checkIfClientExistByEmail(String email){
        return clientRepository.existsByEmail(email);
    }

    @Override
    public boolean checkIfClientExistByCin(String cin){
        return clientRepository.existsByCin(cin);
    }

    @Override
    public boolean checkIfClientExistByPhoneNumber(String phoneNumber){
        return clientRepository.existsByPhoneNumber(phoneNumber);
    }


}
