package com.strategies;

import java.util.ArrayList;

import com.main.BTree;
import com.main.Student;

/**
 * this class helps to compare the student name lexicographically of two Student objects and returns in
 * ascending order.
 * @author srika
 *
 */
public class CompareName implements Comparator{
	
	@Override
	public int compareTo(Object s2, Object s) {
		return ((Student) s2).getName().compareTo(((Student) s).getName());
		
	}
	
}
