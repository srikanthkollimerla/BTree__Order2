/*************************************
 * 
 * Assignment-2
 * Srikanth Kollimerla
 * RedId: 825852359
 * 
 **************************************/

/**
 * The BTree program stores the student details lexicographically
 * and performs the following actions:
 * 
 * <ul> 
 *      <li>Returns the k'th element in the B-tree in lexicographical order. If k is
 *      out-of-bounds throw an exception.</li>
 *      <li>Print out the Red Ids of the students that are on probation (GPA less than 2.85) that in the
 *      list from the front to the back of the list.</li>
 *      <li>Print out the names of the students with GPA of 4.0 in the list from the back to the front of the 
 *      list</li>
 * </ul>
 */
package com.main;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.strategies.Comparator;

public class BTree < E > extends AbstractSet < E > {
  private Comparator comparator;
  private BTreeNode root;

  public BTree(Comparator ob) {
    this.comparator = ob;
    root = new BTreeNode();
    root.count = 0;
    root.isLeafNode = true;
  }

  /**
   * This method initialize the student details into the student node.
   * and then check if the node is filled with keys or not.
   *     if the given node is full, split method is called to break the node and create the new nodes
   * 
   *     if the given node is empty, then the new student element is added directly to the existing node.  
   * 
   * @param key this parameter accepts student's name (datatype: String)
   * @param redId this parameter accepts students redid (datatype: integer)
   * @param gpa this parameter accepts gpa as input (datatype: float)
   * @return unused
   */
  @Override
  public boolean add(E e) {
    BTreeNode currentNode = root;
    if (currentNode.count == 5) { //  keys are stored in buffer and used in split function when buffer is full.
      BTreeNode newNode = new BTreeNode();
      root = newNode;
      newNode.isLeafNode = false;
      newNode.count = 0;
      newNode.childNodes[0] = currentNode;

      root.splitNode(0, currentNode);
      root.findNode(newNode, e, comparator);
    } else {
      root.findNode(currentNode, e, comparator);
    }
    return true;
  }

  /**
   * This method returns the details of the all the nodes in the BTree in string data type.
   * 
   */
  @Override
  public String toString() {
	  //root.setNull();
    String result = root.toStringBuilder();
    return result;

  }


 /**
  * This method returns all the nodes of the BTree in Object datatype.
  */

  @Override
  public Object[] toArray() {
	  ArrayList<E> result= new ArrayList<E>();
	  Iterator iterator = this.iterator();
	   while (iterator.hasNext()) {
		   result.add((E) iterator.next());
	   }
    return result.toArray();
  }

  
/**
 * This method uses internal iterator and process all the elements in order traversal.
 */
  @Override
  public void forEach(Consumer action) {
   Objects.requireNonNull(action);
   Stack < E > nodes = new Stack < E > ();
   
   Iterator iterator = this.iterator();
   while (iterator.hasNext()) {
	   nodes.push((E) iterator.next());
   }
   while (!nodes.isEmpty()) {
      action.accept(nodes.pop());
    }

  }

  

  @Override
  public Iterator iterator() {
    return new Iter();
  }

  /**
   * 
   * @author srika
   *This class helps to override the iterator and navigate the BTree in inorder
   */
  private final class Iter implements Iterator {


    private Stack < BTreeNode > nodeStack;
    private Stack < Integer > positionStack;


    public Iter() {
      nodeStack = new Stack < > ();
      positionStack = new Stack < > ();
      if (root.count > 0)
        pushToLeftPath(root);
    }

    /**
     * checks if the Stack is empty or not in order to process the next element
     */
    public boolean hasNext() {
      return !nodeStack.isEmpty();
    }

    /**
     * this method helps to process the next element and returns to the client
     */
    public E next() {
      if (!hasNext())
        throw new NoSuchElementException();

      BTreeNode node = nodeStack.peek();
      int index = positionStack.pop();
      E result = (E) node.keys[index];
      index++;
      if (index < node.count)
        positionStack.push(index);
      else
        nodeStack.pop();
      if (!node.isLeafNode)
        pushToLeftPath(node.childNodes[index]);
      //pushToLeftPath()
      return result;
    }

    /**
     * helper function for the iterator method,
     * helps to push all the leftNodes to the Stacks
     * @param node input type is Node data type
     */

    private void pushToLeftPath(BTreeNode node) {
      while (true) {
        nodeStack.push(node);
        positionStack.push(0);
        if (node.isLeafNode)
          break;
        node = node.childNodes[0];
      }
    }

  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

}