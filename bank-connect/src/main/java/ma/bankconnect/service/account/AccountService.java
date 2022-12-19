package ma.bankconnect.service.account;

import ma.bankconnect.entities.Account;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AccountService {
    boolean transferMoney(Account sender, Account receiver, double amount, LocalDateTime date);
    boolean archiveAccount(Long accountId, String reason);
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    Optional<Account> getAccountByRib(String rib);
    Optional<Account> getAccountById(Long id);
}
