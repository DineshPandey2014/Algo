package Misc.Recursive;

/**
 * Created by dpandey on 9/18/17.
 */
public class Factorial {

    /**
     * Factorial function using recursion.
     * @param n
     * @return
     */
    int factorial_recursion(int n) {
        if(n == 1) {
            return 1;
        }

        if(n == 0) {
            return 1;
        }

        return factorial_recursion(n * n-1);
    }



}
