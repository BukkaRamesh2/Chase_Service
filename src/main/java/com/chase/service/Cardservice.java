
package com.chase.service;

import java.util.List;


import com.chase.entity.Card;

public interface Cardservice {

	public Card getCard(String cardNumber);
	public List<Card> getAllCard();
	public Card updateCard(Card card);
	public Card deletecard(String cardNumber);
	public Card addCard(Card card);


}
