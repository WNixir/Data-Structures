package com.nixir.bst;

public class BSTImpl implements BinarySearchTree {

  // initialize the root pointer
  private BSTNode root;

  @Override
  public BSTNode getRoot() {
    return this.root;
  }

  @Override
  public int size() {
    return root.recGetSize(root);
  }

  @Override
  public void insert(int data) {
    BSTNode currentNode = root;
    BSTNode parentNode = null;
    BSTNode newNode = new BSTNode(data);

    // look for the parent of newNode
    while (currentNode != null) {
      parentNode = currentNode;
      if (currentNode.getData() > data) {
        currentNode = currentNode.leftChild;
      } else {
        currentNode = currentNode.rightChild;
      }
    }

    // insert the newNode into the BST
    if (parentNode == null) {
      this.root = newNode;
    } else {
      if (parentNode.getData() > data) {
        parentNode.leftChild = newNode;
      } else {
        parentNode.rightChild = newNode;
      }
    }
  }

  @Override
  public void recInsert(int data) {
    root.recInsert(data);
  }

  @Override
  public BSTNode remove(int data) {
    return root.recRmove(root, data);
  }

  public int max(int a, int b) {
    if (a >= b) {
      return a;
    } else {
      return b;
    }
  }

  @Override
  public int height(BSTNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + max(height(root.rightChild), height(root.leftChild));
    }
  }

  @Override
  public boolean search(int data) {
    return root.recSearch(data);
  }

  @Override
  public int getMin() {
    return this.root.findMin();
  }

  @Override
  public int getMax() {
    return this.root.findMax();
  }

  @Override
  public void preOrderTraversal(BSTNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.getData() + " ");
    preOrderTraversal(root.leftChild);
    preOrderTraversal(root.rightChild);
  }

  @Override
  public void postOrderTraversal(BSTNode root) {
    if (root == null) {
      return;
    }
    postOrderTraversal(root.leftChild);
    postOrderTraversal(root.rightChild);
    System.out.print(root.getData() + " ");
  }

  @Override
  public void inOrderTraversal(BSTNode root) {
    if (this.root == null) {
      return;
    }
    inOrderTraversal(root.leftChild);
    System.out.print(root.getData() + " ");
    inOrderTraversal(root.rightChild);
  }

}