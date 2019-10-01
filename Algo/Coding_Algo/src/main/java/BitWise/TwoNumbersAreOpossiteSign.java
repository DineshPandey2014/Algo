package BitWise;

/**
 * Created by dpandey on 10/13/17.
 */

import org.junit.Test;

/**
 *  Check if two numbers are opossite  sign to each other.
 *
 *  There are two ways one is branching.
 *
 *  1) One is branching
 *  2) Use bitwise operator
 */
public class TwoNumbersAreOpossiteSign {

    public static void main(String args[]) {
        int numberOne = 22;
        int numberTwo = 33;
        boolean number = isSigned_UsingBranching(numberOne, numberTwo); // false
        System.out.println("----number---"+number);

        int number1 = -22;
        int number2 = -33;
        boolean number3 = isSigned_UsingBranching(number1, number2); // true
        System.out.println("----number---"+number3);

        int number4 = 22;
        int number5 = -33;
        boolean number6 = isSigned_UsingBranching(number4, number5); // true
        System.out.println("----number---"+number6);

        int number7 = 5;
        int number8 = 7;
        boolean number9 = isSigned_Using_XOR_Operator(number7, number8);
        System.out.println("----number9---"+number9);

    }

    /*
     * Check if two numbers are opossite sign to each other.
     * 1) If (x > 0 && y>0) ----> Both are positive hence not opossite to each other
     *    else both are of opossite to each other.
     */
    @Test
    public static boolean isSigned_UsingBranching(int numberOne, int numberTwo) {
        if((numberOne > 0 && numberTwo>0) || (numberOne < 0 && numberTwo <0)){
            return false; // Not opossite to each other.
        } else {
            return true; // Opossite to each other.
        }
    }

    /**
     *
     * XOR (^)
     * 1) If both number are positive means signed bit is 0
     *
     *
     */
    public static boolean isSigned_Using_XOR_Operator(int numberOne, int numberTwo) {
        if((numberOne ^ numberTwo) < 0){
            return true;
        }
        return false;
    }



}
