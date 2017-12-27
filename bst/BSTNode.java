package com.nixir.bst;

public class BSTNode {

  BSTNode rightChild;
  BSTNode leftChild;
  private int data;

  public BSTNode(int data) {
    this.data = data;
  }

  public int getData() {
    return this.data;
  }

  /**
   * Search for the given data in the BST recursively
   *
   * @param data the Node containing the data
   * @return true iff the data is present in BST
   */
  public boolean recSearch(int data) {
    boolean result = false;

    // if current Node is the dataNode return true
    if (this.getData() == data) {
      result = true;

      // else if the current Node's data is greater
      // than dataNode's data
    } else if (this.getData() > data) {
      // look for the dataNode in left subtree
      if (this.leftChild != null) {
        result = this.leftChild.recSearch(data);
      } else {
        result = false;
      }

      // else if the current Node's data is smaller
      // than the dataNode's data
    } else if (this.getData() < data) {
      // look for the dataNode in right subtree
      if (this.rightChild != null) {
        result = this.rightChild.recSearch(data);
      } else {
        result = false;
      }
    }
    return result;
  }

  /**
   * Insert a new data node into an existing BST recursively
   *
   * @param newData new data to be inserted
   */
  public void recInsert(int newData) {
    // check the left sub tree
    if (this.getData() > newData) {
      if (this.leftChild != null) {
        this.leftChild.recInsert(newData);
      } else {
        this.leftChild = new BSTNode(newData);
      }
    } else {
      // check the right sub tree
      if (this.rightChild != null) {
        this.rightChild.recInsert(newData);
      } else {
        this.rightChild = new BSTNode(newData);
      }
    }
  }

  /**
   * Find the minimum value of the BST
   *
   * @return the minimum value of BST as an integer
   */
  public int findMin() {
    int minimum;
    // look for the left most node
    if (this.leftChild != null) {
      minimum = this.leftChild.findMin();
    } else {
      minimum = this.getData();
    }
    return minimum;
  }

  /**
   * Find the max value in a BST
   *
   * @return the max value in a BST as an integer
   */
  public int findMax() {
    int max;
    if (this.rightChild != null) {
      max = this.rightChild.findMax();
    } else {
      max = this.getData();
    }
    return max;
  }

  /**
   * Find the size of BST
   *
   * @param root the root Node
   * @return the size of BST as an integer
   */
  public int recGetSize(BSTNode root) {
    int size;
    // if tree is empty return 0
    if (root == null) {
      size = 0;
      // else recurse on right and left subtrees
    } else {
      size = recGetSize(root.rightChild) + recGetSize(root.leftChild) + 1;
    }
    return size;
  }

  public BSTNode recRmove(BSTNode root, int data) {
    if (root == null) {
      return null;
    }
    if (root.getData() > data) {
      root.leftChild = recRmove(root.leftChild, data);
    } else if (root.getData() < data) {
      root.rightChild = recRmove(root.rightChild, data);

    } else {
      // if nodeToBeDeleted have both children
      if (root.leftChild != null && root.rightChild != null) {
        BSTNode tempNode = root;
        // Finding minimum element from right
        BSTNode minNodeForRight = new BSTNode(tempNode.rightChild.findMin());
        // Replacing current node with minimum node from right subtree
        root.data = minNodeForRight.getData();
        // Deleting minimum node from right now
        recRmove(root.rightChild, minNodeForRight.getData());
      }
      // if nodeToBeDeleted has only left child
      else if (root.leftChild != null) {
        root = root.leftChild;
      }
      // if nodeToBeDeleted has only right child
      else if (root.rightChild != null) {
        root = root.rightChild;
      }
      // if nodeToBeDeleted do not have child (Leaf node)
      else {
        root = null;
      }
    }
    return root;
  }
}
