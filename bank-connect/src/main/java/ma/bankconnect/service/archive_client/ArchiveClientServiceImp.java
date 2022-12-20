package ma.bankconnect.service.archive_client;

import ma.bankconnect.entities.ArchiveClient;
import ma.bankconnect.entities.Client;
import ma.bankconnect.repository.ArchiveClientRepository;
import ma.bankconnect.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArchiveClientServiceImp implements ArchiveClientService {

    private ArchiveClientRepository archiveClientRepository;

    private ClientRepository clientRepository;

    public ArchiveClientServiceImp(ArchiveClientRepository archiveClientRepository, ClientRepository clientRepository) {
        this.archiveClientRepository = archiveClientRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean archiveClient(Long clientId, String reason) {
        //  check if client is exist
        Client client = clientRepository.findById(clientId).get();
        if (client == null){
            return false;
        }
        //  archive client
        ArchiveClient archiveClient = new ArchiveClient();
        archiveClient.setClient(clientRepository.findById(clientId).get());
        archiveClient.setReason(reason);
        archiveClientRepository.save(archiveClient);
        return true;
    }

    @Override
    public boolean checkIfClientIsArchived(Long accountId) {
        return false;
    }

    @Override
    public ArchiveClient getArchiveClientById(Long accountId) {
        return null;
    }

    @Override
    public boolean unarchiveClient(Long accountId) {
        return false;
    }

}
