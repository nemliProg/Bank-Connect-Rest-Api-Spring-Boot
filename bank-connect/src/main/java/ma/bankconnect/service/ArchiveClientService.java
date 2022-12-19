package ma.bankconnect.service;

import ma.bankconnect.entities.ArchiveClient;

public interface ArchiveClientService {
    boolean archiveClient(Long accountId, String reason);
    boolean checkIfClientIsArchived(Long accountId);
    ArchiveClient getArchiveClientById(Long accountId);
    boolean unarchiveClient(Long accountId);
}
