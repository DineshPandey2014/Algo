package Arrays;

import java.util.Arrays;

public class Binary_Search_Array_Java_Implementation {

//  public static void main(String args[]) {
//    int input [] = {10,20,25,27,35};
//    int output = Arrays.binarySearch(input, 20);
//    System.out.println(output);
//    int charArr [] = {'g','p','q','c','i'};
//  }

  public static void main(String[] args)
  {
    byte byteArr[] = {10,20,15,22,35};
    char charArr[] = {'g','p','q','c','i'};
    int intArr[] = {10,20,15,22,35};
    double doubleArr[] = {10.2,15.1,2.2,3.5};
    float floatArr[] = {10.2f,15.1f,2.2f,3.5f};
    short shortArr[] = {10,20,15,22,35};

    Arrays.sort(byteArr);
    Arrays.sort(charArr);
    Arrays.sort(intArr);
    Arrays.sort(doubleArr);
    Arrays.sort(floatArr);
    Arrays.sort(shortArr);

    byte byteKey = 35;
    char charKey = 'g';
    int intKey = 22;
    double doubleKey = 1.5;
    float floatKey = 35;
    short shortKey = 5;

    System.out.println(byteKey + " found at index = "
            +Arrays.binarySearch(byteArr,byteKey));
    System.out.println(charKey + " found at index = "
            +Arrays.binarySearch(charArr,charKey));
    System.out.println(intKey + " found at index = "
            +Arrays.binarySearch(intArr,intKey));
    System.out.println(doubleKey + " found at index = "
            +Arrays.binarySearch(doubleArr,doubleKey));
    System.out.println(floatKey + " found at index = "
            +Arrays.binarySearch(floatArr,floatKey));
    System.out.println(shortKey + " found at index = "
            +Arrays.binarySearch(shortArr,shortKey));
  }
}
