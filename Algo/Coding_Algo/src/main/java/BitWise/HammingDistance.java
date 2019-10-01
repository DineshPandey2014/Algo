package BitWise;

import org.junit.Test;

public class HammingDistance {

  @Test
  public void testHammingDistance() {
    int hammingDistance = hammingDistance(1, 4);
    System.out.println(hammingDistance);
  }

  public static int hammingDistance(int x, int y) {

    // Using XOR operator which is ^
    // When both bits are different then it is 1 example
    // 0 ^ 1 ==> 1 (Both are different then it is equal to one)
    // 1 ^ 0 ==> 1 (Both are different then it is equasl to one)
    // 0 ^ 0 => 0
    // 1 ^ 1 => 0

    // To check each bit we can start from extreme left sise. Here we are not converting number to binary number
    // Trick is using java modulous operator % and find the remainder.
    // If number is even last bit in binary is 0
    // If number is odd last bit in binary is 1
    // And then we will do left shift of the number by 1 bit. Which is division by 2

    // Example : Number is 4 and 5
    // int x = 4 => Even (100)
    // int x = 5 => Odd   (101)
    // x ^ y ==> 100 ^ 101 = 1 (Answer)

    // So last bit of number will be (4%2)^(5%2) => 0 ^ 1 => 1
    // Then do left shift which division by 2 4/2 => 2  and 5/2 => 2
    // Then we do XOR operator for (2%2) ^ (2%2) => 0 ^ 0 = > 0
    // And again do left shift for x = 10 >>1 and y 10 >>1
    // And the do (1%1) ==> (1%2) ^ (1%2) =>  0 ^ 0 => 0
    // Now the total count will be 1

    // Suppose number is 4 and 5
    //

    // So here what will be the while condition. Now we have two numbers. while loop will run till we have any number
    // is less thenzero will get exit from while loop
    int result = 0;

    // while(x > 0 || y >0) {
    //     // Mod operator will tell about the last digit is 1 or 0
    //     // if it is 1 means number is odd
    //     // if it is 0 means number is even
    //     result = result + (x%2) ^ (y%2);
    //     x>>=1;
    //     y>>=1;
    //     // Now to check the second last digits of each number we will do left shift which is meaning division by 2
    //     //x = x >>1; // Left shift by 1 bit
    //     //y = y >>1; // Left shift by 1 bit;
    //    }
    // return result;

    // Second solution is find the XOR of two numbers and then check each bits if it is 1 or 0 by using modulo operator

    int z = x ^ y;
    int count = 0;

    while(z!= 0) {
      if (z%2 == 1) {
        count++;
      }
      //z = z/2;
      z  = z >> 1; // Same as divide the number by 2 => count
    }
    return count;
  }
}
