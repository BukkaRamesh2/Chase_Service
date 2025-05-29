package com.chase.util;


abstract class AbstractCard {
    public abstract void validateCard();
    public abstract void blockCard();
}


class BaseCard extends AbstractCard {
    private Long cardId;
    private String cardType;
    private String cardNumber;
    private String expiryDate;
    private int cvv;
    private String status;

    public BaseCard(Long cardId, String cardType, String cardNumber, String expiryDate, int cvv, String status) {
        this.cardId = cardId;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.status = status;
    }

    
    public Long getCardId() { return cardId; }
    public void setCardId(Long cardId) { this.cardId = cardId; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public int getCvv() { return cvv; }
    public void setCvv(int cvv) { this.cvv = cvv; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    
    @Override
    public void validateCard() {
        System.out.println("Validating base card: " + cardNumber);
    }

    @Override
    public void blockCard() {
        this.status = "Blocked";
        System.out.println("Card blocked: " + cardNumber);
    }
}


class DebitCard extends BaseCard {
    public DebitCard(Long cardId, String cardNumber, String expiryDate, int cvv, String status) {
        super(cardId, "Debit", cardNumber, expiryDate, cvv, status);
    }

    @Override
    public void validateCard() {
        System.out.println("Debit card validation successful: " + getCardNumber());
    }
}

class CreditCard extends BaseCard {
    public CreditCard(Long cardId, String cardNumber, String expiryDate, int cvv, String status) {
        super(cardId, "Credit", cardNumber, expiryDate, cvv, status);
    }

    @Override
    public void validateCard() {
        System.out.println("Credit card validation successful: " + getCardNumber());
    }
}




public class Cardutil {
    public static void main(String[] args) {
        // Encapsulation + Inheritance + Abstraction
        BaseCard base = new BaseCard(1001L, "Generic", "1234123412341234", "12/26", 321, "Active");
        base.validateCard();
        base.blockCard();

        
        BaseCard debit = new DebitCard(1002L, "1111222233334444", "11/25", 123, "Active");
        BaseCard credit = new CreditCard(1003L, "5555666677778888", "10/27", 456, "Active");

        debit.validateCard();  // DebitCard's version
        credit.validateCard(); // CreditCard's version
    }
}
