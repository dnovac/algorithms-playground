package com.dnovac;

import com.dnovac.tree.BinaryTreeImpl;
import com.dnovac.tree.Node;


public class Main {

  public static void main(String[] args) {

    System.out.println("######## begin ############");
    playLinkedListImplementation();
    System.out.println("######### end #############");

    System.out.println("================= SUM TREE ==================");
    Node root = new Node(2);
    root.setLeft(new Node(3, new Node(5), new Node(6)));
    root.setRight(new Node(4));

    BinaryTreeImpl binaryTree = new BinaryTreeImpl();
    int sumOfTreeNodes = binaryTree.sumOfTreeNodes(root);
    System.out.println("SUM IS: " + sumOfTreeNodes);

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
