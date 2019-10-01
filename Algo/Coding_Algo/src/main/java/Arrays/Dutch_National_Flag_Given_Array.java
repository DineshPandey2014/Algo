package Arrays;


import org.junit.Test;

/**
 * Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
 * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0},
 * it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
 * The order of all other elements should be same.
 * Expected time complexity is O(n) and extra space is O(1).
 *
 * Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
 Output : arr[] = {1, 2, 4, 3, 5, 0, 0};

 Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
 Output : arr[] = {1, 2, 3, 6, 0, 0, 0};

 */
public class Dutch_National_Flag_Given_Array {

  @Test
  public void testArrayManipulation() {
    int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
    int [] result = arrayManipiulation(arr, 0);
  }

  public int[] arrayManipiulation(int [] x, int number) {
    int low = -1;
    int mid = -1;
    int high = x.length;

    while (mid+1 < high) {

      if(x[mid+1] > number) {
        swap(x, mid+1, low+1 );
        low++;
        mid++;
      } else if (x[mid+1] == number) {
        mid++;
      }
    }
    return x;
  }

  private void swap(int [] x, int i, int j) {
      int temp = x[i];
      x[i] = x[j];
      x[j] = temp;
  }



  /*public int[] arrayManipiulation(int [] x, int number) {
    int low = -1;
    int mid = -1;
    int high = x.length;

    while (mid+1 < high) {

      if(x[mid+1] > number) {
        swap(x, mid+1, high-1 );
        high--;
      } else if (x[mid+1] == number) {
        mid++;
      } else  if(x[mid+1]< number){
        swap(x, mid+1, low+1);
        mid++;
        low++;
      }
    }
    return x;*/

}
