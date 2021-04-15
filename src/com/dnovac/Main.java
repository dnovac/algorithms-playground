package com.dnovac;

import com.dnovac.tree.BinaryTreeImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

  public static void main(String[] args) {

    System.out.println("********* Find Intersection ***********");
    final String[] arrayToUseFindingIntersections = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
    System.out.print(findIntersection(arrayToUseFindingIntersections));

    System.out.println("\n######## begin ############");
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
    System.out.println("\n=========Left-Node-Right========");
    BinaryTreeImpl.inOrder(root);

    System.out.println("\n=========Node-Left-Right========");
    BinaryTreeImpl.preOrder(root);

    System.out.println("\n=========Left-Right-Node========");
    BinaryTreeImpl.postOrder(root);

    // sum of tree
    int sumOfTreeNodes = BinaryTreeImpl.sumOfTreeNodes(root);
    System.out
      .println("\n========= The sum of tree elements is : " + sumOfTreeNodes + " ================");

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

  private static String findIntersection(String[] strArr) {
    // code goes here
    List<String> strings = new ArrayList<>();
    Set<String> set = new HashSet<>();
    Set<String> setToReturn = new HashSet<>();

    for (String array : strArr) {
      strings.addAll(Arrays.asList(array.split(",")));
    }

    for (String number : strings) {
      if (!set.add(number)) {
        setToReturn.add(number);
      }
    }

    return setToReturn.toString();
  }

}
