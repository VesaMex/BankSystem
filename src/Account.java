import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Account {
    private String id;
    private String name;
    private double balance;
    private List<Transaction> transactions;

    public Account(String name, double initialBalance) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        if (balance < 0) {
            balance = 0; // prevent negative balance
        }
    }

    public List<Transaction> transactions() {
        return transactions;
    }
}