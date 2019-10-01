package Arrays;

public class DiagonalTraverse2DMatrix {


  public static void main(String args[]) {
    int  [] [] nums = {{1, 2, 3}, {4, 5, 6 },{7, 8, 9}};
    printMAtrixDiagonal(nums);
  }

  static void printMAtrixDiagonal(int nums[][]) {
    int m = nums.length; // Length of rows
    int n = nums.length; // Length of columns

    int i = 0;
    int j = 0;

     /*
      [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
   */
    // Loop over rows m = 3 n = 3;
    for (int k = 0; k <= m-1; k++ ) {
      i = k; // i represent row we will decrement
      j = 0; // j = represent column we will increment

      while(i >=0 ) {
        int x = nums [i][j];
        System.out.print(x);
        System.out.print(" ");
        i--;
        j++;
      }
    }

     /*
      [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
   */
    // Loop over columns
    for (int k = 1; k <= n-1; k++) {
      i = m-1; // Row we will decrement till it becomes 0;
      j = k; // Column we will increment.

      while(j <= n-1) {
        int x = nums[i][j];
        System.out.print(x);
        System.out.print(" ");
        i--;
        j++;
      }

    }
  }

}
