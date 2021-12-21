package com.main;

/**
 * This Node class contains the information related to a null node
 * and special helper methods to handle the edge cases.
 */
public class NullNode extends BTreeNode {

  private static final NullNode instance = new NullNode();

  /**
   * this method returns the size as -1 for handling the end nodes properly
   */
  @Override
  public int getKeysSize() {
    // TODO Auto-generated method stub
    return -1;
  }


  public static NullNode getInstance() {
    return instance;
  }


}