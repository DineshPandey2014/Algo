package Arrays;


/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Same Question that is done Find first and last position in the array.
 */
public class Binary_Search_Number_Range {
  // Time Complexity will be O(n)
  // Space Complexity will be O(1). Even we increasing the numbers space is not increasing extra space.
  public static int[] findRange(int[] arr, int key) {
    int[] result = new int[] { -1, -1 };
    // TODO: Write your code here
    int indexLeft = findIndex (arr, key, true);
    int indexRight = findIndex(arr, key, false);

    if(indexLeft != -1) {
      result[0] = indexLeft;
    }

    if(indexRight != -1) {
      result [1] = indexRight;
    }
    return result;
  }

  static int findIndex (int arr[], int key, boolean flag) {
    int start = 0;
    int end  = arr.length -1;
    // We are initalzing index as -1. Because index starts from 0 in the array.
    // If number not found we will get index -1;
    int keyIndex = -1;

    while  (start <= end) {
      int mid = end + (start - end)/2; // Will find the index of near mid point
      if(arr[mid] == key) {
        // Here we are assignining the index as -1. Element that we found at extreme left of the array.
        keyIndex = mid;
        if(flag) { // Move left index
          end = mid -1;
        } else {
          start = mid + 1; // Move right to find index
        }
      } else if(arr[mid] < key) {
        start = mid + 1;
      } {
        end = mid -1;
      }
    }
    return keyIndex;
  }

  // static int findRightIndex (int arr[], int key) {
  //   int start = 0;
  //   int end  = arr.length -1;
  //   // We are initalzing index as -1. Because index starts from 0 in the array.
  //   // If number not found we will get index -1;
  //   int keyIndex = -1;

  //   while  (start <= end) {
  //     int mid = end + (start - end)/2; // Will find the index of near mid point
  //     if(arr[mid] == key) {
  //       // Here we are assignining the index as -1. Element that we found at extreme left of the array.
  //       keyIndex = mid;
  //       start = mid + 1;
  //     } else if(arr[mid] < key) {
  //         start = mid + 1;
  //     } {
  //         end = mid -1;
  //     }
  //   }
  //   return keyIndex;
  // }

  public static void main(String[] args) {
    int[] result = Binary_Search_Number_Range.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = Binary_Search_Number_Range.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = Binary_Search_Number_Range.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
  }
}
