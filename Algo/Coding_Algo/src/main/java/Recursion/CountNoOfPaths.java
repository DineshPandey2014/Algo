package Recursion;

public class CountNoOfPaths {

  public static void main(String args[]) {

    int x [] [] = {{0,2},{0}};

    int totalRows = x.length;
    int totalColumns = x[0].length;

    int countPath = countPath(x, 0, 0);
    System.out.println(countPath);

  }

   static int countPath(int [][] grid, int row, int col) {
    int noOfRows = grid.length;
    int noOfColumns = grid[0].length;

    if(row == noOfRows && col == noOfColumns -1) {
      return 1;
    }

    if(row >= noOfRows) {
      return 0;
    }

    if(col >= noOfColumns) {
      return 0;
    }

    int numRightMove = countPath(grid, row, col+1);
    int numLeftMove = countPath(grid, row+1, col);
    return numRightMove + numLeftMove;
   }

}
