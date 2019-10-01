package Recursion;

public class String_Plaindromic_Using_Recursion {
  /**
   * If we do using substring. It will create a new String every time.As string is immutable
   * and it takes space of --> n, n-2, n-4, n-8 ....1 = O(n^2)
   * Time complexity : O(n^2) using substrin approach it will be
   *
   * So here we solved this passing index of String.
   *
   *
   */
  public static void main(String args[]) {
    String str = "a";
    boolean isPlaindromic = isPlaindromic(str, 0,str.length()-1 );
    System.out.println(isPlaindromic);
  }

  public static boolean isPlaindromic(String str, int startIndex, int endIndex) {


    if (str.charAt(startIndex) != str.charAt(endIndex)) {
      return false;
    }

    if (startIndex >= endIndex) {
      return true;
    }

    return isPlaindromic(str, startIndex + 1, endIndex - 1);

  }
}