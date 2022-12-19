package ma.bankconnect.repository;

import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllBySenderOrReceiver(Account account);

    List<Transaction> findAllBySender(Account sender);
}
