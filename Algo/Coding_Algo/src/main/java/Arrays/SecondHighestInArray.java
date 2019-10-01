package Arrays;

/**
 * https://www.geeksforgeeks.org/find-second-largest-element-array/
 *
 * Second highest in the array
 *
 * Input : arr[] = {12, 35, 1, 10, 34, 1}
 Output : The second largest element is 34.

 Input : arr[] = {10, 5, 10}
 Output : The second largest element is 5.

 Input : arr[] = {10, 10, 10}
 Output : The second largest does not exist.

 */
public class SecondHighestInArray {

  public static void main (String args[]) {
    int arr[] = {12, 35, 1, 10, 34, 1};
    int x = findSecondHighest(arr);
    System.out.println(x);
  }

  private static int findSecondHighest(int args[]) {
    if(args.length == 2) {
      throw new IllegalArgumentException("There is no second max in this array");
    }

    int firsMax = args[0];
    int secondNumberMax = Integer.MIN_VALUE;

    for (int i = 1; i <args.length; i++) {
     int x = args[i];

     if(x > firsMax) {
       secondNumberMax = firsMax;
       firsMax = x;
     }

     if(secondNumberMax < x  && x < firsMax) {
       secondNumberMax = x;
     }

    }

    if(secondNumberMax < firsMax && secondNumberMax != firsMax) {
      return secondNumberMax;
    } else {
      throw new IllegalArgumentException("There is no second max in this array");
    }
  }

}
