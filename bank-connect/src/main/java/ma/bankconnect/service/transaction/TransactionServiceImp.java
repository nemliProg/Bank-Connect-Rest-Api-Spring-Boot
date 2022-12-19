package ma.bankconnect.service.transaction;

import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.Transaction;

import java.util.List;

public class TransactionServiceImp implements TransactionService{
    @Override
    public void transfer(Account sender, Account receiver, double amount) {

    }

    @Override
    public List<Transaction> getAllTransactionsOfAccount(Account account) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsAsSender(Account account) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsAsReceiver(Account account) {
        return null;
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
