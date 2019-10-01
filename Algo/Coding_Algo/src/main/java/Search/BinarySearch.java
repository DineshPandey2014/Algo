package Search;

public class BinarySearch {

  public static void main(String args[]) {
    int input [] = {1,5,23, 111};
    int target = 111;
    int output = binarySearch(input, target);
    System.out.println(output);
  }

  public static int binarySearch(int[] array, int target) {
    int n = array.length-1;
    int startIndex = 0;
    int endIndex = array.length -1;
    int mid = 0;
    while(startIndex <= endIndex) {
      mid = (endIndex + startIndex)/2;
      if(target == array[mid]) {
        return mid;
      } else if(target < array[mid]) {
        endIndex = mid -1;
      } else if(target >array[mid]) {
        startIndex = mid +1;
      }

    }
    return -1;
  }
}
