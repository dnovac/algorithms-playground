package com.dnovac;

import com.dnovac.tree.BinaryTreeImpl;

import java.util.List;
import java.util.stream.Collectors;


public class Main {

  public static void main(String[] args) {

    System.out.println("######## begin ############");
    playLinkedListImplementation();
    System.out.println("######### end #############");

    BinaryTreeImpl.Node root = new BinaryTreeImpl.Node(6);
    BinaryTreeImpl binaryTree = new BinaryTreeImpl(root);
    binaryTree.add(4);
    binaryTree.add(8);
    binaryTree.add(3);
    binaryTree.add(9);
    binaryTree.add(5);
    binaryTree.add(7);

    //traversions
    System.out.println("=========Left-Node-Right========");
    BinaryTreeImpl.inOrder(root);

    System.out.println("\n=========Node-Left-Right========");
    BinaryTreeImpl.preOrder(root);

    System.out.println("\n=========Left-Right-Node========");
    BinaryTreeImpl.postOrder(root);

    // sum of tree
    int sumOfTreeNodes = BinaryTreeImpl.sumOfTreeNodes(root);
    System.out.println("========= The sum of tree elements is : " + sumOfTreeNodes + " ================");

    //anagram
    System.out.println("is anagram? " + anagram("mary", "army"));

  }

  private static void playLinkedListImplementation() {

    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 10);
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 20);
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 15);
    myLinkedList = MyLinkedList.addToTail(myLinkedList, 18);
    MyLinkedList.printList(myLinkedList);
  }

  private static boolean anagram(String s1, String s2) {

    List<Character> s1Characters = s1.chars()
            .mapToObj(value -> (char) value)
            .sorted()
            .collect(Collectors.toList());
    List<Character> s2Characters = s2.chars()
            .mapToObj(value -> (char) value)
            .sorted()
            .collect(Collectors.toList());

    System.out.println(s1Characters);
    System.out.println(s2Characters);
    return s1Characters.equals(s2Characters);


  }

}
