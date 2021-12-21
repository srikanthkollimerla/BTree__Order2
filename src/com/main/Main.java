package com.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.strategies.CompareGpa;
import com.strategies.CompareName;

public class Main {
	  /**
	   * This is the main method which makes the use of all the above methods
	   * @param args Unused
	   * @return nothing
	   */

	  public static void main(String[] args) {

	    //Inserting new records into Btree, Parameters Order: Name, RedId, GPA
	   
	        
	    BTree btree1 = new BTree(new CompareName());
     
        
	    
	    btree1.add(new Student("amra", 82862, 3.0));
        btree1.add(new Student("dwarf", 827876,2.0));
        btree1.add(new Student("kane", 82711, 2.4));
        btree1.add(new Student("william", 83762, 3.6));
        btree1.add(new Student("donald", 8262, 3.1));
        btree1.add(new Student("mike", 5678, 2.3));
        btree1.add(new Student("sean", 12344, 2.5));
        btree1.add(new Student("sunny", 57678, 2.8));
        btree1.add(new Student("dube", 8979, 2.9));
        btree1.add(new Student("smith", 8266, 3.5));
        btree1.add(new Student("tommy", 1245, 3.9));
        btree1.add(new Student("harris", 1890, 2.2));
        btree1.add(new Student("zara", 5467, 1.2));
        btree1.add(new Student("boult", 9809, 1.8));
        btree1.add(new Student("trent", 4535, 3.7));
        btree1.add(new Student("mary", 9659, 4));
        
        //System.out.println("After change");
        /*Iterator i = btree1.iterator();
        while(i.hasNext()) {
        	System.out.println("next : "+i.next());
        }*/
        //System.out.println("tree "+btree1.toString());
        
	  }
	  
}
