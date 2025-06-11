package com.chase.util;

import java.util.Comparator;

import com.chase.entity.Account;

public class AccountBalanceComparator implements Comparator<Account>{

	public AccountBalanceComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return o1.getBalance().compareTo(o2.getBalance());
	}

}
