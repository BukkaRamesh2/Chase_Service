package com.chase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.entity.Client;
import com.chase.repository.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientRepository clientRepository;
	 private List<Client> clientList = new ArrayList<>();
	@Override
	public Client addClient(Client client) {
		if (client != null) {
            clientList.add(client);
            System.out.println("Client added successfully.");
        } else {
            System.out.println("Client is null. Cannot add.");
        }
        return client;
    }

	@Override
	public Client getClient(Long clientId) {
		if (clientId == null) {
            System.out.println("Client ID is null.");
            return null;
        } else if (clientId <= 0) {
            System.out.println("Invalid Client ID.");
            return null;
        } else {
            for (Client client : clientList) {
                // switch used for demo purposes (not ideal for real ID matching)
                switch (clientId.intValue()) {
                    case 1:
                        System.out.println("Looking for ID 1...");
                        break;
                    case 2:
                        System.out.println("Looking for ID 2...");
                        break;
                    default:
                        break;
                }

                if (client.getClientId() == clientId) {
                    System.out.println("Client found.");
                    return client;
                }
            }
            System.out.println("Client not found.");
        }
        return null;
	}

	@Override
	public List<Client> getAllClients() {
		if (clientList.isEmpty()) {
            System.out.println("Client list is empty.");
        } else {
            for (int i = 0; i < clientList.size(); i++) {
                Client c = clientList.get(i);
                System.out.println("Client #" + (i + 1) + ": ID=" + c.getClientId());
            }
        }
        return clientList;
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client deleteClient(Long clientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
