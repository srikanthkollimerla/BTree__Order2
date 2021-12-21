package com.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.strategies.CompareGpa;
import com.strategies.CompareName;

class BTreeTest {

	BTree<Student> btree1;
	
	BTree<Student> btree2;
	
	@BeforeEach
	void setUp() {
		btree1 = new BTree<Student>(new CompareGpa());
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
	        
	        btree2 = new BTree<Student>(new CompareName());
	        btree2.add(new Student("donald", 1, 3.0));
	        btree2.add(new Student("zara", 2,2.0));
	        btree2.add(new Student("mary", 3, 2.4));
	        btree2.add(new Student("dube", 4, 3.6));
	        btree2.add(new Student("stuart", 5, 2.3));
	}

	@Test
	void testAdd2() {
		assertEquals(btree1.add(new Student("dane", 12, 3.5)),btree1.add(new Student("perry", 56, 3.4)) );
	}
	
	@Test
	void testAdd() {
		assertEquals(btree2.add(new Student("nelson", 8262, 3.3)),btree2.add(new Student("walker", 567, 3.4)) );
	}
	
	@Test
	void testToString() {
		assertNotNull(btree1.toString());
	}
	
	@Test
	void testToArray() {
		assertNotNull(btree2.toArray());
	}
	
	@Test
	void testForEach() {
		btree1.forEach(item -> assertNotNull(item.toString()));
	}

	@Test
	void testNext() {
		Iterator iter = btree1.iterator();
		if(iter.hasNext()) {
			Student s = (Student) iter.next();
			assertEquals(s.getGpa(),4);
		}
	}

}
