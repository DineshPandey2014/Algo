package Recursion;

public class FindNumberOfPaths_In_Matirx {

  /**
   * To find all the paths in the matrix.
   * We can move only right or at bottom in the cell
   * <p>
   * ---> Right Move from the cell.
   * |
   * | Down Move from the cell
   * <p>
   * To solve this problem the trick is
   * <p>
   * 1. For 0th row there is only one way you can move. As we are suppose to move right
   * 2. For 0th column we have to move down. Only one way we can move
   * <p>
   * 0 1 1 1
   * <p>
   * 1 0 0 0
   * <p>
   * 1 0 0 0
   * <p>
   * 1 0 0 0
   * <p>
   * <p>
   * 3. Here the input is given as number say n -->3. It means we have matrix of 3 * 3 (Row * Col)
   * <p>
   * 4. We will make the matrix of n-1 (Row) * n-1 (Col)
   * <p>
   * 5. You need to find all paths from (0,0) cell --> (3, 3) If matrix is n = 4
   * <p>
   * 6) You will start from cell (0, 0)
   *
   * @param
   * @return
   */
//  static int numOfPathsToDest(int n) {
//
//    int memo [] [] = new  int  [n] [n]; // initalzing the two dimension array with 0.
//    return findNumberOfPathsRecursiveWithoutDP(n-1, n-1, memo);
//  }
  public int findAllPathsMoveFromTopLeft_ToBottom_Right(int rowIndex, int colIndex) {

    if (rowIndex < 0 || colIndex < 0) {
      return 0;
    }

    // We already at destination so there is no path which is zero
    if (rowIndex == 0 && colIndex == 0) {
      return 0;
    }

    if (rowIndex == 0 || colIndex == 0) {
      return 1;
    }
    return findAllPathsMoveFromTopLeft_ToBottom_Right(rowIndex, colIndex - 1) + findAllPathsMoveFromTopLeft_ToBottom_Right(rowIndex - 1, colIndex);
  }
}
  /**
   * This solution is without DP solution.
   *
   * @param m
   * @param n
   * @param memo
   * @return
   */
 // static int findNumberOfPathsRecursiveWithoutDP(int m, int n, int memo [] []) {
//
//    // We already at destination so there is no path which is zero
//     if(m < 0 || n < 0 || m > n) {
//      return 0;
//    }
//
//    // We are in the left most column (0th Column) or we are in the 0th Row. Then there is only one way from source
//    // From Source (0,0)  to destination (0,0)
//    if(m == 0 && n == 0) {
//      return 1;
//    }
//
//    if(memo[m][n] != 0) {
//      return memo[m][n];
//    }
//
//    memo[m][n] = findNumberOfPathsRecursiveWithoutDP(, n, memo) + findNumberOfPathsRecursiveWithoutDP(m, n-1, memo);
//    return  memo[m][n];
//  }
//
//  public static void main(String[] args) {
//    int path = numOfPathsToDest(1);
//    System.out.println(path);
//  }
//}


/*
# input: n - a positive integer representing the grid size.
# output: number of valid paths from (0,0) to (n-1,n-1).

function numOfPathsToDest(n):
    # allocate a 2D array for memoization
    memo = [][]

    # the memoization array is initialized with -1
    # to indicate uncalculated squares.
    for i from 0 to n-1:
        for j from 0 to n-1:
            memo[i][j] = -1

    return numOfPathsToSquare(n-1, n-1, memo)


# input:
#    i, j - a pair of non-negative integer coordinates
#    memo - a 2D memoization array.
# output:
#    number of paths from (0,0) to the square represented in (i,j),

function numOfPathsToSquare(i, j, memo):
    if (i < 0 OR j < 0):
        return 0
    else if (i < j):
        memo[i][j] = 0
    else if (memo[i][j] != -1):
        return memo[i][j]
    else if (i == 0 AND j == 0):
        memo[i][j] = 1
    else:
        memo[i][j] = numOfPathsToSquare(i, j -1, memo) +
        numOfPathsToSquare(i - 1, j, memo)

    return memo[i][j]
 */