package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Card;
import com.chase.service.Cardservice;
@RestController
@RequestMapping("/card")
public class Cardcontroller {
	public Cardcontroller() {
		
	}
	
	@Autowired
	Cardservice cardService;
	
	@PostMapping("/addcard")
	public Card addCard(@RequestBody Card card) {
		return cardService.addCard(card);
	}
	
	@GetMapping("getCard/{cardNumber}")
	public Card getCard(@PathVariable String cardNumber) {
		return cardService.getCard(cardNumber);
	}
	
	
	@GetMapping("/getAllcards")
	public List<Card> getAllCards() {
		return cardService.getAllCard();
	}
	
	@PutMapping("/updateCard")
	public Card updateCard(@RequestBody Card card) {
		return cardService.updateCard(card);
		}
	
	@DeleteMapping("/deletecards/{cardnumber}")
	public Card deleteCard(@PathVariable String cardnumber) {
		return cardService.deletecard(cardnumber);
	}
	
	 
	

}
