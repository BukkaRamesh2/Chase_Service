package com.oops;

public class Main {

	public static void main(String[] args) 
	{
		// Using Encapsulation
        PremiumClient client = new PremiumClient();
        client.setClientId(101);
        client.setClientName("Ashwanth");

        // Using Polymorphism + Abstraction
        ClientService service = new ClientServiceImpl();
        service.register(client);

        // Using Inheritance
        client.showOffer();
	}

}
