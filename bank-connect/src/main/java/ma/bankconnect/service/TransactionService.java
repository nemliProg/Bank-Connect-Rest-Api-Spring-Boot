package ma.bankconnect.service;

import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.Transaction;

import java.util.List;

public interface TransactionService {

    void transfer(Account sender, Account receiver, double amount);
    List<Transaction> getAllTransactionsOfAccount(Account account);
    List<Transaction> getAllTransactionsAsSender(Account account);
    List<Transaction> getAllTransactionsAsReceiver(Account account);
    Transaction getTransactionsOfAccountByDate(Account account, String date);
    List<Transaction> getAllTransactionsOfAccountByAmount(Account account, double amount);
    List<Transaction> getAllTransactionsOfAccountBySender(Account account, Account sender);
    List<Transaction> getAllTransactionsOfAccountByReceiver(Account account, Account receiver);

}
