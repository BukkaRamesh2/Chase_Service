package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Card;
import com.chase.service.Cardservice;
@RestController
@RequestMapping

public class Cardcontroller {
	public Cardcontroller() {
		
	}
	
	@Autowired
	
	Cardservice crdService;
	
	@PostMapping
	public Card addCard(Card card) {
		return crdService.addCard(card);
	}
	
	@GetMapping
	public Card getCard(String cardNumber) {
		return crdService.getCard(cardNumber);
	}
	
	
	@GetMapping
	public List<Card> getAllCards() {
		return crdService.getAllCard();
	}
	
	@PutMapping
	public Card updateCard(Card card) {
		return crdService.updateCard(card);
		}
	
	@DeleteMapping
	public Card deleteCard(String cardnumber) {
		return crdService.deletecard(cardnumber);
	}
	
	
	

}
