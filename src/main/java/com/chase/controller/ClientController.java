package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Client;
import com.chase.service.ClientService;
@RestController
@RequestMapping
public class ClientController {
	
	@Autowired
	ClientService clientService;
	@PostMapping
	public Client addClient(Client client) {
		return clientService.addClient(client);
	}
	@GetMapping
	public Client getClient(Long clientId) {
		return clientService.getClient(clientId);
	}
	@GetMapping
	public List<Client> getAllClients(){
		return clientService.getAllClients();
	}
	@PutMapping
	public Client updateClient(Client client) {
		return clientService.updateClient(client);
	}
	@DeleteMapping
	public Client deleteClient(Long clientId) {
		return clientService.deleteClient(clientId);
	}

}
