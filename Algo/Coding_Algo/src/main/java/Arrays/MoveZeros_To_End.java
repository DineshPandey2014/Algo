package Arrays;

import org.junit.Test;

public class MoveZeros_To_End {

  @Test
  public void testZeroMovement() {
    int x [] = {4,2,0,1,0,3,0};
    moveZerosToEnd(x);
  }

  // When we move zeros to end.
  // Initally i and end will point to last index of array
  public void moveZerosToEnd(int input[]) {

    int left = input.length-1; // It will point the index where 0 can be swapped
    int i = input.length-1;
    // It will move from inde=>0 till length-1. And check
    // if any value of array is zero
    // If zero swap with right pointer index. Which is not zero.

    while(i >= 0) {
      if(input[i] == 0) {
        swap(left, i, input);
        left--;
      }
      i--;
    }
  }

  public void swap(int leftIndex, int rightIndex, int input[]) {
    int temp = input[leftIndex];
    input[leftIndex] = input[rightIndex];
    input[rightIndex] = temp;
  }

}
