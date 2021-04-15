package com.dnovac.search;

/**
 * @author Dan Novac on 01/11/2020
 * @project algorithms-playground
 */
public class QuickSort {

  private int[] array;

  public void sort(int[] array) {

    if (array == null || array.length == 0)
      return;
    this.array = array;
    int length = array.length;
    quickSort(0, length - 1);
  }

  /**
   * Steps to implement Quick sort algorithm in place:
   * <p>
   * 1) Choose an element, called pivot, from the list or array. Generally pivot is the middle element of array.
   * <p>
   * 2) Reorder the list so that all elements with values less than the pivot come before the pivot,
   * and all elements with values greater than the pivot come after it (equal values can go either way).
   * This is also known as partitioning. After partitioning the pivot is in its final position.
   * <p>
   * 3) Recursively apply the above steps to the sub-list of elements with smaller values and separately
   * the sub-list of elements with greater values.
   * If the array contains only one element or zero elements then the array is sorted.
   * <p>
   * Our array is {6, 5, 3, 1, 8, 7, 2, 4} and we first choose 3 as pivot.
   * Now partitioning starts and we pick 6 on left side of side, because its greater than 3.
   * Now on right side, we leave 4 because its greater than 3, and pick 2 for swapping with 6.
   * After swapping our list look like {2, 5, 3, 1, 8, 7, 6, 4}.
   * <p>
   * Now we pick 5 on left side, and 1 on right side because it's greater than 3 and swap them again.
   * Now, our array looks like {2, 1, 3, 5, 8, 7, 6, 4}.
   * Since we are done with all elements with respect to 3 as pivot, we can now take the sub-array at left side of 3
   * and apply the same procedure.
   * <p>
   * This will sort the left array. Now on right side, we choose 4 as pivot,
   * and repeat same procedure, which result in 4 swapped against 5.
   * Now we take right side again with 6 as pivot and apply same procedure.
   *
   * @param low
   * @param high
   */
  private void quickSort(int low, int high) {

    int i = low;
    int j = high;

    //pivot is the middle index
    int pivot = this.array[low + (high - low) / 2];

    while (i <= j) {
      //best cases scenarios
      while (array[i] < pivot) {
        //all good move to the next one in the first part
        i++;
      }

      while (array[j] > pivot) {
        //all good move to the next one
        j--;
      }

      //swap case
      if (i <= j) {
        swap(i, j);
        i++;
        j--;
      }

    }

    if (low < j) {
      quickSort(low, j);
    }
    if (i < high) {
      quickSort(i, high);
    }
  }

  /**
   * swap i with j
   * @param i
   * @param j
   */
  private void swap(int i, int j) {

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
