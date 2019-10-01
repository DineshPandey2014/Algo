package Arrays;

import org.junit.Test;

public class RemoveDuplicatesInArray {

  @Test
  public void removeDuplicartes() {
    int input [] = new int [] {2,3,3,4};
    removeDuplicates(input);
  }

  public int removeDuplicates(int[] nums) {

    int index = 1;
    // 1,1,2
    for (int i = 1; i < nums.length; i++) {
      if(nums[i-1] != nums[i]) {
        nums[index] = nums[i];
        index++;
      }
    }
    return index;
  }
}
