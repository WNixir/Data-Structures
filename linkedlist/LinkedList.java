package com.nixir.linkedlist;

public class LinkedList {

  private Node head;
  private int size = 0;

  @Override
  public String toString() {
    String listStr = "";
    Node current = head;

    // if the list is none-empty, loop
    // over each Node and print its data
    if (current != null) {
      listStr = String.valueOf(current.getData());
      while (current.next != null) {
        listStr = listStr + "->" + String.valueOf(current.next.getData());
        current = current.next;
      }
    }
    return listStr;
  }

  /**
   * appends a new node to the end of the LinkedList
   *
   * @param data the data in the new node
   */
  public void append(int data) {
    Node newNode = new Node(data);

    // if the list is empty, newNode is the head
    if (head == null) {
      head = newNode;
      size += 1;
    } else {
      Node current = head;
      // find the end of the list
      while (current.next != null) {
        current = current.next;
      }
      // point the last Node to newNode
      current.next = newNode;
      size += 1;
    }
  }

  public void recAppend(int data) {
    Node headNode = this.getHeadNode();
    Node newNode = new Node(data);

    // if current is empty, make newNode new head
    if (headNode == null) {
      head = newNode;
    } else {
      headNode.recAppend(newNode);
    }
  }

  /**
   * adds a new node to the head of the LinkedList
   *
   * @param data data in the new node
   */
  public void prepend(int data) {
    Node newHead = new Node(data);

    // if the list is empty, newNode is the new head
    if (head == null) {
      head = newHead;
      size += 1;
    } else {
      // point newHead to old head
      // change head pointer to newHead
      newHead.next = head;
      head = newHead;
      size += 1;
    }
  }

  /**
   * returns a reference to the Node at given index
   *
   * @param index the Node at wanted index
   * @return reference to the Node
   */
  public Node findIndex(int index) {
    Node current = head;
    int currentIndex = 0;

    while (currentIndex < index) {
      current = current.next;
      currentIndex += 1;
    }
    return current;
  }

  /**
   * insert a data at a given index in a linked list
   *
   * @param data new data to be inserted into the linked list
   * @param index the index at which the data is to be inserted
   */
  public void insert(int data, int index) {
    Node newNode = new Node(data);
    Node current;
    Node next;

    if (index == 0) {
      this.prepend(data);
    } else {
      current = this.findIndex(index - 1);
      next = current.next;
      current.next = newNode;
      newNode.next = next;
    }
  }

  /**
   * finds and removes the first node containing the data we want to delete from the LinkedList
   *
   * @param data the data we want to remove
   */
  public void delete(int data) {
    // nothing to delete for an empty list
    if (head != null) {
      // if head contains the data, remove head
      if (head.getData() == data) {
        head = head.next;
        size -= 1;
      } else {
        Node current = head;
        while (current.next != null) {
          // if current.next is the Node we want to remove
          // point current to the Node after it
          if ((current.next.getData() == data)
              && (current.next.next != null)) {
            current.next = current.next.next;
            size -= 1;
          } else if ((current.next.getData() == data)
              && (current.next.next == null)) {
            current.next = null;
            size -= 1;
          }
          if (current.next != null) {
            current = current.next;
          }
        }
      }
    }
  }

  /**
   * @return the number of nodes in the List as an int
   */
  public int getSize() {
    return size;
  }

  /**
   * @return the head Node of current List
   */
  public Node getHeadNode() {
    return head;
  }

  /**
   * find the mid Node in a linked list
   *
   * @return the pointer to the mid point of linked list
   */
  public Node findMiddle() {
    Node slowPointer = head;
    Node fastPointer = head;

    if (head != null) {
      while ((fastPointer != null) && (fastPointer.next != null)) {
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
      }
    }
    return slowPointer;
  }

}
