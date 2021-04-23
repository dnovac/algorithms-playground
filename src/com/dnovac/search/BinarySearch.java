package com.dnovac.search;

import java.util.Arrays;

/**
 * @author Dan Novac on 31/10/2020
 * @project algorithms-playground
 */
public class BinarySearch {

  /**
   * =========== BINARY SEARCH ==============
   * <p>
   * In the case of recursive binary search implementation,
   * we calculate the middle position by taking the start and end position and
   * check if the target element is equal to the middle element or not.
   * <p>
   * If the target, the number of the element you are searching in an array is equal then our search is complete,
   * but if the target is greater than middle we look on the second half of array and if the target is less than middle element
   * then we look into the first half of array.
   * <p>
   * This is possible because in the case of binary search the array is always sorted if it's not,
   * you must sort the array before conducting a binary search.
   * <p>
   * So, in each iteration, the value of start and end position changes like at first,
   * start=0 and end=length-1
   * but then depending upon the value of target element we move the pointer to the first or second half of array.
   * <p>
   * This gives you the base case I mean,.
   * since the array is getting smaller and smaller in every iteration at one point it will limit to just one element
   * and after that end will be less than the start.
   * <p>
   * At this point, you can stop the binary search because now you cannot divide the array further,
   * which means the element doesn't exist in the array. Our solution returns -1 at this point in time.
   * <p>
   * Read more: https://www.java67.com/2016/10/binary-search-using-recursion-in-java.html#ixzz6cSUskG75
   */

  public static int binarySearch(int[] array, int start, int end, int target) {

    Arrays.sort(array);

    if (start > end) {
      return -1;
    }

    int middle = (start + end) / 2;

    if (array[middle] == target) {
      System.out.println("Target found at index: " + middle);
      return middle;
    } else if (target > array[middle]) {
      //it's in the right side
      return binarySearch(array, middle + 1, array.length, target);
    } else {
      //left side
      return binarySearch(array, start, middle - 1, target);
    }
  }

  public static int binarySearchWithoutRecursion(int[] array, int target) {

    int start = 0;
    int end = array.length - 1;

    while (start <= end) {
      int middle = (start + end) / 2;
      if (target == array[middle]) {
        System.out.println("Value found on index: " + middle);
        return middle;
      } else if (target < array[middle]) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }
    return -1;
  }

}
