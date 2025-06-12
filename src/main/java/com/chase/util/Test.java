package com.chase.util;

import com.chase.entity.Card;

public class Test {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t3 = new Test();

        t1.test();
        t1.testinfo();
        t3.test();

        // Example use if needed:
        Card card = new Card();
        card.setCardId(Long.parseLong("1234"));
        card.setCardNumber("9876-5432-1234-5678");
        card.setCardType("Credit");

        System.out.println("Card ID: " + card.getCardId());
        System.out.println("Card number: " + card.getCardNumber());
        System.out.println("Card Type: " + card.getCardType());
    }

    public void testinfo() {
        System.out.println("Preethi");
    }

    public void test() {
        System.out.println("Hello in Test class");
    }
}
