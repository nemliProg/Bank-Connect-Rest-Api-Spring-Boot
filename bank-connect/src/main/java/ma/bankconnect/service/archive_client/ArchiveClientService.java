package ma.bankconnect.service.archive_client;

import ma.bankconnect.entities.ArchiveClient;

public interface ArchiveClientService {
    ArchiveClient archiveClient(Long accountId, String reason);
    boolean checkIfClientIsArchived(Long accountId);
    ArchiveClient getArchiveClientById(Long accountId);
    boolean unarchiveClient(Long accountId);
}
