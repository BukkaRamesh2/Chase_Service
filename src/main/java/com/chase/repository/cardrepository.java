package com.chase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chase.entity.Card;

public interface cardrepository extends JpaRepository<Card,Long>{

	Object findByCardNumber(String cardNumber);

	Card getBycardNumber(String cardNumber);

}
