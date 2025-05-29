package oops;
// Abstract class (Abstraction)
public abstract class Transaction {
    private String transactionId;   // Encapsulated fields
    private double amount;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    // Getters (Encapsulation)
    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    // Abstract method (Abstraction)
    public abstract void processTransaction();
}
