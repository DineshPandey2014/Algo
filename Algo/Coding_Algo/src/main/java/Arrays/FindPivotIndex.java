package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode https://leetcode.com/problems/find-pivot-index/description/
 */
public class FindPivotIndex {

  public static void main(String args[]) {
    int x[] = {1, 7, 3, 8, 5, 6};
    int y = findPivotIndexSOlutionOne(x);
    System.out.println(y);
  }

  /**
   * Time complexity is O(N)
   *
   * Space complexity is O(1)
   *
   * @param nums
   * @return
   */
  public static int pivotIndex(int[] nums) {
    int totalSum  = 0;
    int leftSum = 0;

    for (int j = 0; j < nums.length; j++) {
      totalSum = totalSum + nums[j];
    }

    for (int i = 0; i <nums.length; i++) {
      if(leftSum == totalSum - leftSum - nums[i]) {
        return i;
      }
      leftSum = leftSum + nums[i];
    }
    return -1;
  }

  /**
   * Time complexity is O(N)
   *
   * Space complexit  is O(N)
   *
   * Hashmap solution not
   * @param nums
   * @return
   */
  public static int findPivotIndexSOlutionOne(int[] nums) {
    Map<Integer,Long> mapCumulativeIndex = new HashMap();
    long sum = 0;
    for (Integer i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      mapCumulativeIndex.put(i, sum);
    }
    // index[0, 1 ,2,  3,   4,   5]
    //      [1, 7, 3,  6,   5,  6]
    //Sum . [1, 8, 11, 17, 22, 28]
    Long leftSum = 0l;
    Long rightSum = 0l;
    for (int  i = 0; i < nums.length; i++) {
      long leftIndex = i-1; // -1
      // int rightIndex = i+1;
      long arrayLength = nums.length-1; //5
      long totalCumSum = mapCumulativeIndex.get(arrayLength); // 28
      if(leftIndex != -1) {
        leftSum = mapCumulativeIndex.get(leftIndex);
      }
      rightSum =  totalCumSum - mapCumulativeIndex.get(i);

      if(leftSum != null && rightSum != null && leftSum == rightSum) {
        return i;
      }

    }
    return -1;
  }
}
