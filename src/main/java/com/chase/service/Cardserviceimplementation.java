package com.chase.service;

import java.util.*;

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
        boolean isValid = true;

        if (card.getCardType() == null || card.getCardType().isEmpty()) {
            System.out.println("Card type is required.");
            isValid = false;
        }

        if (card.getCardNumber() == null || card.getCardNumber().isEmpty()) {
            System.out.println("Card number is required.");
            isValid = false;
        }

        if (card.getCvv() <= 0) {
            System.out.println("Invalid CVV.");
            isValid = false;
        }

        if (card.getStatus() == null || card.getStatus().isEmpty()) {
            System.out.println("Card status is required.");
            isValid = false;
        }

        if (!isValid) {
            System.out.println("Card creation failed due to invalid input.");
            return null;
        }

        switch (card.getCardType().toLowerCase()) {
            case "debit":
                System.out.println("The customer has a debit card.");
                break;
            case "credit":
                System.out.println("The customer has a credit card.");
                break;
            default:
                System.out.println("The customer has another card type.");
        }

        return cardRepository.save(card);
    }

    @Override
    public Card getCard(String cardNumber) {
        if (cardNumber != null && !cardNumber.isEmpty()) {
            System.out.println("Customer has a card.");
            return cardRepository.getBycardNumber(cardNumber);
        } else {
            System.out.println("Customer doesn't have a card.");
            return null;
        }
    }

    @Override
    public List<Card> getAllCard() {
        List<Card> cards = cardRepository.findAll();

        if (cards.isEmpty()) {
            System.out.println("There are no cards found.");
            return cards;
        }

        // Group cards by status
        Map<String, List<Card>> statusMap = new HashMap<>();
        Map<String, List<Card>> linkedStatusMap = new LinkedHashMap<>();
        Map<String, List<Card>> sortedStatusMap = new TreeMap<>();

        for (Card card : cards) {
            String status = card.getStatus() != null ? card.getStatus().toUpperCase() : "UNKNOWN";

            statusMap.computeIfAbsent(status, k -> new ArrayList<>()).add(card);
            linkedStatusMap.computeIfAbsent(status, k -> new ArrayList<>()).add(card);
            sortedStatusMap.computeIfAbsent(status, k -> new ArrayList<>()).add(card);
        }

        System.out.println("HashMap (Status): " + statusMap.keySet());
        System.out.println("LinkedHashMap (Status): " + linkedStatusMap.keySet());
        System.out.println("TreeMap (Status): " + sortedStatusMap.keySet());

     
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        for (Card card : cards) {
            if (card.getCardType() != null) {
                hashSet.add(card.getCardType());
                linkedHashSet.add(card.getCardType());
                treeSet.add(card.getCardType());
            }
        }

        System.out.println("HashSet (Card Types): " + hashSet);
        System.out.println("LinkedHashSet (Card Types): " + linkedHashSet);
        System.out.println("TreeSet (Card Types): " + treeSet);

        return cards;
    }

    @Override
    public Card updateCard(Card card) {
        if (card == null || card.getCardId() == null) {
            System.out.println("Card or Card ID is null.");
            return null;
        }

        if (!cardRepository.existsById(card.getCardId())) {
            System.out.println("Card not found for update with ID: " + card.getCardId());
            return null;
        }

        return cardRepository.save(card);
    }

    @Override
    public Card deletecard(String cardNumber) {
        Card card = cardRepository.getBycardNumber(cardNumber);
        if (card == null) {
            System.out.println("Card not found with number: " + cardNumber);
            return null;
        }

        cardRepository.delete(card);
        System.out.println("Card deleted with number: " + cardNumber);
        return card;
    }
}
