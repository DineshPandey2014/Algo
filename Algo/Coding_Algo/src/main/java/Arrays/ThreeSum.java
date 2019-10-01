package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String args[]) {
    int nums[] = {-1, 0, 1, 2, -1, -4};
    //[[-1,-1,2],[-1,0,1],[-1,0,1]]
    List<List<Integer>>  list = threeSum(nums);
    System.out.println(list);
  }

  public static List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> listOutPut = new ArrayList();

    // Now fix the first element and one by one find other two elements.

    // Here for loop goes from 0 to length-2 example of three elements nums = [10, 2, 3]
    // i = 0 => 10
    // left = i+1 = 2
    // right = nums.length -1;

    for (int i = 0; i < nums.length-2; i++) {
      if(i > 0 && nums[i] == nums[i-1]) {
        continue;
      }

      int left = i + 1;
      int right = nums.length-1;
      while(left < right) {
        int sum = nums[i] + nums[left] + nums [right];
        if(sum == 0) {
          List<Integer> list = new ArrayList();
          list.add(nums[i]);
          list.add(nums[left]);
          list.add(nums[right]);
          listOutPut.add(list);

          // Skip the same result
          while(left < right && nums[left] == nums[left + 1]) {
            left++;
          }

          // Skip the same result
          while(left < right && nums[right] == nums[right-1]) {
            right--;
          }
          left++;
          right--;
        } else if(sum > 0) {
          right--;
        } else {
          left++;
        }
      }

    }
    return listOutPut;
  }
}
