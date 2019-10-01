package Arrays;

import org.junit.Test;

/**
 * Input :mat[][] = { {10, 20, 30, 40},
 {15, 25, 35, 45},
 {27, 29, 37, 48},
 {32, 33, 39, 50}};

 Output : 10 20 30 40 45 35 25 15 27 29
 37 48 50 39 33 32

 Input :mat[][] = { {1, 2, 3},
 {4, 5, 6},
 {7, 8, 9}};
 Output : 1 2 3 6 5 4 7 8 9
 */

public class PrintSnakePattern_Matrix {

  @Test
  public void printSnakeMatrix() {
    int matrix [][] = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
    };
    printSnakeMatrix(matrix);
  }

  public void printSnakeMatrix(int matrix [][]) {

    for (int i = 0; i < matrix.length; i++) {

      if(i%2 == 0) {
        //System.out.println();
        // When i is even print left to right
        for (int j = 0; j < matrix[0].length; j++) {
          System.out.print(matrix[i][j] + " ");
        }
      } else {
        //System.out.println();
        // When i is odd print right to left
        for (int k = matrix[0].length -1 ; k >= 0; k-- ) {
          System.out.print(matrix[i][k] + " ");
        }
      }

    }

  }

}
