package ma.bankconnect.service.archive_account;

import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.ArchiveAccount;
import ma.bankconnect.repository.AccountRepository;
import ma.bankconnect.repository.ArchiveAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArchiveAccountServiceImp implements ArchiveAccountService {

    private AccountRepository accountRepository;

    private ArchiveAccountRepository archiveAccountRepository;

    public ArchiveAccountServiceImp(AccountRepository accountRepository, ArchiveAccountRepository archiveAccountRepository) {
        this.accountRepository = accountRepository;
        this.archiveAccountRepository = archiveAccountRepository;
    }



    @Override
    public ArchiveAccount archiveAccount(Long accountId, String reason) {
        //  check if account is exist
        Account account = accountRepository.findById(accountId).get();
        if ( account == null){
            return null;
        }
        //  archive account
        ArchiveAccount archiveAccount = new ArchiveAccount();
        archiveAccount.setAccount(account);
        archiveAccount.setReason(reason);
        return archiveAccount;
    }

    @Override
    public boolean checkIfAccountIsArchived(Long accountId) {
        return archiveAccountRepository.existsById(accountId);
    }

    @Override
    public ArchiveAccount getArchiveAccountByAccountId(Long accountId) {
        return archiveAccountRepository.findById(accountId).get();
    }

    @Override
    public boolean unarchiveAccount(Long accountId) {
        if (checkIfAccountIsArchived(accountId)){
            archiveAccountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }
}
