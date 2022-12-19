package ma.bankconnect.service.archive_account;

import ma.bankconnect.entities.ArchiveAccount;

public interface ArchiveAccountService {
    boolean archiveAccount(Long accountId, String reason);
    boolean checkIfAccountIsArchived(Long accountId);
    ArchiveAccount getArchiveAccountByAccountId(Long accountId);
    boolean unarchiveAccount(Long accountId);
}
