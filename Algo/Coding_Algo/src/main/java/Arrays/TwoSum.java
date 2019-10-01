package Arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


/**
 * There are two ways to solve this problem
 * 1) Using hashmap
 * 2) Using two pointers. If we are using two pointers we need
 *    to sort the map.
 *    Then use two pointer.
 *
 *
 *    https://www.dailycodingproblem.com/solution/1?token=da0ae5560a7d07114da9c2123ad597a15a24e634c8316c9c6beb2daf5c42c849562ca294
 */
public class TwoSum {

  public static void main (String args[]) {
    /*
    int[] numbers = {2,7,11,15};
    int total = 10;
    int expected [] = {4,6};
    int twoSum [] =twoSum(expected, total);
    for(int i = 0; i < twoSum.length; i++) {
      System.out.println(twoSum[i]);
    }
    */
    int [] expected = {4,6};
    int result [] = TwoSum.twoSumTest( expected, 10);

  }



  // Hashmap Solution
  // One pass
  // Time complexity O(n) ---> Traverse entire array
  // Space complexity will be O(n)

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if(map.containsKey(diff)) {
        return new int [] {map.get(diff), i};
      } else {
        map.put(nums[i], i);
      }
    }

    throw new IllegalArgumentException("No two sum solutions");
  }

  public static int[] twoNumberSum(int[] array, int targetSum) {
    if(array == null || array.length == 0) {
      throw new IllegalArgumentException("No two sum solutions");
    }

    Map <Integer, Integer> map = new HashMap();
    int [] output;
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      int diff = targetSum - num;
      if(!map.containsKey(diff)) {
        map.put(num, i);
      } else {
        //int x = map.get(diff);
        if(diff > num) {
          return new int [] {diff, num};
        } else {
          return new int [] {num, diff};
        }
      }

    }
    return new int[0];
  }

  /**
   * Time complexity
   *  O(n) runtime, O(1) space Two pointer approach
   *  Every element is traversed once. One pointer from left and one pointer from right.
   *
   *
   *
    O(n) runtime, O(1) space – Two pointers:
   Let’s assume we have two indices pointing to the i
   th and j
   th elements, Ai and Aj
   respectively. The sum of Ai and Aj could only fall into one of these three possibilities:
   i. Ai + Aj > target. Increasing i isn’t going to help us, as it makes the sum even
   bigger. Therefore we should decrement j.
   ii. Ai + Aj < target. Decreasing j isn’t going to help us, as it makes the sum even
   smaller. Therefore we should increment i.
   iii. Ai + Aj == target. We have found the answer.
   */
  public static int[] twoNumberSum_UsingTwoPointerApproach(int[] array, int targetSum) {

    Arrays.sort(array);
    int leftPointer = 0;
    int rightPointer = array.length-1;

    while(leftPointer < rightPointer) {
      int sum = array[leftPointer] + array[rightPointer];
      if(sum >  targetSum) {
        rightPointer--;
      } else if(sum < targetSum) {
        leftPointer++;
      } else { // sum == 0
        return array[leftPointer] > array[rightPointer] ? new int [] {array[rightPointer], array[leftPointer]}: new int [] {array[leftPointer], array[rightPointer]};
      }
    }
    return new int[0];
  }

  @Test
  public void testTwoSumUsingSet() {
    int input [] = {10, 15, 3, 7};
    int target = 17;
    Assert.assertTrue(twoSumUsingSet(input, target));
  }

  public boolean twoSumUsingSet(int[] nums, int target) {
    Set<Integer> set = new HashSet<>();

    for(int number : nums) {
      int leftNumber  = target - number;
      if(set.contains(leftNumber)) {
        return true;
      } else {
        set.add(number);
      }
    }
    return false;
  }

  /**
   * Fact that the input is already sorted.
   * For each element x, we could look up if target - x exist in O(log n) time by applying binary
   * search over the sorted array.
   *
   * Total run time complexity for n element array is to find if there is a sum or not time complexity will
   * be log n (Using binary Search)
   *
   * So there are n elements
   *
   * Time complexity will be n log n
   *
   */
  public boolean twoSumUsing_UsingBinarySearch(int[] nums, int target) {

    return false; // To do implement
  }
  /*
  public int[] twoSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length-1;
    int sum = Integer.MIN_VALUE;
    // Note target is always greater then both the numbers.
    // So target - numbers[x] always greater then 0
    // Target --> 9
    // 2,7,11,15
    // i = 0
    // j = 3
    int x [] = new int[2];
    while(i<j) {
      sum = numbers[i] + numbers[j];

      if(sum== target) {
        x[0] = i+1;
        x[1] = j+1;
        return x;
      } else if(sum < target) {
        ++low;
      } else {
        --low;
      }
    }
    return x;
  }
*/
  // Two pointer approach
  // Time complexity O(n) + O(nlogn)
    /*
     public int[] twoSum(int[] nums, int target) {
         Arrays.sort(nums);
         int i = 0;
         int j = nums.length-1;
         // 3,2,4 Before sorting
         //2,3,4 ---->6 ---> [1,2] After sorting
         while (i<j) {
             if(nums[i] + nums[j] == target) {
                 int y [] = new int [2];
                 y [0] = i;
                 y[0] = j;
                 return y;
             } else if(nums[i] + nums [j] < target) {
                i++ ;
             } else if (nums[i] + nums[j] > target) {
                 j--;
             }
         }
         return new int [0];
     }


    */

  public static int[] twoSumTest(int[] nums, int target) {
    int [] output = new int [2];

    Map<Integer, Integer> map = new HashMap();

    for (int i = 0; i < map.size(); i++) {

      if(map.containsKey(nums[i])) {
        output[0] = map.get(nums[i]);
        output[1] = i;
        return output;
      } else {
        map.put(target - nums[i], i);
      }
    }

    return output;
  }
}
