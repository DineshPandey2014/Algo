package Arrays;

import org.junit.Test;

/**
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original array except the one at i.

 For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 If our input was [3, 2, 1], the expected output would be [2, 3, 6].

 Follow-up: what if you can't use division?

 We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us
 an email if there's anything we can help with.

 */
public class Product_Of_All_Numbers_Except_At_Own_INdex {

  @Test
  public void testProductOfNumbers() {
    int input [] = {3, 2, 1};
    int result [] =  productOfNumbersExceptOwnIndex(input);
    System.out.println(result);

    for (int product : result) {
      System.out.println(product);
    }
  }

  /**
   * Using divisio
   * @param input
   * @return
   */
  public int [] productOfNumbersExceptOwnIndex(int input[]) {
    int totalProductOfNumbersInArray = input[0];

    for(int  i = 1; i < input.length; i++) {
      totalProductOfNumbersInArray = totalProductOfNumbersInArray * input[i];
    }

    for(int  i = 0; i < input.length; i++) {
      input[i] = totalProductOfNumbersInArray/input[i];
    }
    return input;
  }

}
