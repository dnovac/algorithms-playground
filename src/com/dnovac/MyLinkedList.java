package com.dnovac;

public class MyLinkedList {

  Node head;

  //Linked List implementation
  //every node has a value and a pointer to the next node
  //head is the first node, tail is the last one and the last one has next = null
  //every new node knows about the next one
  static class Node {

    int value;
    Node next;

    public Node(int value) {

      this.value = value;
      this.next = null;
    }

  }


  //insert a new Node
  public static MyLinkedList addToTail(MyLinkedList list, int value) {

    Node toInsert = new Node(value);
    toInsert.next = null; //because it has to be the tail (last node)

    // If the Linked List is empty,
    // then make the new node as head
    if (list.head == null) {
      list.head = toInsert;
    } else {
      // Else traverse till the last node
      // and insert the new_node there
      Node last = list.head;
      while (last.next != null) {
        last = last.next;
      }
      // Insert the new_node at last node
      last.next = toInsert;
    }
    return list;
  }

  //get

  //getByIndex

  //delete


  public static void printList(MyLinkedList list) {

    Node currentnode = list.head;

    System.out.println("LinkedList: ");

    while (currentnode != null) {
      System.out.println("Node: " + currentnode.value);
      currentnode = currentnode.next;
    }
  }

}
