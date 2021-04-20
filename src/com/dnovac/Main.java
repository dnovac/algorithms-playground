package com.dnovac;

import static java.lang.Math.random;

import com.dnovac.search.BinarySearch;
import com.dnovac.search.QuickSort;
import com.dnovac.structure.MyLinkedList;
import com.dnovac.tree.BinaryTreeImpl;
import com.sun.jdi.InvalidTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

  public static void main(String[] args) {

    System.out.println("********* Find Intersection ***********");
    final String[] arrayToUseFindingIntersections = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
    System.out.print(findIntersection(arrayToUseFindingIntersections));

    System.out.println("\n********* Reverse String ***********");
    String toBeReversed = "abcxedf123";
    String[] toBeReserved = {"a", "b", "c", "8", "1"};
    System.out.println("Reversed String: " + reverse(toBeReversed) + "");
    System.out.println("Reversed String Array: " + reverseArray(toBeReserved));

    System.out.println("********** Longest Word **********");
    String testLongestWordCase = "fun&!! time";
    System.out.printf("Longest word from \"%s\" is %s\n", testLongestWordCase,
      longestWord(testLongestWordCase));

    System.out.println("\n********** Mean-Mode *************");
    final int[] meanModeTest = {5, 3, 3, 3, 1};
    try {
      System.out.printf("\nMean-Mode is: %s", meanMode(meanModeTest));
    } catch (InvalidTypeException e) {
      e.printStackTrace();
    }

    System.out.println("\n######## begin ############");

    int[] numbers = {1, 20, 22, 102, 101, 1221, 13321, 13331, 0, 11};

    checkPalindromes(numbers);
    playLinkedListImplementation();

    BinaryTreeImpl.Node root = new BinaryTreeImpl.Node(6);
    BinaryTreeImpl binaryTree = buildBinaryTree(root);

    traverseBinaryTreeInAllTheOrders(root);

    // sum of tree
    System.out.println(String.format("========= The sum of tree elements is : %s ================",
      BinaryTreeImpl.sumOfTreeNodes(root)));

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

    int maximumNumber = randomList.stream().mapToInt(value -> value).max()
      .orElseThrow(NoSuchElementException::new);
    int maximumIndex = randomList.indexOf(maximumNumber);
    System.out.println(String.format("MAX is %s at index %s", maximumNumber, maximumIndex));

    //reverse tree
    binaryTree.reverseTreeNodes(root);
    System.out.println("========= Reversed tree inOrder ===========");
    BinaryTreeImpl.inOrder(root);

    System.out.println(String.format("\nMAX height of tree is: %s", binaryTree.maxHeight(root)));
    System.out.println(String
      .format("\n Height of tree for input data is: %s", binaryTree.heightOfNode(root, 9, 1)));

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

  /**
   * Find Intersection Have the function FindIntersection(strArr) read the array of strings stored
   * in strArr which will contain 2 elements: the first element will represent a list of
   * comma-separated numbers sorted in ascending order, the second element will represent a second
   * list of comma-separated numbers (also sorted). Your goal is to return a comma-separated string
   * containing the numbers that occur in elements of strArr in sorted order. If there is no
   * intersection, return the string false. Examples Input: new String[] {"1, 3, 4, 7, 13", "1, 2,
   * 4, 13, 15"} Output: 1,4,13
   *
   * @param strArr
   * @return string to match the output https://coderbyte.com/editor/Find%20Intersection:Java
   */
  private static String findIntersection(String[] strArr) {
    // code goes here
    List<String> strings = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    Set<Integer> setToReturn = new HashSet<>();
    StringBuilder stringBuilder = new StringBuilder();

    for (String array : strArr) {
      strings.addAll(Arrays.asList(array.split(",")));
    }

    final List<Integer> collect = strings.stream()
      .map(s -> Integer.valueOf(s.stripLeading()))
      .sorted()
      .collect(Collectors.toList());

    for (Integer number : collect) {
      if (!set.add(number)) {
        setToReturn.add(number);
        stringBuilder.append(number.toString()).append(",");
      }
    }

    return stringBuilder.toString();
  }

  private static String reverse(String toBeReversed) {
    StringBuilder reversed = new StringBuilder();
    for (int i = toBeReversed.length() - 1; i >= 0; i--) {
      reversed.append(toBeReversed.charAt(i));
    }
    return reversed.toString();
  }

  /**
   * Have the function FirstReverse(str) take the str parameter being passed and return the string
   * in reversed order. For example: if the input string is "Hello World and Coders" then your
   * program should return the string sredoC dna dlroW olleH.
   */
  private static String reverseArray(String[] toBeReversed) {
    StringBuilder reversed = new StringBuilder();
    for (int i = toBeReversed.length - 1; i >= 0; i--) {
      reversed.append(toBeReversed[i]);
    }
    return reversed.toString();
  }

  /**
   * Longest Word Have the function LongestWord(sen) take the sen parameter being passed and return
   * the longest word in the string. If there are two or more words that are the same length, return
   * the first word from the string with that length. Ignore punctuation and assume sen will not be
   * empty. Words may also contain numbers, for example "Hello world123 567" Examples Input:
   * "fun&!!time" Output: time Input: "I love dogs" Output: love
   *
   * @param sen
   * @return longest word
   */
  private static String longestWord(String sen) {
    String sanitizedSen = Pattern.compile("[^a-z^A-Z^ ]").matcher(sen).replaceAll("").toLowerCase();
    String[] senWords = sanitizedSen.split(" ");
    String longestWord = senWords[0];

    for (String senWord : senWords) {
      if (senWord.length() > longestWord.length()) {
        longestWord = senWord;
      }
    }
    return longestWord;
  }


  /* https://coderbyte.com/question/mean-mode
   *  Have the function MeanMode(arr) take the array of numbers stored in arr and         *
   *  return 1 if the mode equals the mean, 0 if they don't equal each other              *
   *  (ie. [5, 3, 3, 3, 1] should return 1 because the mode (3) equals the mean (3)).     *
   *  The array will not be empty, will only contain positive integers, and will not      *
   * contain more than one mode.                                                          *
   *                                                                                      *
   *  SOLUTION                                                                            *
   *  Since it is possible that I will want a function that will calculate the mean or    *
   *  mode in the future, I decided to create separate functions for each. The mean is    *
   *  calculated by the average of all values in the array. The mode is the number that   *
   *  exists the most in the array. My solution is to call my two functions and then      *
   *  compare to see if they are equal and if so return 1 else return 0.                  *
   *                                                                                      *
   *  Steps for solution                                                                  *
   *    1) Create separate functions for getMean and getMode                              *
   *    2) Compare the values returned from the two functions                             *
   *    3) If values are equal return 1 else return 0
   *
   * Mean || Avg = (5 + 3 + 3 + +3 + 1) / noOfElem=5 => mode = 3
   * Mode = Mode is the value which occurs most frequently in a set of observations.
   * For example, {6, 3, 9, 6, 6, 5, 9, 3} the Mode is 6, as it occurs most often.
   */
  private static boolean meanMode(int[] arr) throws InvalidTypeException {
    int mean = getMean(arr);
    Integer maxOccurences = getModeOf(arr);

    return mean == maxOccurences;
  }

  private static int getMean(int[] arr) {
    int sumOfArrayElements = Arrays.stream(arr)
      .reduce(Integer::sum).getAsInt(); //or orElseThrow(InvalidTypeException::new);
    int mean = sumOfArrayElements / arr.length;
   /* OR
   int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += i;
    }
    int mean = sum / arr.length;
    */
    return mean;
  }

  private static Integer getModeOf(int[] arr) {
    Map<Integer, Integer> numberOccurencesMap = new HashMap<>();
    Arrays.stream(arr).forEach(arrayElement -> {
      if (numberOccurencesMap.containsKey(arrayElement)) {
        numberOccurencesMap.put(arrayElement, numberOccurencesMap.get(arrayElement) + 1);
      } else {
        numberOccurencesMap.put(arrayElement, 1);
      }
    });
    System.out.printf("Number of Occurances Map: %s", numberOccurencesMap);

    return Collections.max(numberOccurencesMap.values());
  }



  /*************************************************************************
   *                                                                        *
   *  Using the JavaScript language, have the function MostFreeTime(strArr) *
   *  read the strArr parameter being passed which will represent a full    *
   *  day and will be filled with events that span from time X to time Y in *
   *  the day. The format of each event will be hh:mmAM/PM-hh:mmAM/PM.      *
   *  For example, strArr may be                                            *
   *  ["10:00AM-12:30PM","02:00PM-02:45PM","09:10AM-09:50AM"]. Your program *
   *  will have to output the longest amount of free time available         *
   *  between the start of your first event and the end of your last event  *
   *  in the format: hh:mm. The start event should be the earliest event    *
   *  in the day and the latest event should be the latest event in the     *
   *  day. The output for the previous input would therefore be 01:30       *
   *  (with the earliest event in the day starting at 09:10AM and the       *
   *  latest event ending at 02:45PM). The input will contain at least 3    *
   *  events and the events may be out of order.                            *
   *                                                                        *
   *************************************************************************/
  private static String[] MostFreeTime(String[] strArr) {
    // code goes here
    return strArr;
  }

}
