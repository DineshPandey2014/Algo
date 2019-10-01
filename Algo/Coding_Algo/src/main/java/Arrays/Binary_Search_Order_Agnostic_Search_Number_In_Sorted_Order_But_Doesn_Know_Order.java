package Arrays;

public class Binary_Search_Order_Agnostic_Search_Number_In_Sorted_Order_But_Doesn_Know_Order {

  public static int search(int[] arr, int target) {
    // In this binary Search we don't know the number are in sorted order in ascending or
    // descending order.
    int start = 0;
    int end = arr.length - 1;
    boolean isAscendingOrder = arr[0] < arr[end] ? true : false;
    int keyIndex = -1;

     // 10, 6 , 4
    // start = 0;
    // end = 2

    while (start <= end) {
      int mid = end + (start - end)/2; // mid 1
      if(arr[mid]== target) {
        keyIndex = mid;
        return keyIndex;
      } else if(isAscendingOrder) {
        // Array is sorted in ascending order.
        if(arr[mid] < target) {
          start = mid + 1;
        } else {
          end = mid -1;
        }
      } else {
        // Array is sorted in descending order
        if(arr[mid] < target) {
          end  = mid -1;
        } else {
          start = mid + 1;
        }
      }

    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(Binary_Search_Order_Agnostic_Search_Number_In_Sorted_Order_But_Doesn_Know_Order.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(Binary_Search_Order_Agnostic_Search_Number_In_Sorted_Order_But_Doesn_Know_Order.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(Binary_Search_Order_Agnostic_Search_Number_In_Sorted_Order_But_Doesn_Know_Order.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(Binary_Search_Order_Agnostic_Search_Number_In_Sorted_Order_But_Doesn_Know_Order.search(new int[] { 10, 6, 4 }, 4));
  }
}
