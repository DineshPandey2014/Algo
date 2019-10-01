package String;

import java.util.Arrays;

/**
 *  Finding Duplicate Using Floyd algo
 *  https://www.youtube.com/watch?v=-YiQZi3mLq0
 *
 *  https://www.youtube.com/watch?v=SzmZD-mU6Zg&t=191s
 *
 *  https://www.youtube.com/watch?v=LUm2ABqAs1w
 *
 */
public class FindDuplicateNumber {

  public static void main(String args[])  throws Exception {
    int[] nums = {1,2,3};
    System.out.println(findDuplicate(nums));
  }

  /**
   * Using Sorting. First Sort. Then loop it.
   * Check previous element needs to be equal to next element
   *
   */
  public static int findDuplicate(int[] nums) {
    if(nums == null || nums.length == 0) {
      throw new IllegalArgumentException();
    }
    Arrays.sort(nums); // Time complexity will n log n
    // 1,3,4,2,2
    for (int i = 0; i < nums.length-1; i++) {
      if(nums[i] == nums[i+1]) {
        return nums[i];
      }
    }
    return -1;
  }

}
