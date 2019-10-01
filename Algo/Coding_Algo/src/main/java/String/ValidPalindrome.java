package String;


public class ValidPalindrome {
  int x1 = 'a';
  int y1 = 'z';

  int x2 = 'A';
  int y2 = 'Z';

  int x3 = '0';
  int y3 = '9';

  @org.junit.Test
  public void testPalindrome() {
    String input = "a ma";
    boolean test = isPalindrome(input);
    System.out.println(test);
  }

  /**
   * O(n) runtime, O(1) space:
   The idea is simple, have two pointers – one at the head while the other one at the tail.
   Move them towards each other until they meet while skipping non-alphanumeric
   characters.
   Consider the case where given string contains only non-alphanumeric characters. This is
   a valid palindrome because the empty string is also a valid palindrome.
   * @param s
   * @return
   */
  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() -1;

    while(i < j) {
      while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }

      while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      if( Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)) ) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }


  public boolean isPalindromeSolvedTestedMethod(String s) {

    int left = 0;
    int right = s.length() - 1;


    while (left <= right) {
      int inputLeft = s.charAt(left);
      int inputRight = s.charAt(right);

      while(!isAlphaNumeric(inputLeft)) {
        left++;
        inputLeft = s.charAt(left);
        continue;
      }

      while(!isAlphaNumeric(inputRight)) {
        right--;
        inputRight = s.charAt(right);
        continue;
      }

      if(inputLeft != inputRight) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public boolean isAlphaNumeric(int c) {
    if (( x1 <= c && c<= y1 ) || ( x2 <= c && c<= y2 ) || ( x3 <= c && c<= y3 )) {
      return true;
    }
    return false;
  }
}
