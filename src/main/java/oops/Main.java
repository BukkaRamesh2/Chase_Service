package oops;
public class Main {
    public static void main(String[] args) {
        // Polymorphism: using base class reference
        Transaction t1 = new BankTransaction("TXN001", 100.0);
        Transaction t2 = new OnlineTransaction("TXN002", 250.0);

        t1.processTransaction();  // Calls BankTransaction's method
        t2.processTransaction();  // Calls OnlineTransaction's method
    }
}
