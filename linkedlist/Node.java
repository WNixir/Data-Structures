package com.nixir.linkedlist;

public class Node {

  Node next;
  private int data;
  private int size;

  public Node(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void recAppend(Node newNode) {
    // add a new Node to the end of the list recursively
    if (this.next == null) {
      this.next = newNode;
    } else {
      this.next.recAppend(newNode);
    }
  }
}
