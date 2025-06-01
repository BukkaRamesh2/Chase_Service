package com.chase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.entity.Card;
import com.chase.repository.cardrepository;
@Service
public class Cardserviceimplementation implements Cardservice {

    @Autowired
    cardrepository cardRepository;

    public Cardserviceimplementation() {

    }

    @Override
    public Card addCard(Card card) {
        if (card.getCardType() == null) {
            System.out.println("The customer doesn't have a card type");
        } else {  
            switch (card.getCardType().toLowerCase()) {
                case "debit":
                    System.out.println("The customer has a debit card");
                    break;
                case "credit":
                    System.out.println("The customer has a credit card");
                    break;
                default:
                    System.out.println("The customer has another card type");
            }
        }
        return cardRepository.save(card);
    }

    @Override
    public Card getCard(String cardNumber) {
        if (cardNumber != null && cardNumber.length() > 0) {
            System.out.println("Customer has a card");
        } else {
            System.out.println("Customer doesn't have a card");
            return cardRepository.getBycardNumber(cardNumber);
        }
        return null;
    }

    @Override
    public List<Card> getAllCard() {
        List<Card> cards = cardRepository.findAll();
        if (cards.isEmpty()) {
            System.out.println("There are no cards found");
        } else {
            cards.forEach(card -> {
                if (card.getStatus().equalsIgnoreCase("active")) {
                    System.out.println("The card is in active status");
                }
            });
        }
        return null;
    }

    @Override
    public Card updateCard(Card card) {
        return null;
    }

    @Override
    public Card deletecard(String cardNumber) {
        return null;
    }
}
