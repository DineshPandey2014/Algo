package Maths;

/**
 *  https://leetcode.com/problems/plus-one/
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.


 */
public class PlusOne {

  // Array will contains single digit 0 to 9
  // [1,2,9] , [2,3,4]

  public int[] plusOne(int[] digits) {
    int n = digits.length-1;

    for(int i = n; i >=0; i--) {
      if(digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      // Example if all digits are 9999 --->
      // Then input array will be set as 0; We need to create a new array initalize as int
      // Which will set as 0 value for the input array.
      digits[i] = 0;
    }

    // This will be the case when all the elements are 9 then we added 1 to the extreme right side
    // All the digit becomes zero except left side one
    // 9999 ---> 1 000 ---> Will take the Array of length

    int x [] = new int [digits.length + 1];
    x[0] = 1;
    return x;
  }
}
