package Recursion;

/**
 *
 * /*
 We know that in one row we will have only one queen (and total n queens), so instead of 2-D
 grid we can store the information of queens' position in 1D array.
 Grid:
 --q-
 q---
 ---q
 -q--
 has queens at positions,
 row -> col
 0 -> 2,
 1 -> 0,
 2 -> 3,
 3 -> 1
 In a 1D array it can be represented as:
 arrangement[0] = 2,
 arrangement[1] = 0,
 arrangement[2] = 3,
 arrangement[3] = 1

 */
public class NqueenTest {


    public  static void main(String args[]) {
        //String  board [] [] = new String [10][10 ];
        //solveNQueen(board, 0, 10);
        //return board;
        String[][] x =find_all_arrangements(4);
    }

    static String[][] find_all_arrangements(int n) {
        String board [] [] = new String[n][n];
        if(n==1) {
            board[0][0] = "q";
            return  board;
        }

        if(n ==2 || n ==3) {
            return new String[0][0];
        }


        solveNQueen(board, 0, n);
        return board;
    }

    static boolean  solveNQueen(String board[][],int i, int n) {
        //Base case.
        if (i == n) {
            System.out.println();
            // You have successfully place queens in a rows ( o.. n-1)
            // Print the board.
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    if ("1".equalsIgnoreCase(board[k][j])) {
                        System.out.print("q");
                    } else {
                        System.out.print("-");
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
                board[i][j] = "1";

                boolean nextQueen = solveNQueen(board, i + 1, n);
                if (nextQueen) {
                    return true;
                }
                // Means i and j is not the right position.
                board[i][j] = "0"; // Backtrack
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
    static boolean isSafe (String board[][],int i, int j, int n){

        // Can we keep the queen in the column. Column check
        // If you move column back then row will get reduce and row should be greater then or equal to zero

        int x = i;
        int y = j;

        // Check if queen is attacked in the column
        while (x >= 0) {
            if ("1".equalsIgnoreCase(board[x][y])) {
                return false;
            }
            x--;
        }

        x = i;
        y = j;
        //Check if queen is attacked in the left diagnol

        while (x >=0 && y >= 0){
            if ("1".equalsIgnoreCase(board[x][y])) {
                return false;
            }
            x--;
            y--;
        }

        x = i;
        y = j;
        while (x >= 0 && y < n) {
            if ("1".equalsIgnoreCase(board[x][y])) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
}
