package Arrays;

/**
 * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
 * The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.

 Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.

 Example 1:

 10
 Input: [4, 6, 10], key = 6
 Output: 1
 Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
 Example 2:

 10, 15]
 Input: [1, 3, 8, 10, 15], key = 12
 Output: 4
 Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
 Example 3:

 ey = 17
 Input: [4, 6, 10], key = 17
 Output: -1
 Explanation: There is no number greater than or equal to '17' in the given array.

 */
public class Binary_Search_Ceiling_of_A_Number {
  // Given array is sorted in Ascending order.
  public static int searchCeilingOfANumber_Smallest_Number_In_Array_Greater_The_KEY(int[] arr, int key) {
    // We need to find a number which is smallest in the array. Which is greater then or equal to the Key.
    // Here we will search the element in the Array.
    // In each step we will reduce the array half of its size.
    // If we found the element we will return the element.
    // Else if we not find  the element. The last search in the array. The start element index will be
    // the one which is smallest in the array but greater then or equal to the key.

    int start  = 0;
    int end  = arr.length - 1;

    int lengthArr = arr.length;

    if(arr[arr.length - 1] < key) {
      return  -1;
    }

    while (start <= end) {
      int mid = end + (start - end)/2; // Find the mid point

      if(arr[mid] == key) {
        return key;
      } else if(arr[mid] > key) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    System.out.println(Binary_Search_Ceiling_of_A_Number.searchCeilingOfANumber_Smallest_Number_In_Array_Greater_The_KEY(new int[] {
            4, 6, 10 }, 6));
    System.out.println(Binary_Search_Ceiling_of_A_Number.searchCeilingOfANumber_Smallest_Number_In_Array_Greater_The_KEY(new int[] {
            1, 3, 8, 10, 15 }, 12));
    System.out.println(Binary_Search_Ceiling_of_A_Number.searchCeilingOfANumber_Smallest_Number_In_Array_Greater_The_KEY(new int[] {
            4, 6, 10 }, 17));
    System.out.println(Binary_Search_Ceiling_of_A_Number.searchCeilingOfANumber_Smallest_Number_In_Array_Greater_The_KEY(new int[] {
            4, 6, 10 }, -1));
  }

  /**
   *
   * Given an array of numbers sorted in ascending order, find the floor of a given number ‘key’.
   * The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’

   Write a function to return the index of the floor of the ‘key’. If there isn’t a floor, return -1.

   Example 1:

   Input: [4, 6, 10], key = 6
   Output: 1
   Explanation: The biggest number smaller than or equal to '6' is '6' having index '1'.
   Example 2:

   Input: [1, 3, 8, 10, 15], key = 12
   Output: 3
   Explanation: The biggest number smaller than or equal to '12' is '10' having index '3'.

   Example 3:

   Input: [4, 6, 10], key = 17
   Output: 2
   Explanation: The biggest number smaller than or equal to '17' is '10' having index '2'.
   Example 4:

   Input: [4, 6, 10], key = -1
   Output: -1
   Explanation: There is no number smaller than or equal to '-1' in the given array.
   */

  // Here we will return end index if Element not found if found return mid.
  //
  public static int searchFloorOfANumber(int[] arr, int key) {
    if (key < arr[0]) // if the 'key' is smaller than the smallest element
      return -1;

    int start = 0, end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (key < arr[mid]) {
        end = mid - 1;
      } else if (key > arr[mid]) {
        start = mid + 1;
      } else { // found the key
        return mid;
      }
    }
    // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
    // we are not able to find the element in the given array, so the next smaller number will be arr[end]
    return end;
  }
}
