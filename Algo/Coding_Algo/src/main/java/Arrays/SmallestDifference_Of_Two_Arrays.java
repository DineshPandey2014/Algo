package Arrays;

import java.util.Arrays;

public class SmallestDifference_Of_Two_Arrays {

  /**
   * Time complexity
   *
   * Sorting is in place using quick sort algorithm.
   *
   * Sorting first array of length n : O(nlog(n)
   * Sorting of second array of length m : ((m log m)
   *
   * Time Complexity : O(nlog(n) + mlog(m))
   *
   * Space complexity: O(1)
   * Keeping the array of two values. Whose size is fixed. It's not increasing as the array length
   * increases.
   *
   * @param args
   */
  public static void main (String args[]) {
    /*
    int x [] = {-1, 5, 10, 20, 28, 3};
    int y [] = {26, 134, 135, 15, 17};
    int z [] = smallestDifference(x, y);
    */

    int x [] = {240, 124, 86, 111, 2, 84, 954, 27, 89};
    int y [] = {1, 3, 954, 19, 8};
    int z [] = smallestDifference(x, y);

  }


  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);

    int x = arrayOne.length;
    int y = arrayTwo.length;
    int min = Integer.MAX_VALUE;

    // Declares two pointers one for each array.
    int x1 = 0;
    int y1 = 0;
    int output [] = new int [2];

    while(x1 < x && y1 < y) {
      int diff = Math.abs(arrayOne[x1]-arrayTwo[y1]);
      if(diff < min) {
        min = diff;
        output[0] = arrayOne[x1];
        output[1] = arrayTwo[y1];
      }

      /**
       * Important condition when arrayOne value is less then arrayTwo then increment x1
       *
       * Other wise increment y1. Even if they are equal
       */
      if(arrayOne[x1] < arrayTwo[y1]) {
        x1++;
      } else {
        y1++;
      }
    }
    return 	output;
  }
}
