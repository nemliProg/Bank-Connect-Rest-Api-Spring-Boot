package ma.bankconnect.service.account;

import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.Transaction;
import ma.bankconnect.repository.AccountRepository;
import ma.bankconnect.service.transaction.TransactionServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountServiceImp implements AccountService{

    private AccountRepository accountRepository;
    private TransactionServiceImp transactionServiceImp;

    public AccountServiceImp(AccountRepository accountRepository, TransactionServiceImp transactionServiceImp) {
        this.accountRepository = accountRepository;
        this.transactionServiceImp = transactionServiceImp;
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
        accountRepository.save(sender);
        accountRepository.save(receiver);
        return true;
    }

    @Override
    public boolean archiveAccount(Long accountId, String reason) {
        return false;
    }

    @Override
    public Account saveAccount(Account account) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public Optional<Account> getAccountByRib(String rib) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return Optional.empty();
    }
}
