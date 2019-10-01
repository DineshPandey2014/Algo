package BitWise;

/**
 * Created by dpandey on 10/9/17.
 */
public class BitWiseOperator_AND_OR_NEGATION {

    public static void main(String args[]) {

        System.out.println("************* AND OPERATOR For Boolean *************************");
        // AND Operator (&) If operand is boolean the result will be boolean
        System.out.println("true & true-->"+ (true & true)); // true
        System.out.println("true & false-->"+ (true & false)); // false
        System.out.println("false & true-->"+(false & true)); //false
        System.out.println(false & false); //false
        System.out.println("*****************************************************************");

        System.out.println("************* OR OPERATOR For Boolean ***************************");
        // OR Operator (|)
        System.out.println(true  | true); //---> true ---> if operand is boolean the result will be boolean
        System.out.println(true  | false); //---> true
        System.out.println(false | true); //---> true
        System.out.println(false | false); //---> false
        System.out.println("************************************************************************");

        System.out.println("*************Exclusive OR OPERATOR For Boolean***************************");
        // Exclusive OR (^)
        System.out.println(true  | true); //---> false --> if operand is boolean the result will be boolean
        System.out.println(false  | true); //---> true
        System.out.println(true  | false); //---> true
        System.out.println(false  | false); //---> true
        System.out.println("***************************************************************************");


        System.out.println("************* AND OPERATOR For Number based on binary digit *************************");
        // AND Operator (&) for binary representation.
        System.out.println("4 & 5-->"+(4 & 5)); // Returns 4 as a decimal number
        System.out.println("100 & 101-->"+(100 & 101)); // Returns 100 as binary number

        System.out.println("****************************************************************");

        System.out.println("************** OR OPERATOR For Number based and binary digit***************************");
        // OR Operator (|) for binary representation.
        System.out.println("4 | 5-->"+(4 | 5)); // Returns 4 as a decimal number
        System.out.println("100 | 101-->"+(100 | 101)); // Returns 101 as binary number
        System.out.println("****************************************************************");

        System.out.println("*************Exclusive OR OPERATOR Number and on binary digit***************************");
        // Exclusive OR (^)
        System.out.println("4 ^ 5-->"+(4 ^ 5)); // 1
        System.out.println("Exclusive or operator (1 ^ 1) " + (1 ^ 1)); // Returns 0
        System.out.println("Exclusive or operator (0 ^ 0) " + (0 ^ 0)); // Returns 0
        System.out.println("Exclusive or operator (1 ^ 0) " + (1 ^ 0)); // Returns 1
        System.out.println("Exclusive or operator (0 ^ 1) " + (0 ^ 1)); // Returns 1
        System.out.println("100 ^ 101-->"+(100 ^ 101)); // 001
        System.out.println("-100 ^ -101-->"+(-100 ^ -101));

         /* How to represent a negative number
         * -2 --> 00000010 ---> 1's complement---->11111101 -----> add 1 ----> (11111101 + 00000001) ---> 11111110
         * 3 ---> 00000011 --->
         * ( 3 ^ 2) ---> (00000011 ^ 11111110) ---> 11111101 ----1's Complement-> (00000010) ---2's Complement--> (00000010 + 1) --->10000011 ----> -3
         */

        System.out.println("------3^-2----->: "+ (3^-2));

        System.out.println("***************************************************************************");

        System.out.println("*************Negate ~ OPERATOR For Number based***************************");
        // Exclusive OR (^)
        /**
         *  In memory number 4 is stored as 32 bits (00000000 ...............100)
         *  Extreme bit is signed bit (For positive number it is 0) (For negative number it is 1)
         *
         *  If number is negative the value stored in 2's complement.
         *
         */
        System.out.println("~4-->"+(~4));
        // 4 ---> 100 ---> 32 bit---> 0000000000 ...........100
        // ~ ---> ~(0000000000 ...........100) ---> 11111111...................011) ---> It's a negative number as
        // extreme left digit is 1. Which makes it negative. It's value stored in 2's complement.
        /**
         *  One's complement --> 0000000......100
         *  Two's complement --> 0000000......001
         *  ---------------------------------------
         *                       0000000......101 --> 4+0+1 -->5
         *                       It's a singed bit -5 is the answer
         */

        System.out.println("~ 100--> "+(~ 100)); // -101
        System.out.println("***************************************************************************");


    }



}
