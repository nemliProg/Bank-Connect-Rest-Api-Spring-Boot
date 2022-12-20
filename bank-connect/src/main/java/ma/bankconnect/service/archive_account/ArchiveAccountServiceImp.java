package ma.bankconnect.service.archive_account;

import ma.bankconnect.entities.ArchiveAccount;
import ma.bankconnect.repository.AccountRepository;

public class ArchiveAccountServiceImp implements ArchiveAccountService {

    private AccountRepository accountRepository;

    @Override
    public ArchiveAccount archiveAccount(Long accountId, String reason) {
        ArchiveAccount archiveAccount = new ArchiveAccount();
        archiveAccount.setAccount(accountRepository.findById(accountId).get());
        archiveAccount.setReason(reason);
        return archiveAccount;
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
