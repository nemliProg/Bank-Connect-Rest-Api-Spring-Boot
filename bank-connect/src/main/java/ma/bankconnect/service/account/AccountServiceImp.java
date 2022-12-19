package ma.bankconnect.service.account;

import ma.bankconnect.entities.Account;

import java.time.LocalDateTime;
import java.util.Optional;

public class AccountServiceImp implements AccountService{

    @Override
    public boolean transferMoney(Account sender, Account receiver, double amount, LocalDateTime date) {
        return false;
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
