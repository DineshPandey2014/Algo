package Recursion;

public class IsPalindromeRecursion {

  /**
   * Palindromic check using recursion
   */

  public static void main (String args[]) {
    String str = "ddpyd";

    System.out.println(isPalindrome(str.toCharArray(), 0, str.length()-1));
  }

  public static boolean isPalindrome(char str[], int leftPointer, int rightPointer) {

    // Exit condition if right pointer is less then left pointer
    if(rightPointer < leftPointer) {
      return false;
    }

    // Check if first and last character don't match return false
    if(str[leftPointer] != str[rightPointer]) {
      return false;
    }
    isPalindrome(str, leftPointer + 1, rightPointer -1);
    // If entire string is pass then return true.
    return true;
  }

}
