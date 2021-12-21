package com.strategies;

/**
 * this class helps to compare the GPA of two Student objects and returns in
 * descending order.
 */

import java.util.ArrayList;

import com.main.BTree;
import com.main.Student;

public class CompareGpa implements Comparator{
	
	
	@Override
	public int compareTo(Object s, Object s2) {
		return ((Student) s).getGpa() > ((Student) s2).getGpa() ? -1 : 1;
	}
	
	
	
}
