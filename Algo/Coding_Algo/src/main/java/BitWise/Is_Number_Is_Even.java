package BitWise;

/**
 * Created by dpandey on 10/16/17.
 *
 *
 * Statement:
 *   Indecate whether the given integer is even.
 *
 * Sample Input: 28
 * Sample Output: true
 *
 * Technical Details: The lowest bit of an even number is 0.
 *    0 = 0; 2 = 10; 4 = 100; 6 = 110; 8 = 1000; etc.
 *    Therefore, x AND 1 should be 0 for all even numbers.
 *
 *
 *   Decimal Representation Even number -----> Binary Representation for even number ends with 0
 *   0                                  -----> 0
 *   2                                  -----> 10
 *   4                                  -----> 100
 *
 *   Decimal Representation Odd number -----> Binary Representation of odd number ends with 1.
 *   3                                 -----> 11
 *   5                                 -----> 101
 *   7                                 -----> 111
 *   9                                 -----> 1001
 */

public class Is_Number_Is_Even {

    public static void main(String args[]) {
        System.out.println(is_Even(8));  // Even true
    }

    /**
     * Using bitwise operator & with binary number 1.
     * As least significant digit is always is always zero. By taking bitwise & it will always equal to 0
     *
     *  (number & 1) == 0
     *
     *  Other way you can do it to check the remainder by using module operator
     *
     */
    private static boolean is_Even(int number) {
            return (number & 1) == 0;
    }
}
