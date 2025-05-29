package oops;
// Inherits from Transaction (Inheritance)
public class BankTransaction extends Transaction {

    public BankTransaction(String transactionId, double amount) {
        super(transactionId, amount);
    }

    // Implementing abstract method (Polymorphism)
    @Override
    public void processTransaction() {
        System.out.println("Processing bank transaction: " + getTransactionId() + " Amount: $" + getAmount());
    }
}
