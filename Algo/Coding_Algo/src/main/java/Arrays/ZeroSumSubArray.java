package Arrays;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=rpZfxmHTvJc

// Really good https://www.youtube.com/watch?v=HJDlxZNe1UI

/**
 *
 * Take the input array and returns the array with start index and end index for the subarray
 * whose sum is zero.
 */
public class ZeroSumSubArray {

  public static void main(String args[]) {

    int  arr [] = {3,-1,1,2};
    //int arr [] = {1,2,-5,1,2,-1};
    int y[] = sumZero(arr);

    for (int i = 0; i < y.length; i++) {
      System.out.println(y[i]);
    }
  }


  static int [] findZeroSumArray (int [] array) {
    Map<Integer, Integer> map = new HashMap<>();

    int sum = array[0];

    for (int i = 0; i < array.length; i++) {

    }

    return new int[0];
  }

  // Complete the sumZero function below.
  static int[] sumZero(int[] arr) {

    // Two cases either we get the sum in the map
    // Or Sum is zero by adding that index.
    // 2, -1, -1,5

    // Think we need Long here.
    Map<Long,Integer> map = new HashMap();
    int x [] = new int[2];
    long sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];

      // This is the corner cases when sum is zero starting from index 0
      if(sum == 0) {
        x[0] = 0;
        x[1] = i;
        return x;
      }

      if(map.containsKey(sum)) {
        x[0] = map.get(sum) + 1;  // This is the corner cases
        x[1] = i;
        return x;
      } else {
        map.put(sum, i);
      }
    }
    return new int [] {-1};
  }
}
