package ma.bankconnect.service.archive_client;

import ma.bankconnect.entities.ArchiveClient;

public class ArchiveClientServiceImp implements ArchiveClientService {
    @Override
    public boolean archiveClient(Long accountId, String reason) {
        return false;
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
