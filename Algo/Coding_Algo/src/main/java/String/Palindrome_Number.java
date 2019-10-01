package String;

public class Palindrome_Number {

  public boolean isPalindrome(int x) {
    String inputChar = String.valueOf(x);
    int startPointer = 0;
    int endPointer = inputChar.length() -1;

    while(startPointer < endPointer) {
      char c1 = inputChar.charAt(startPointer);
      char c2 = inputChar.charAt(endPointer);
      if(c1 != c2) {
        return false;
      }
      startPointer++;
      endPointer--;
    }
    return true;
  }



  public boolean isPalindromeByReversingNumberApproach(int x) {
    if(x < 0) {
      return  false;
    }

    return x == reversedNumber(x);
  }

  int reversedNumber(int input) {
    int reverseNumber = 0;
    while(input != 0) {
      reverseNumber = reverseNumber * 10 + input%10;
      input = input/10;
    }
    return (int) reverseNumber;
  }
}
