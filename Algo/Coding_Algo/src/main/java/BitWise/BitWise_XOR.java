package BitWise;

import org.junit.Test;

public class BitWise_XOR {
  //https://leetcode.com/problems/single-number/
  //Given a non-empty array of integers, every element appears twice except for one. Find that single one.
  public int singleNumber(int[] nums) {

    // Hold first element
    int result = nums[0];

    for (int  i = 1; i < nums.length; i++) {
      result = result ^ nums[i];
    }

    return result;
  }

  @Test
  public void testXORNumber() {
    int x = 4 ^ 5 ^ 4;
    System.out.println(x);
  }
}
