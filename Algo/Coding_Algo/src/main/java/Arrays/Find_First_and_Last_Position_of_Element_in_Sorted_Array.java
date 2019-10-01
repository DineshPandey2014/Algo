package Arrays;

import org.junit.Test;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

  @Test
  public void testInArray() {
   int x [] = {5,7,7,8,8,10};
   int result [] = searchRange(x , 8);


  }

  public int[] searchRange(int[] nums, int target) {
    int range[] = new int [2];
    range [0] = findFirstIndex(nums, target) ;
    range [1] = findSecondIndex(nums, target);
    return range;
  }

  int findFirstIndex (int[] nums, int target) {
    int index = -1;
    int start = 0;
    int end = nums.length-1;

    while(start <=end) {
      int mid = end - (end -start)/2;
      if(target <= nums[mid]) {
        end = mid -1;
      } else {
        start = mid +1;
      }
      if(nums[mid] == target) {
        index = mid;
      }
    }

    return index;
  }

  int findSecondIndex(int[] nums, int target) {
    int index = -1;
    int start = 0;
    int end = nums.length-1;

    while(start <= end) {
      int mid = end - (end -start)/2;
      if(target >= nums[mid]) {
        start = mid +1;
      } else {
        end = mid -1;
      }

      if(nums[mid] == target) {
        index = mid;
      }
    }
    return index;
  }

}
