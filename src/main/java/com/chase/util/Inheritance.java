package com.chase.util;

import com.chase.entity.Branch;

public class Inheritance extends Branch {

    public static void main(String[] args) {
        Inheritance demoCard = new Inheritance();
        demoCard.setCardId("1234-5678-9876-5432");
        demoCard.displayDetails();
    }

    private void setCardId(String string) {
		// TODO Auto-generated method stub
		
	}

	public void displayDetails() {
        System.out.println("Branch Type: " + getBranchId());
        System.out.println("Branch Number: " + getCode());
    }

	
}