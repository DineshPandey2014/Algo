package Arrays;

import org.junit.Test;

/**
 * About four months of gap (missing GFG), a new post. Given an M x N matrix, transpose the matrix without auxiliary
 * memory.It is easy to transpose matrix using an auxiliary array. If the matrix is symmetric
 * in size, we can transpose the matrix inplace by mirroring the 2D array across it’s diagonal
 * (try yourself). How to transpose an arbitrary size matrix inplace? See the following matrix,
 */
public class TransposeMatrix {

  @Test
  public void printSnakeMatrix() {
    int matrix [][] = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
    };
    transposeMatrix(matrix);
  }

  public void transposeMatrix(int matrix [][]) {

    for (int i = 0; i < matrix.length; i++) {
      // i = 0 --> j --> 1, 2, 3
      for (int j = i+1; j < matrix[0].length ; j++) {
        if (i == j) {

        }
      }
    }

  }
}
