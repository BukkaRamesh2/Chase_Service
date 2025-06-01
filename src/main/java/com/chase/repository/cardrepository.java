package com.chase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chase.entity.Card;

@Repository
public interface cardrepository extends JpaRepository<Card,Long>{

	Object findByCardNumber(String cardNumber);

	Card getBycardNumber(String cardNumber);

}
