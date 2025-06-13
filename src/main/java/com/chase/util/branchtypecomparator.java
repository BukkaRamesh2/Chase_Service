package com.chase.util;

import java.util.Comparator;

import com.chase.entity.Branch;

public abstract class branchtypecomparator implements Comparator<Branch> {

	@Override
	public int compare(Branch o1, Branch o2) {
		
		return o1.getBranchId().compareTo(o2.getBranchId());
	}

}