package ma.bankconnect.service.archive_account;

import ma.bankconnect.entities.ArchiveAccount;

public class ArchiveAccountServiceImp implements ArchiveAccountService {

    @Override
    public boolean archiveAccount(Long accountId, String reason) {
        return false;
    }

    @Override
    public boolean checkIfAccountIsArchived(Long accountId) {
        return false;
    }

    @Override
    public ArchiveAccount getArchiveAccountByAccountId(Long accountId) {
        return null;
    }

    @Override
    public boolean unarchiveAccount(Long accountId) {
        return false;
    }
}
