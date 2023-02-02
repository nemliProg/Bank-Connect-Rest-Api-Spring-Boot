package ma.bankconnect.service.transaction;

import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.Transaction;
import ma.bankconnect.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImp implements TransactionService{

    private TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Transaction transfer(Account sender, Account receiver, double amount) {

        sender.setSolde(sender.getSolde() - amount);
        receiver.setSolde(receiver.getSolde() + amount);
        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(amount);
        transaction.setDate(LocalDateTime.now());
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> getAllTransactionsOfAccount(Account account) {
        return transactionRepository.findAllBySenderOrReceiver(account,account);
    }

    @Override
    public List<Transaction> getAllTransactionsAsSender(Account account) {
        return transactionRepository.findAllBySender(account);
    }

    @Override
    public List<Transaction> getAllTransactionsAsReceiver(Account account) {
        return transactionRepository.findAllByReceiver(account);
    }

    @Override
    public Transaction getTransactionsOfAccountByDate(Account account, String date) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsOfAccountByAmount(Account account, double amount) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsOfAccountBySender(Account account, Account sender) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsOfAccountByReceiver(Account account, Account receiver) {
        return null;
    }
}
