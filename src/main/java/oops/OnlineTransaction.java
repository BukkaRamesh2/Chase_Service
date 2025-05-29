package oops;
// Another subclass to show Polymorphism
public class OnlineTransaction extends Transaction {

    public OnlineTransaction(String transactionId, double amount) {
        super(transactionId, amount);
    }

    @Override
    public void processTransaction() {
        System.out.println("Processing online transaction: " + getTransactionId() + " Amount: $" + getAmount());
    }
}
