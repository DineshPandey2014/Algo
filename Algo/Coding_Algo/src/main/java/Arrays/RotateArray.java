package Arrays;

import org.junit.Test;

/**
 *
 * https://leetcode.com/problems/rotate-array/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

 Example 1:

 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: [-1,-100,3,99] and k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 Note:

 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 Could you do it in-place with O(1) extra space?

 */
public class RotateArray {

  @Test
  public void testRotateArray() {
    //int input [] =  {1,2,3,4,5,6,7};
    int input [] = {1,2,3, 4, 5, 6, 7};
    rotateArrayOnePass(input, 3);

  }


  /**
   * Brute force
   *
   * Time Complexity : For each k index we move all the array one postion
   * Time Complexity will be O(n k)
   *
   * @param nums
   * @param k
   */
  public void rotate(int[] nums, int k) {
    int end = nums.length - k; // 3
    for (int i = nums.length -1; i > end; i--) {
      int temp = nums[i]; // i = 6 temp = 7, // i =5 temp = 6

      for(int j = nums.length -1 ; j > 0 ; j--) {
        nums[j] = nums[j-1];
      }
      nums[0] = temp;
    }

  }

  /*
   * https://www.youtube.com/watch?v=EpP6YuqzHe8&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=13
   *
   * It is in two step of array of length N and K times to rotate the array.
   * First split the array in two parts one length N-K and other one is K
   *
   * 1. Reverse the array of length N - K and Reverse the the array of K length
   * 2. Reverse the whole array of length of N.
   *
   * Result is the array which is rotate k times.
   *
   *
   */

  public void rotateArrayOnePass(int[] nums, int k) {
    k %= nums.length;

    int n = nums.length-1;
    int startIndex = 0;
    int endIndex = n - k -1;

    reverseArray(nums, startIndex, endIndex);
    reverseArray(nums, endIndex + 1, n);
    reverseArray(nums,0, n -1);
  }

  private void reverseArray(int nums[] , int startIndex, int endEndex) {
    while (startIndex < endEndex) {
      int temp = nums[startIndex];
      nums[startIndex] = nums[endEndex];
      nums[endEndex] = temp;
      startIndex++;
      endEndex--;

    }

  }
}
