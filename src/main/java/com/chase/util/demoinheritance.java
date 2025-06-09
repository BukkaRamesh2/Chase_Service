package com.chase.util;

import com.chase.entity.Card;

public class demoinheritance extends Card {

    public static void main(String[] args) {
        demoinheritance demoCard = new demoinheritance();
        demoCard.setCardId("1234-5678-9876-5432");
        demoCard.displayDetails();
    }

    private void setCardId(String string) {
		// TODO Auto-generated method stub
		
	}

	public void displayDetails() {
        System.out.println("Card Type: " + getCardType());
        System.out.println("Card Number: " + getCardId());
    }

	
}
