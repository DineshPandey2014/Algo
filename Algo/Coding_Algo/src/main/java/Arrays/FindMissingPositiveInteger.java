package Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant
 * space. In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.

 For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

 You can modify the input array in-place.
 */
public class FindMissingPositiveInteger {

  /*
      Given n numbers starting from 0 .....n = length n +1
      Sum formula : (n)(n+1)/2
      There is one number missing.
      Given array :
      Algo : Sum all the numbers
      Difference =  (n)(n+1)/2  - Sum of all the numbers.



    */
  public int missingNumber(int[] nums) {
    int sum = 0;
    int n = nums.length;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
    }

    int totalSum = (n) * (n+1)/2;
    int missingNumber = totalSum - sum;
    return missingNumber;
  }


}
