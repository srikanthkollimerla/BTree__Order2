package com.strategies;

/**
 * this interface helpts to implement strategy pattern. Two classes are implemented
 * using this interface to sort the elements based on the GPA or Names of the Students.
 */
import java.util.ArrayList;

import com.main.BTree;

public interface Comparator {
	
	
	public int compareTo(Object studentName, Object studentName2);
}
