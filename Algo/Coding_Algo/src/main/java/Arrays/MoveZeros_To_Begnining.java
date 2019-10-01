package Arrays;

import org.junit.Test;

public class MoveZeros_To_Begnining {

  @Test
  public void testZeroMovement() {
    int x [] = {4,2,0,1,0,3,0};
    moveZerosToBegnining(x);
  }

  public void moveZerosToBegnining(int input[]) {
    int right = 0; // It will point the index where 0 can be swapped

    int i = 0; // It will move from inde=>0 till length-1. And check if any value of array is zero
    // If zero swap with right pointer index. Which is not zero.

    while(i <= input.length-1) {
       if(input[i] == 0) {
        swap(right, i, input);
        right++;
      }
      i++;
    }
  }

  public void swap(int leftIndex, int rightIndex, int input[]) {
    int temp = input[leftIndex];
    input[leftIndex] = input[rightIndex];
    input[rightIndex] = temp;
  }
}
