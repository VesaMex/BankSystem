import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;
    private double totalTransactionFee;
    private double totalTransferAmount;
    private double transactionFlatFee;
    private double transactionPercentFee;

    public Bank(String name, double transactionFlatFee, double transactionPercentFee) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.totalTransactionFee = 0;
        this.totalTransferAmount = 0;
        this.transactionFlatFee = transactionFlatFee;
        this.transactionPercentFee = transactionPercentFee;
    }

    public void createAccount(String name, double initialBalance) {
        Account account = new Account(name, initialBalance);
        accounts.add(account);
    }

    public Account getAccount(String id) {
        for (Account account : accounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public void performTransaction(Account fromAccount, Account toAccount, double amount, TransactionType type) {
        if (type == TransactionType.FLAT_FEE) {
            double fee = transactionFlatFee;
            fromAccount.withdraw(amount + fee);
            toAccount.deposit(amount);
            totalTransactionFee += fee;
            totalTransferAmount += amount;
        } else if (type == TransactionType.PERCENT_FEE) {
            double fee = amount * (transactionPercentFee / 100);
            fromAccount.withdraw(amount + fee);
            toAccount.deposit(amount);
            totalTransactionFee += fee;
            totalTransferAmount += amount;
        }
    }

    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
        totalTransactionFee += transactionFlatFee;
        totalTransferAmount += amount;
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        totalTransferAmount += amount;
    }

    public void printTransactions(Account account) {
        for (Transaction transaction : account.transactions()) {
            System.out.println("Transaction: " + transaction.getAmount() + " from " + transaction.getOriginatingAccountId() + " to " + transaction.getRecipientAccountId() + " with reason " + transaction.getReason());
        }
    }

    public void printAccountBalance(Account account) {
        System.out.println("Account balance: " + account.getBalance());
    }

    public void printBankAccounts() {
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getId() + ", Name: " + account.getName() + ", Balance: " + account.getBalance());
        }
    }

    public void printBankTotalTransactionFee() {
        System.out.println("Total Transaction Fee: " + totalTransactionFee);
    }

    public void printBankTotalTransferAmount() {
        System.out.println("Total Transfer Amount: " + totalTransferAmount);
    }
}