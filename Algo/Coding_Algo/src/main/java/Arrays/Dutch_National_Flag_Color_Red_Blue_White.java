package Arrays;

import org.junit.Test;

/**
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given
 * array. The functions should put all 0s first, then all 1s and all 2s in last.
 *
 * Examples:

 Input: {0, 1, 2, 0, 1, 2}
 Output: {0, 0, 1, 1, 2, 2}

 Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class Dutch_National_Flag_Color_Red_Blue_White {

  @Test
  public void testArrayManipulation() {
    int arr[] = {0, 1, 2, 0, 1, 2};
    int [] result = dutchFlag(arr, 1);
    System.out.println(result);
  }

  /*
    In this problem, we have to divide the array into 3 sections.We keep 2 boundaries -
    ​low​ and ​high​. ​Low​ starts at 0, ​High​ starts at the end of the array.Low​ contains
    numbers less than pivot. ​High​ contains numbers greater than pivot. We walk throughthe array.
    If we encounter a number less than pivot, we put it in the ​low​ boundary.
    If we encountera number greater than pivot, we put it in the ​high​ boundary.
    If the number is equal to pivot, weignore it, effectively placing it in the middle of the two boundaries.
   */
  public int [] dutchFlag(int arr[], int pivot) {

    int lowBoundary = 0;
    int highBoundary = arr.length-1;
    int i = 0;

    while(i <= highBoundary) {

      if(arr[i] < pivot) {
        swap(arr, i, lowBoundary);
        i++;
        lowBoundary++;
      } else if(arr[i] > pivot) {
        swap(arr, i, highBoundary);
        highBoundary--;
      } else if(arr[i] == pivot) {
        i++;
      }
    }
    return arr;
  }


 /* public int [] dutchFlag(int number[], int pivot) {
    int low = -1;
    int mid = -1;
    int high = number.length;

    while(mid + 1 < high) {
      if(number[mid+1] > pivot) {
        swap(number, mid+1, high-1);
        high--;
      } else if(number[mid+1] == pivot) {
        mid++;
      } else if(number[mid+1] < pivot) {
        swap(number, low+1, mid+1);
        low++;
        mid++;
      }
    }
  return number;
  }*/

  private void swap(int [] x, int i, int j) {
    int temp = x[i];
    x[i] = x[j];
    x[j] = temp;
  }
}
