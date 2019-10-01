package Arrays;

import org.junit.Test;

public class Replace_Each_Even_Number_With_2 {

  // Example : [2,2,4,4,1,0,0,3]


 @Test
public  void TestEvenNumbers() {
   int  input [] = {2,4,1,0,3,}; //     3,1,8,8,1,4,4

    int result [] = replaceEvenNumbers_By_2(input);
    System.out.println(result);
 }

  /*
    Question from interviewer.
    Q1) Is array is having enough length to accomdate the modifed array.
    Answer: Yes input array is sufficent to hold new even numbers.

    Q2) Is array is continous filled filled

    Q3) All the empty position in array will be on thr last.


    Algo:
    1. Start from right end of array.
    2. Check each value if it is even number
        num%2 == 0 For even number
    3. Filled the array last two position with this number.
    4. Continue this moves the number from right to left.
    5. If the number is not even move this number to right
   */
  public static int [] replaceEvenNumbers_By_2(int input[]) {
    int j = input.length-1;

    for (int i = input.length-1; i >= 0 ; i--) {
     // [2,3,2,8,0 ,0,0]
      if(input[i] != 0 && input[i]%2 == 0 && j>=0) {
          input[j] = input[i];
          j--;
          input[j] = input[i];
          j--;
      }

      if(input[i] != 0 && input[i]%2 != 0 && j>=0 ) {
        input[j] = input[i];
        j--;
      }

    }
    return input;
  }

}
