import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank of America", 10, 5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create a bank with all required values");
            System.out.println("2. Create an account");
            System.out.println("3. Perform a flat fee transaction");
            System.out.println("4. Perform a percent fee transaction");
            System.out.println("5. Withdraw money from an account");
            System.out.println("6. Deposit money to an account");
            System.out.println("7. See list of transactions for any account");
            System.out.println("8. Check account balance for any account");
            System.out.println("9. See list of bank accounts");
            System.out.println("10. Check bank total transaction fee amount");
            System.out.println("11. Check bank total transfer amount");
            System.out.println("12. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter bank name: ");
                    String bankName = scanner.next();
                    System.out.print("Enter flat fee: ");
                    double flatFee = scanner.nextDouble();
                    System.out.print("Enter percent fee: ");
                    double percentFee = scanner.nextDouble();
                    bank = new Bank(bankName, flatFee, percentFee);
                    break;

                case 2:
                    System.out.print("Enter account name: ");
                    String name = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(name, initialBalance);
                    break;

                case 3:
                    System.out.print("Enter originating account ID: ");
                    String fromId = scanner.next();
                    System.out.print("Enter recipient account ID: ");
                    String toId = scanner.next();
                    System.out.print("Enter transaction amount: ");
                    double amount = scanner.nextDouble();
                    Account fromAccount = bank.getAccount(fromId);
                    Account toAccount = bank.getAccount(toId);
                    if (fromAccount != null && toAccount != null) {
                        bank.performTransaction(fromAccount, toAccount, amount, TransactionType.FLAT_FEE);
                    } else {
                        System.out.println("Invalid account ID");
                    }
                    break;

                case 4:
                    System.out.print("Enter originating account ID: ");
                    fromId = scanner.next();
                    System.out.print("Enter recipient account ID: ");
                    toId = scanner.next();
                    System.out.print("Enter transaction amount: ");
                    amount = scanner.nextDouble();
                    Account fromAccount2 = bank.getAccount(fromId);
                    Account toAccount2 = bank.getAccount(toId);
                    if (fromAccount2 != null && toAccount2 != null) {
                        bank.performTransaction(fromAccount2, toAccount2, amount, TransactionType.PERCENT_FEE);
                    } else {
                        System.out.println("Invalid account ID");
                    }
                    break;

                case 5:
                    System.out.print("Enter account ID: ");
                    fromId = scanner.next();
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();
                    Account fromAccount3 = bank.getAccount(fromId);
                    if (fromAccount3 != null) {
                        bank.withdraw(fromAccount3, amount);
                    } else {
                        System.out.println("Invalid account ID");
                    }
                    break;

                case 6:
                    System.out.print("Enter account ID: ");
                    toId = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    amount = scanner.nextDouble();
                    Account toAccount3 = bank.getAccount(toId);
                    if (toAccount3 != null) {
                        bank.deposit(toAccount3, amount);
                    } else {
                        System.out.println("Invalid account ID");
                    }
                    break;

                case 7:
                    System.out.print("Enter account ID: ");
                    fromId = scanner.next();
                    Account fromAccount4 = bank.getAccount(fromId);
                    if (fromAccount4 != null) {
                        bank.printTransactions(fromAccount4);
                    } else {
                        System.out.println("Invalid account ID");
                    }
                    break;

                case 8:
                    System.out.print("Enter account ID: ");
                    fromId = scanner.next();
                    Account fromAccount5 = bank.getAccount(fromId);
                    if (fromAccount5 != null) {
                        bank.printAccountBalance(fromAccount5);
                    } else {
                        System.out.println("Invalid account ID");
                    }
                    break;

                case 9:
                    bank.printBankAccounts();
                    break;

                case 10:
                    bank.printBankTotalTransactionFee();
                    break;

                case 11:
                    bank.printBankTotalTransferAmount();
                    break;

                case 12:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}