package Misc.Recursive;

import org.junit.Test;

/**
 * Created by dpandey on 11/15/17.
 * Pow(x, n)
 * Need to do log(n)
 *
 * Not O(n)
 */
public class Power_X_Y {

     double  powerProduct = 0;

    @Test
    public  void test() {
       //double y = myPow(2,4);
        //System.out.println(y);
    }

    /* Using recursion here we have not considered where n can be negative
     * Order(n)
     *
     */
    public  double power(double x, int n) {
        if(n == 1) {
            return x;
        }
        powerProduct = x * power(x, n-1);
        return powerProduct;
    }

    @Test
    public void testOne() {
        System.out.println(power(34,-1));
    }

    /*
     * Time complexity of Order(n)
     *
     * Iterative solution
     */
    public int  power(int x, int n) {
        int power = 1;
        int z = 1;

        if(n == 0 && x != 0) {
            return 1;
        }

        if(n == 0 && x == 0) {
            return 0;
        }

        if( n == 1) {
            return x;
        }

        while(z <= n) {
            power = power * x;
            ++z;
        }
        return power;
    }

    @Test
    public void testRecursive() {
       int z = power_Recursive_Based_On_Even_Odd(2,2);
        System.out.print(z);
    }

    /*
     * Time complexity is log(n)
     */
    public int power_Recursive_Based_On_Even_Odd(int x, int n) {
        if(n == 0 && x != 0) {
            return 1;
        }

        if(n == 0 && x == 0) {
            return 0;
        }

        if( n == 1) {
            return x;
        }

        // If n is even
        if(n/2 == 0) {
            int y = power_Recursive_Based_On_Even_Odd (x, n/2);
            return (y*y);
        }

        return  (x* power_Recursive_Based_On_Even_Odd(x,n-1));
    }


}
