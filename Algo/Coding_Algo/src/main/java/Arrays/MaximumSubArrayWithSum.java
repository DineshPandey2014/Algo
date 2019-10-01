package Arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Kadane's Algorithm to Maximum Sum Subarray Problem
 *
 * https://www.youtube.com/watch?v=86CQq3pKSUw
 *
 */
public class MaximumSubArrayWithSum {

  public static void main (String args[]) {
    int x [] = {1,-3,2,1,-1};
    int z = maxSubArrayKadaneAlgo(x);
    System.out.println(z);
  }

  /**
   * Maximum sum using kadane algo
   * @param nums
   * @return
   */
  public static int maxSubArrayKadaneAlgo(int[] nums) {
    // It is the running sum which will get updated if it is greater then the summ of
    // all elements to that index. It will get compare to the index that exist.
    int max_current = nums[0];
    int max_global = nums[0];

    for (int i = 1; i<nums.length; i++) {
      max_current = Integer.max(nums[i], max_current + nums[i]);
      if(max_current > max_global) {
        max_global = max_current;
      }
    }
    return  max_global;
  }

  public static int maxSubArrayLen(int[] nums, int k) {
    Map<Integer,Integer> map = new HashMap();
    int max = 0;
    int sum = 0;

    for(int i = 0; i < map.size(); i++) {
      sum = sum + nums[i];

      if(sum == k) {
        max = Math.max(max, i + 1);
      }

      int diff = sum-k;

      if (!map.containsKey(diff)) {
        max = Math.max(max, i - map.get(diff));
      }

      if (map.containsKey(sum)) {
        max = map.put(sum, i);
      }
    }
    return max;
  }


  int maxSumSubArray(int[] arr, int k) {
    int maxSum = Integer.MIN_VALUE;
    int countK = 1;
    int tempSum = 0;
    int index = 0;

    for (int i = 0; i < arr.length; i++) {
      tempSum = tempSum + arr[i] ;
      if(countK == k) {
        maxSum = Math.max(maxSum, tempSum);
        countK--;
        tempSum = tempSum -arr[index];
        index++;
      }
      countK++;
    }
    return maxSum;

  }

  @Test
  public void testArray() {
    int x [] = {-2,1,-3, 4,-1,2,1,-5,4};
    int result = maxSubArrayTest(x);
    System.out.println(result);

  }

  public int maxSubArrayTest(int[] nums) {

    int globalSum = nums[0];
    int max_current = nums[0];

    for (int i = 1; i < nums.length; i++) {
      max_current = Integer.max(nums[i], max_current + nums[i]);
      if(max_current > globalSum) {
        globalSum = max_current;
      }
    }
    return globalSum;
  }
}
