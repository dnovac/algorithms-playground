package com.dnovac;

public class Main {

  public static void main(String[] args) {

    System.out.println("######## begin ############");

    playLinkedListImplementation();

    System.out.println("######### end #############");
  }

  private static void playLinkedListImplementation() {

    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 10);
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 20);
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 15);
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 18);
    MyLinkedList.printList(myLinkedList);
  }

}
