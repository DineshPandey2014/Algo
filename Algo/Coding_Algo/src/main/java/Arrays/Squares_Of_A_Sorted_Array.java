package Arrays;


import org.junit.Test;

/**
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of
 * the squares of each number, also in sorted non-decreasing order.



 Example 1:

 Input: [-4,-1,0,3,10]
 Output: [0,1,9,16,100]
 Example 2:

 Input: [-7,-3,2,3,11]
 Output: [4,9,9,49,121]


 Note:

 1 <= A.length <= 10000
 -10000 <= A[i] <= 10000
 A is sorted in non-decreasing order.
 */

public class Squares_Of_A_Sorted_Array {
  /**
   Two pointer approach
   1. Left Pointer ; 0
   2 .Right Pointer : lenght of array -1;
   3. Check each left element and right element double each one


   */

  @Test
  public void testSortedSquare() {
   int input [] = {-4,-1,0,3,10};

   int [] result = sortedSquares(input);
   System.out.println(result);

  }
  // Two pointer approach.
  public int[] sortedSquares(int[] A) {

    int leftP = 0;
    int rightP = A.length-1;
    int j = rightP;

    int [] output = new int [A.length];
    while(leftP < rightP) {
      int leftNumber = A[leftP] * A[leftP];
      int rightNumber = A[rightP] * A[rightP];

      if(leftNumber <= rightNumber) {

        output[j] = rightNumber;
        j--;
        --rightP;

      } else {

        output[j] = leftNumber;
        j--;
        leftP++;
      }

    }
    return output;
  }
}
