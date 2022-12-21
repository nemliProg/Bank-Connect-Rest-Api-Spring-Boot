package ma.bankconnect.service.account;

import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.ArchiveAccount;
import ma.bankconnect.entities.Transaction;
import ma.bankconnect.repository.AccountRepository;
import ma.bankconnect.repository.ArchiveAccountRepository;
import ma.bankconnect.service.archive_account.ArchiveAccountServiceImp;
import ma.bankconnect.service.transaction.TransactionServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountServiceImp implements AccountService{

    private AccountRepository accountRepository;
    private TransactionServiceImp transactionServiceImp;
    private ArchiveAccountServiceImp archiveAccountServiceImp;

    public AccountServiceImp(AccountRepository accountRepository, TransactionServiceImp transactionServiceImp, ArchiveAccountServiceImp archiveAccountServiceImp) {
        this.accountRepository = accountRepository;
        this.transactionServiceImp = transactionServiceImp;
        this.archiveAccountServiceImp = archiveAccountServiceImp;
    }

    @Override
    public boolean transferMoney(Account sender, Account receiver, double amount) {
        // check if the sender has enough money
        if (sender.getSolde() < amount){
            return false;
        }
        // Transfer money
        Transaction transaction = transactionServiceImp.transfer(sender,receiver,amount);
        // check if the transaction is done
        if (transaction == null){
            return false;
        }
        // update the sender and receiver accounts and return true
        updateAccount(sender);
        updateAccount(receiver);
        return true;
    }

    @Override
    public boolean archiveAccount(Long accountId, String reason) {
        // archive the account
        ArchiveAccount archivedAccount = archiveAccountServiceImp.archiveAccount(accountId,reason);
        // check if the account is archived
        if (archivedAccount == null){
            return false;
        }
        return true;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountByRib(String rib) {
        return accountRepository.findByRib(rib);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }
}
