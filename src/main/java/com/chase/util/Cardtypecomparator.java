package com.chase.util;

import java.util.Comparator;

import com.chase.entity.Card;

public abstract class Cardtypecomparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return o1.getCardType().compareToIgnoreCase(o2.getCardType());
	}

}