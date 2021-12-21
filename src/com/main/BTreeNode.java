
package com.main;

import java.util.ArrayList;

import com.strategies.Comparator;

/**
 * This Node class contains the information related to a single node
 * and a method that compares the string lexicographically
 * 
 * Additional space for Strings and Nodes are created in every node to act as buffer positions
 * and can be useful in splittng the node when the node gets full. 
 * 
 */
public class BTreeNode<E> implements Node<E> {
  E[] keys = (E[]) new Object[6];
  BTreeNode childNodes[] = new BTreeNode[6];
  boolean isLeafNode = true;
  int count;
  String string;
  public static final int MAX_KEYS = 2;
  public static final int MAX_CHILDREN = 3;
  ArrayList < E > result = new ArrayList < E > ();
  
  public BTreeNode() {
	  for (int i = 0; i < 6; i++) {
	        this.childNodes[i] = NullNode.getInstance();
	        
	  }
  }
  
  public void splitNode(int position,BTreeNode currentNode ) {
	  BTreeNode parentNode = this;
	  splitNode(parentNode, position, currentNode);
  }
  /**
   * This method helps to spilt the node and reassign the child nodes too, if there are any childnodes.
   * @param newNode takes the parameter "newNode" which is created in the "insert" method (datatype: Node)
   * @param pos takes the parameter "position" from which the students are swapped and added (datatype: integer)
   * @param currentNode contains the details in which the entire tree structure is bundled. (datatype: Node)
   * @return unused
   */

  public void splitNode(BTreeNode parentNode, int position, BTreeNode leftNode) {
    BTreeNode rightNode = new BTreeNode();
    rightNode.isLeafNode = leftNode.isLeafNode;
    rightNode.count = MAX_KEYS;
    for (int j = 0; j < MAX_KEYS; j++) {
      rightNode.keys[j] = leftNode.keys[j + MAX_CHILDREN];
    } //transfers all the excess keys to the newly created node.
    if (!leftNode.isLeafNode) {
      for (int j = 0; j < MAX_CHILDREN; j++) {
        rightNode.childNodes[j] = leftNode.childNodes[j + MAX_CHILDREN];
      }
    } //transforms all the child nodes into the newly created node if its not a leaf node.

    leftNode.count = MAX_KEYS;
    for (int j = parentNode.count; j >= position + 1; j--) {
      parentNode.childNodes[j + 1] = parentNode.childNodes[j];
    }
    parentNode.childNodes[position + 1] = rightNode;

    for (int j = parentNode.count - 1; j >= position; j--) {
      parentNode.keys[j + 1] = parentNode.keys[j];
    }
    parentNode.keys[position] = leftNode.keys[MAX_KEYS];
    parentNode.count += 1;
    //adjust the nodes and children in the parent node to include the newly added node.
  }

  /**
   * This method is invoked after initializing the data into student objects and 
   * inserts the newly added node into the appropriate position
   * @param insertedNode this parameter contains the leaf Node/ nonleaf nodes where the new Student records needs to be added (datatype: Node)
   * @param studentName, this parameter contains the student Name that needs to be added
   * @return unused
   */

  public void findNode(BTreeNode insertedNode, E currentKey, Comparator ob) {
    if (insertedNode.isLeafNode) { //checks if the given node is a leaf or not.
      int iterator = 0;
      // the code below helps to find the insert position of the new student. 
      for (iterator = insertedNode.count - 1; iterator >= 0 && ob.compareTo(currentKey, insertedNode.keys[iterator]) < 0; iterator--) {
        insertedNode.keys[iterator + 1] = insertedNode.keys[iterator];
      }
      insertedNode.keys[iterator + 1] = currentKey;
      insertedNode.count = insertedNode.count + 1; //increments the count of the node.
    } else {
      /**
       * if the given node is not a leaf, navigate to its child node and check if the child node is full or empty, 
       * if the child node has space for a new key, perform the insertion operation (using insertvalue method)
       * else split the node and repeat the process recursively
       * until we find a child node that has an empty space to add a new key.
       */
      int iterator = 0;
      for (iterator = insertedNode.count - 1; iterator >= 0 && ob.compareTo(currentKey, insertedNode.keys[iterator]) < 0; iterator--) {};
      iterator++;
      BTreeNode temporaryNode = insertedNode.childNodes[iterator];
      if (temporaryNode.count == 5) {
        splitNode(insertedNode, iterator, temporaryNode);
        if (ob.compareTo(currentKey, insertedNode.keys[iterator]) > 0) {
          iterator++;
        }
      }
      findNode(insertedNode.childNodes[iterator], currentKey, ob);
    }

  }

  public String toStringBuilder() {
	  BTreeNode current = this;
	  string = "";
	  return toStringBuilder(current);

	  }
  
  public String toStringBuilder(BTreeNode node) {
	    
	    for (int i = 0; i < node.getKeysSize(); i++) {
	      string += node.keys[i].toString();
	    }
	    for (int i = 0; i < node.getKeysSize() + 1; i++) {
	      toStringBuilder(node.childNodes[i]);
	    }

	    return string;

	  }
  /**
   * returns the number of child nodes of the current node
   */
@Override
public int getKeysSize() {
	// TODO Auto-generated method stub
	return count;
}

/**
 * returns the key of the mentioned position from the current node.
 */

}




