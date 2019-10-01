package Recursion;

public class Fibionnaci_Recursion {

  /**
   *  Time complexity is o(2^n). As we traverse all the nodes in the recursion tree.
   *
   *  We started at nth level. Went deep to 0 --->
   *
   *  Total level is n.
   *
   *  Total number of nodes is 2^n
   *
   *  Time complexity = Traversing all nodes + constant amount of time in exit condition.
   *
   *  Time complexity : o(2^n)
   *
   */
  public static void main (String args[]) {
  int output = findFib(4);
  System.out.println(output);
  }
  /**
   * Find nth fibonnai number
   * @param n
   *
   * f(n) = f(n-1) + f (n-2);
   *
   * Time complexity is O(n)
   * Space complexity is O(n) --> Stack frame will go from n, n-1, n-2 ....1
   */

  public static int findFib(int n) {

    if(n == 1) {
      return 0;
    }

    if(n == 2) {
      return 1;
    }

    return findFib(n-1) + findFib(n-2);
  }
}
