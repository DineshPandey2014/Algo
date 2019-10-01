package Arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in
 * nums such that the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Three_Sum_Closest {
  /**
   *  Time complexity is O(n^2);
   https://www.youtube.com/watch?v=qBr2hq4daWE
   *
   */

  @Test
  public void testThreeSumCloset() {

    int nums [] = {0,1,1,1};
    int target = 100;
    int closetNumberToTarget = threeSumClosest(nums, target);

  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[2];
    int currentSum = 0;

    for (int i = 0; i < nums.length-2; i++) {
      int leftPonter = i + 1;
      int rightPointer = nums.length -1;

      while(leftPonter < rightPointer) {
        currentSum = nums[i] + nums[leftPonter] + nums[rightPointer];
        if(currentSum > target) {
          rightPointer--;
        } else {
          leftPonter++;
        }

        if(Math.abs(currentSum - target) < Math.abs(result -target)) {
          result = currentSum;
        }
      }
    }
    return result;
  }
}
