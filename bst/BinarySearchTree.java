package com.nixir.bst;

public interface BinarySearchTree {

  /**
   * get the root node of current BST
   *
   * @return the root node
   */
  public BSTNode getRoot();

  /**
   * get the size, defined by the number of Nodes in the BST
   *
   * @return the number of Nodes as an int
   */
  public int size();

  /**
   * Insert a new integer value into a BST
   *
   * @param data the new data to be inserted
   */
  public void insert(int data);

  /**
   * Insert a new integer value into an existing BST recursively
   *
   * @param data the new data to be inserted
   */
  public void recInsert(int data);

  /**
   * remove the data from an existing BST and return the new root
   *
   * @param data the data to be removed
   * @return the new root of the BST
   */
  public BSTNode remove(int data);

  /**
   * returns the height of the BST
   *
   * @return the height of the BST as an int
   */
  public int height(BSTNode root);

  /**
   * Check if an given value is in the BST
   *
   * @param data an integer value to be searched
   * @return true if the value is in the BST, false otherwise
   */
  public boolean search(int data);

  /**
   * get the Min value from the BST
   *
   * @return the min value as an Int
   */
  public int getMin();

  /**
   * get the Max value from the BST
   *
   * @return the max value as an Int
   */
  public int getMax();

  /**
   * Return a string that represents the pre-order traversal of BST
   */
  public void preOrderTraversal(BSTNode root);

  /**
   * Return a string that represents the post-order traversal of BST
   */
  public void postOrderTraversal(BSTNode root);

  /**
   * Return a string that represents the in-order traversal of BST
   */
  public void inOrderTraversal(BSTNode root);

}
