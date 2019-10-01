package Recursion;

/**
 * https://www.youtube.com/watch?v=CLvNe-8-6s8
 *
 * Number of island solved using recursive. This problem can be solved as graphs as well.
 *
 */

public class NumberOfIsland {

  /* Algo
        1. Traverse each row and column.
        2. Start from that cell which have character of 1. Means only if there
        is island.
        3. initalize the count of island as 0;
        5 Count the result from where it is called
        4. Call driver function increment the counter.
        5. put exit condition
        6. Final grid will get transformed to all 0.
        */
  public static void main(String args[]) {

    char grid [] [] ={{'1','1','0','0','0'},
                     {'1','1','0','0','0'},
                      {'0','0','0','0','0'},
                      {'0','0','0','0','1'}};
    int countOfIsland = numIslands(grid); // 1
    System.out.println("countOfIsland : "+countOfIsland);
  }

  public static int numIslands(char[][] grid) {
    if(grid == null) {
      return 0;
    }
    int islandCount = 0;
    // Traverse all the row by row.
    for(int row = 0; row < grid.length; row++) {
      for(int col = 0; col< grid[0].length; col++) {

        if(grid[row][col] == '1') {
          // Here we are counting the islands initally when we started. After that
          // we are processing each cell to it's right and left and changing the index from 1 to
          //0;
          // Increment the island Count;
          islandCount++;
          convertLandToWater(grid, row, col);
          // Call recursive function to convert Land to water.

        }

      }
    }
    return islandCount;
  }

  public static void convertLandToWater(char [][] grid, int row, int col) {

    // Exit condition
    // If row is less then 0
    // If row length is greater then grid length.
    // if column is less then 0
    // If column length is greater then the grid column length.
    // IF grid positions contains 0

    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
      return;
    }
    // Here we are changingin the grid state from 1 to 0
    grid[row][col] = '0';
    convertLandToWater(grid, row - 1, col); // Move Up same column index only row index will change
    convertLandToWater(grid, row + 1, col);  // Move down same column index only row index will change
    convertLandToWater(grid, row, col - 1 );  // Move left same row index only column index will change
    convertLandToWater(grid, row, col + 1);  // Move right same row index only column index will change

  }
}