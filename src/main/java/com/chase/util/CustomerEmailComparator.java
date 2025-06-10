package com.chase.util;

import java.util.Comparator;

import com.chase.entity.Customer;

public class CustomerEmailComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
	
		return o1.getEmail().compareToIgnoreCase(o2.getEmail());
	}

}
