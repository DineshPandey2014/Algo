package DP;

public class FindNumberOfPaths_In_Matirx_DP {

  static int numOfPathsToDest(int n) {
    int memo [] [] = new  int  [n] [n]; // initalzing the two dimension array with 0.
    return findNumberOfPathsDP(n-1, n-1, memo);
  }


  static int findNumberOfPathsDP(int m, int n, int memo [] []) {

    if(m < 0 || n < 0) {
      return 0;
    }

    if(memo[m][n] != 0) {
      return memo[m][n];
    }

    if(m == 0 && n == 0) {
      return 1;
    }
    memo[m][n] = findNumberOfPathsDP(m-1, n, memo) + findNumberOfPathsDP(m, n-1, memo);
    return  memo[m][n];
  }

  public static void main(String[] args) {
    int path = numOfPathsToDest(4);
    System.out.println(path);
  }
}
