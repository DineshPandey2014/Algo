package Arrays;

/**
 * https://www.youtube.com/watch?v=gHSoIwnERF0
 *
 * LeetCode 209 : https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * Good solution:
 *
 * Given an array of n positive integers and a positive integer s, find the minimal
 * length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: the subarray [4,3] has the minimal length under the problem constraint.



 Until now, we have kept the starting index of subarray fixed, and found the last position. Instead, we could move
 the starting index of the current subarray as soon as we know that no better could be done with this index as the starting index.
 We could keep 2 pointer,one for the start and another for the end of the current subarray, and make optimal moves so as to keep
 the \text{sum}sum greater than ss as well as maintain the lowest size possible.

 Algorithm

 Initialize \text{left}left pointer to 0 and \text{sum}sum to 0
 Iterate over the \text{nums}nums:
 Add \text{nums}[i]nums[i] to \text{sum}sum
 While \text{sum}sum is greater than or equal to ss:
 Update \text{ans}=\min(\text{ans},i+1-\text{left})ans=min(ans,i+1−left), where i+1-\text{left}i+1−left is the size of current subarray
 It means that the first index can safely be incremented, since, the minimum subarray starting with this index with \text{sum} \geq ssum≥s has been achieved
 Subtract \text{nums[left]}nums[left] from \text{sum}sum and increment \text{left}left

 Time complexity is O(n)

 Examples:
 arr[] = {1, 4, 45, 6, 0, 19}
 x  =  51
 Output: 3
 Minimum length subarray is {4, 45, 6}

 arr[] = {1, 10, 5, 2, 7}
 x  = 9
 Output: 1
 Minimum length subarray is {10}

 arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
 x = 280
 Output: 4
 Minimum length subarray is {100, 1, 0, 200}

 arr[] = {1, 2, 4}
 x = 8
 Output : Not Possible
 Whole array sum is smaller than 8.

 */


public class MinimumSubArrayWithSumGreaterThanValue {

  public static void main(String args[]) {
    //int nums [] = new int [] {-1, 10, 5, 2, 7};
    //int nums [] = new int [] {2, 3, 1, 1, -1, 3,4};
    int nums [] = new int [] {2,3,1,2,4,3};

    int s = 7;
    int x = getSubarray(s, nums);
    System.out.println(x);
  }

  static int getSubarray(int s, int [] nums) {
    // In this we keep adding the individual item of array and compare with the given sum.
    // sum = sum + nums[i]
    // Then run the while loop inside for loop
    // If sum is greater or equal to the input sum.
    // Then check the minimum lenght of index. Index left minus Index right which i in the loop + 1.
    // Then subtract from sum the
    //
    int sum = 0;
    // This for length of the array
    int minimum = Integer.MAX_VALUE;
    int left = 0;
    for (int i = 0; i <nums.length; i++ ) {
      sum = sum + nums[i];
      while(sum >= s) {
        minimum = Math.min(minimum, i - left + 1);
        sum = sum - nums[left];
        left++;
      }
    }
    return minimum != Integer.MAX_VALUE ? minimum : 0;
  }
}
