package Sorting.Algo;

/**
 * Space time complexity it runs constant time
 *
 * O(1) algorithm runs in place.
 *
 * Time complexity --> O(n2)
 *
 * looping arrays until get the array sorted;
 *
 * Best case time complexity : O(1) input is sorted order
 *
 * for Bubble Sort is
 *
 *
 * Selection Sort: O(n^2 Average case time complexity
 * Bubble Sort: O(n^2) Average case time complexity
 * Insertion Sort: O(n^2) Average case time complexit
 *
 * Merge Sort: O(nlogn) in worst case time complexity.
 *
 */
public class BubbleSort {

  public static void main(String args[]) {
    int [] input = {3,5,2,1};
    int [] output = bubbleSort(input);
  }

  public static int[] bubbleSort(int[] array) {
    int k = array.length-1;
    while (k>0) {
      for(int i = 0; i < k ; i++) {
        if(array[i] > array[i+1]) {
          swap(i, i+1, array);
        }
      }
      k--;
    }
    return array;
  }

  public static void swap(int x, int y, int[] array) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }
}
