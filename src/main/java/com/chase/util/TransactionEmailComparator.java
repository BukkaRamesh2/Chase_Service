package com.chase.util;
import java.util.Comparator;

import com.chase.entity.Transaction;

public class TransactionEmailComparator implements Comparator<Transaction> {
  


	@Override
	public int compare(Transaction t1, Transaction t2) {
		// TODO Auto-generated method stub
		return t1.getEmail().compareToIgnoreCase(t2.getEmail());
	}
}