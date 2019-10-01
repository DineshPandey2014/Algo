package Recursion;

import org.junit.jupiter.api.Test;

/**
 * https://www.youtube.com/watch?v=jFwREev_yvU&t=925s
 *
 */
public class NQueen {


public static void main(String args[]) {
    int board[] [] = new int [4] [4];
    solveNQueen(board, 0, 4);
    //System.out.println(board.length);
}


    static boolean  solveNQueen(int board[][],int i, int n) {

        //Base case.
        if (i == n) {
            System.out.println();
            // You have successfully place queens in a rows ( o.. n-1)
            // Print the board.
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    if (board[k][j] == 1) {
                        System.out.print(" Q ");
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }
            return false;
        }

        // Recursive case
        // Try to place the queen in the current row and call in the remaining part which
        // will be solve by recursion.

        // Moving in the  first row
        for (int j = 0; j < n; j++) {

            if (isSafe(board, i, j, n)) {
                // place the queen assuming i and j is the right postion
                board[i][j] = 1;

                boolean nextQueen = solveNQueen(board, i + 1, n);
                if (nextQueen) {
                    return true;
                }
                // Means i and j is not the right position.
                board[i][j] = 0; // Backtrack
            }
            // You have tried all postions in the current row but couldn't place the queen.

        }
        return false;
    }
/**
 * Takes the input array of chess board.
 1) Takes the input start of row.
 2) No of rows

 i represent row // startindex from 0
 j represent column // start index from 0
 n represent size of board.
 Max i can go up to n-1
 Max j can go up to  n-1
 *
 */
        static boolean isSafe (int board[][],int i, int j, int n){

            // Can we keep the queen in the column. Column check
            // If you move column back then row will get reduce and row should be greater then or equal to zero

            int x = i;
            int y = j;

            // Check if queen is attacked in the column
            while (x >= 0) {
                if (board[x][y] == 1) {
                    return false;
                }
                x--;
            }

            x = i;
            y = j;
            //Check if queen is attacked in the left diagnol

            while (x >=0 && y >= 0){
                if (board[x][y] == 1) {
                    return false;
                }
                x--;
                y--;
            }

            x = i;
            y = j;
            while (x >= 0 && y < n) {
                if (board[x][y] == 1) {
                    return false;
                }
                x--;
                y++;
            }
            return true;
        }
    }
