package Arrays;

import java.util.Arrays;

public class Largest_Range {

  public static void main(String args[]) {
      //int x[] = {1};
       /*
      int x[] = {1,2};
      int result [] = largestRange(x);
      */


    int x[] = {19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11,8,7,6,15,12,12,2,1,6,13,14};
    int result [] = largestRange(x);
    // Answer result = [10,19]

    /*
    int x[] = {4,2,1,3,6};
    int result [] = largestRange(x);
    */


    // Answer result = [1,4]
  }

  public static int[] largestRange(int[] array) {
    Arrays.sort(array);
    // Three pointer here i, j , k

    int i = 0;
    int j = 0;
    int k = 0;
    int outputLengthGlobal = 0;

    int output [] = new int [2];

    if(array.length == 1) {
      return new int [] {array[0], array[0]};
    }

    while(i < array.length) {
      j = i + 1;
      k = i;

      while(j < array.length) {
        int diff = Math.abs(array[j] - array[k]);
        if(diff == 1 || diff == 0) {
        int  outputLengthIndexLocal = j - i;
          if(outputLengthIndexLocal > outputLengthGlobal) {
            output[0] = array[i];
            output[1] = array[j];
            outputLengthGlobal = outputLengthIndexLocal;
          }
          k++;
          j++;
        } else {
          break;
        }
      }
      i++;
    }
    return output;
  }
}
