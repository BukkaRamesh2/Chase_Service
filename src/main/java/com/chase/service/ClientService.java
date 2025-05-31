package com.chase.service;

import java.util.List;
import com.chase.entity.Client;

public interface ClientService 
{
	public Client addClient(Client client);
	public Client getClient(Long clientId);
	public List<Client> getAllClients();
	public Client updateClient(Client client);
	public Client deleteClient(Long clientId);
	
}