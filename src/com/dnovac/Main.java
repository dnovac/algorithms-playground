package com.dnovac;

import com.dnovac.search.BinarySearch;
import com.dnovac.search.QuickSort;
import com.dnovac.structure.MyLinkedList;
import com.dnovac.tree.BinaryTreeImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.random;


public class Main {

  public static void main(String[] args) {

    System.out.println("********* Find Intersection ***********");
    final String[] arrayToUseFindingIntersections = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
    System.out.print(findIntersection(arrayToUseFindingIntersections));

    System.out.println("\n######## begin ############");

    int[] numbers = {1, 20, 22, 102, 101, 1221, 13321, 13331, 0, 11};

    checkPalindromes(numbers);
    playLinkedListImplementation();

    BinaryTreeImpl.Node root = new BinaryTreeImpl.Node(6);
    BinaryTreeImpl binaryTree = buildBinaryTree(root);

    traverseBinaryTreeInAllTheOrders(root);

    // sum of tree
    System.out.println(String.format("========= The sum of tree elements is : %s ================", BinaryTreeImpl.sumOfTreeNodes(root)));

    //anagram
    boolean anagram = anagram("mary", "army");
    System.out.println(String.format("Is anagram? [%s]", anagram));

    //binarysearch
    System.out.println("========== Binary Search List ===========");
    int[] array = IntStream.range(5, 100).toArray();
    BinarySearch.binarySearch(array, 0, array.length - 1, 66);

    //BFS
    System.out.println("========= BFS =========");
    binaryTree.breadthFirstSearch(5);

    //DFS
    System.out.println("========= DFS =========");
    binaryTree.depthFirstSearch(7);

    //Lowest common ancestor
    System.out.println("========= Least Common Ancestor =========");
    binaryTree.lowestCommonAncestor(root, 9, 4);

    reverseLinkedList();

    //Quicksort
    int[] randomArray = IntStream.range((int) random(), 100).toArray();
    List<Integer> randomList = quickSortArray(randomArray);

    int maximumNumber = randomList.stream().mapToInt(value -> value).max().orElseThrow(NoSuchElementException::new);
    int maximumIndex = randomList.indexOf(maximumNumber);
    System.out.println(String.format("MAX is %s at index %s", maximumNumber, maximumIndex));

    //reverse tree
    binaryTree.reverseTreeNodes(root);
    System.out.println("========= Reversed tree inOrder ===========");
    BinaryTreeImpl.inOrder(root);

    System.out.println(String.format("\nMAX height of tree is: %s", binaryTree.maxHeight(root)));
    System.out.println(String.format("\n Height of tree for input data is: %s", binaryTree.heightOfNode(root, 9, 1)));

    System.out.println("===== PRINT NODES AT K DISTANCE FROM ROOT =====");
    BinaryTreeImpl.printKDistant(root, 2);
  }

  private static List<Integer> quickSortArray(int[] randomArray) {

    List<Integer> randomList = Arrays.stream(randomArray).boxed().collect(Collectors.toList());
    Collections.shuffle(randomList);
    Integer[] toBeSortedInteger = randomList.toArray(new Integer[randomList.size()]);
    int[] toBeSorted = new int[randomList.size()];

    for (int i = 0; i < toBeSorted.length; i++) {
      toBeSorted[i] = toBeSortedInteger[i];
    }
    System.out.println("Array to be quicksorted is: " + Arrays.toString(toBeSorted));

    QuickSort quickSort = new QuickSort();
    quickSort.sort(toBeSorted);
    System.out.println("Sorted arrays is: " + Arrays.toString(toBeSorted));
    return randomList;
  }

  private static void reverseLinkedList() {

    LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 5, 6, 3, 4, 2, 9));
    Collections.reverse(linkedList);
    System.out.println("Reversed Linked list: ");
    linkedList.forEach(s -> System.out.print(s + ", "));
    linkedList.sort(Comparator.naturalOrder());
    linkedList.forEach(s -> System.out.println(s + ", "));
  }

  private static void traverseBinaryTreeInAllTheOrders(BinaryTreeImpl.Node root) {

    System.out.println("=========Left-Node-Right========");
    BinaryTreeImpl.inOrder(root);

    System.out.println("\n=========Node-Left-Right========");
    BinaryTreeImpl.preOrder(root);

    System.out.println("\n=========Left-Right-Node========");
    BinaryTreeImpl.postOrder(root);
  }

  private static BinaryTreeImpl buildBinaryTree(BinaryTreeImpl.Node root) {

    BinaryTreeImpl binaryTree = new BinaryTreeImpl(root);
    binaryTree.add(4);
    binaryTree.add(8);
    binaryTree.add(3);
    binaryTree.add(9);
    binaryTree.add(5);
    binaryTree.add(7);
    return binaryTree;
  }

  private static void checkPalindromes(int[] numbers) {

    for (int number : numbers) {
      System.out.println(String.format("Is %s palindrome ? %s", number, isPalindrome(number)));
    }
  }

  private static void playLinkedListImplementation() {

    System.out.println("######## Linked List ############");
    MyLinkedList myLinkedList = new MyLinkedList();
    MyLinkedList.addToTail(myLinkedList, 10);
    MyLinkedList.addToTail(myLinkedList, 20);
    MyLinkedList.addToTail(myLinkedList, 15);
    MyLinkedList.addToTail(myLinkedList, 18);
    MyLinkedList.printList(myLinkedList);
    System.out.println("######### end LinkedList #############");
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

  private static boolean isPalindrome(int number) {

    StringBuilder stringBuilder = new StringBuilder(number);
    if (stringBuilder.length() > 0) {
      int reverse = Integer.parseInt(stringBuilder.reverse().toString());
      return reverse == number;
    }
    return false;
  }

  private static int reverse(int number) {

    int reverse = 0;
    while (number != 0) {
      reverse = reverse * 10 + number % 10;
      number = number / 10;
    }
    return reverse;
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
