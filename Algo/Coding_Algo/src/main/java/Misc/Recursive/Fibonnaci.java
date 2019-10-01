package Misc.Recursive;

/**
 * Created by dpandey on 9/18/17.
 *
 * The Fibonnaci numbers are the numbers in the following integer sequence, called the fibonnaci sequence.
 * And characterized by the fact every number after the first two is the sum of the two precediong ones.
 *
 *
 * 0,1,1,2,3,5,8,13,34,55,89,144
 *
 * In mathetical terms the sequence Fn of Fibonnaci numbers is defined by the recurrence relation.
 *
 * F_(n) = F_{n-1} + F_{n-2}
 *
 * With seed values
 * F_{0} = 0,F_{1}=1
 */
public class Fibonnaci {
    /*
     * Fibonnaci using recursion. Internall it uses STACK
     */
   static int Fibonnaci_Number_Recursion(int n) {

        if(n <= 1) {
            return n;
        }
        // 5 --> 5-1 + 5-2
        // 5-1--> 4-1 + 4-2
        // 5-2 --> 3-1 + 3-2
        // 4-2 --> 2-1 + 2-2
        return Fibonnaci_Number_Recursion(n-1) + Fibonnaci_Number_Recursion(n-2);
    }

    static int Fibonnaci_Dynamic_Programming(int n) {
        int fib[] = new int[n];

        if(n <= 1 ) {
            return n;
        }

        fib[0] = 0;
        fib[1] = 1;

        // 0,1,1,2,3,5
        // f[0] = 0;
        // f[1] = 1;
        // f[2] = f[0] + f[1] --> 1
        // f[3] = f[2] + f[1]  --> 2
        // f[4] = f[2] + f[3] --> 3

        for (int  i = 2; i < fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n-1];
    }

    public static void main(String args[]) {
        // 1,1,2,3,5,8
       int number =  Fibonnaci_Number_Recursion(3);
        System.out.println(number);

        //int number_DP =  Fibbonnaci_DP(3);
        //System.out.println(number_DP);
    }


}
