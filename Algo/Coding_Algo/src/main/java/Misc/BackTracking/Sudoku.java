package Misc.BackTracking;

import org.junit.Test;

/**
 * Created by dpandey on 9/26/17.
 *
 * // http://codepad.org/GCTKUKRr
 * // Source : https://www.youtube.com/watch?v=P9_F7kuHU90
 */
public class Sudoku {

    /* Takes a partially filled-in grid and attempts to assign values to
  all unassigned locations in such a way to meet the requirements
  for Sudoku solution (non-duplication across rows, columns, and boxes) */
    boolean SolveSudoku(int grid[][])
    {
        int row = 0, col = 0;

        // If there is no unassigned location, we are done
        if (!FindUnassignedLocation(grid, row, col, N))
            return true; // success!

        // consider digits 1 to 9
        for (int num = 1; num <= N; num++)
        {
            // if looks promising
            if (isSafe(grid, row, col, num, N))
            {
                // make tentative assignment
                grid[row][col] = num;

                // return, if success, yay!
                if (SolveSudoku(grid))
                    return true;

                // failure, unmake & try again
                grid[row][col] = 0;
            }
        }
        return false; // this triggers backtracking
    }

    int SQN = 2;
    int N = 4;
    /*
       Searches the grid to find an entry that is still unassigned. If
       found, the reference parameters row, col will be set the location
       that is unassigned, and true is returned. If no unassigned entries
       remain, false is returned.
    */

    boolean FindUnassignedLocation(int grid[][], int row, int col, int N)
    {
        for (row = 0; row < N; row++) {
            for (col = 0; col < N; col++) {
                if (grid[row][col] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Returns a boolean which indicates whether any assigned entry
   in the specified row matches the given number.
   */
    boolean usedInRow(int grid[][], int row, int num, int N)
    {
        for (int col = 0; col < N; col++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    /* Returns a boolean which indicates whether any assigned entry
   in the specified column matches the given number. */
    boolean usedInCol(int grid[][], int col, int num, int N)
    {
        for (int row = 0; row < N; row++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    /* Returns a boolean which indicates whether any assigned entry
   within the specified 3x3 box matches the given number. */
    boolean usedInBox(int grid[][], int boxStartRow, int boxStartCol, int num, int N)
    {
        for (int row = 0; row < SQN; row++)
            for (int col = 0; col < SQN; col++)
                if (grid[row+boxStartRow][col+boxStartCol] == num)
                    return true;
        return false;
    }

    /* Returns a boolean which indicates whether it will be legal to assign
   num to the given row,col location. */
    boolean isSafe(int grid[][], int row, int col, int num, int N)
    {
    /* Check if 'num' is not already placed in current row,
       current column and current 3x3 box */
        return !usedInRow(grid, row, num, N) &&
                !usedInCol(grid, col, num, N) &&
                !usedInBox(grid, row - row%SQN , col - col%SQN, num, N);
    }

    /* A utility function to print grid  */
    void printGrid(int grid[][], int N)
    {
        for (int row = 0; row < N; row++)
        {
            for (int col = 0; col < N; col++) {
                System.out.print(grid[row][col]);
                System.out.print("\n");
            }
        }
    }

    @Test
   public void testSudoku() {
        // 0 means unassigned cells
        int grid[][] = {{0,0,3,4}, {3,4,0,0}, {0,0,4,3}, {0,3,2,0}};

        if (SolveSudoku(grid) == true)
            System.out.println(grid);
        else
            System.out.println("No solution exists");

    }

}
