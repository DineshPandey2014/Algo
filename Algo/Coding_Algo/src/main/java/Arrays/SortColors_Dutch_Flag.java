package Arrays;

/**
 * https://www.youtube.com/watch?v=BOt1DAvR0zI
 *
 * https://leetcode.com/problems/sort-colors/
 *
 *
 *
 *
 *
 */
public class SortColors_Dutch_Flag {

  // 0 represent red
  // 1 represent white
  // 2 represent blue

  // Let's take three pointer

  // ptrOne
  // ptrTwo
  // ptrThree
  public void sortColors(int[] nums) {

    // Initially ptrOne and ptrTwo will point to index 0 and ptrThree point to last index of nums.
    // Only mid pointer that is ptrTwo will move from point zero to last index.

    // If at index ptrTwo is zero ---> increment both ptrOne and ptrTwo as zero will be left of one.
    // swap(ptrOne, ptrTwo)

    // If at index ptrTwo is one  ---> increment only ptrTwo as one will be at center
    // There is no swap.

    // If at index ptrTwo is two  swap with ptrThree and decrement with ptrThree.

    int ptrOne = 0;
    int ptrTwo = 0;
    int ptrThree = nums.length -1;

    while (ptrTwo <= ptrThree) {
      int data = nums[ptrTwo];
      if(data == 0) {
        swap(ptrOne, ptrTwo, nums);
        ptrOne++;
        ptrTwo++;
      } else if(data == 1) {
        // No swap as in mid we need 1 to be at center. Only increment the pointer
        ptrTwo++;
      } else if(data == 2) { // At mid pointer if data is two swap with the last element
        swap(ptrTwo, ptrThree, nums);
        ptrThree--;
      }
    }

  }

  private void swap(int indexOne, int indexTwo, int [] nums) {
    int temp = nums[indexOne];
    nums[indexOne] = nums[indexTwo];
    nums[indexTwo] = temp;
  }
}
