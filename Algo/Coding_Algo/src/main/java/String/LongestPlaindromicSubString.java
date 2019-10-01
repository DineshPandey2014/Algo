package String;

public class LongestPlaindromicSubString {

  public static void main(String args[]) {
    // a
    System.out.println(isPlaindromic("ab"));
  }

  static boolean  isPlaindromic(String str) {
    int  i = 0;
    int  j = str.length()-1;
    while (i <= j) {
      char x = str.charAt(i);
      char y = str.charAt(j);
      if(x == y) {
        i++;
        j--;
        continue;
      } else {
        return false;
      }
    }
    return true;
  }
}
