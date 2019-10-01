package Misc.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpandey on 10/5/17.
 *
 * Given an array of distinct elements and a number x, find if there is a pair with product equal to x.
 *
 * (Find if any pair exists)
 *
 */
public class Pair_with_given_product {
    /**
     *
     * @param number_product
     * @return
     *
     * int x = [10,20,30,3]
     * int productOfTwoNumber = 10*20 = 200
     *
     * O(n2) ---> Order of n square. There will be two loops.
     */
   static boolean  isProduct(Integer x[], int number_product) {
        for(int i = 0; i < x.length; i++) {
            for(int j=i+1; j < x.length; j++) {
                if(x[i] * x[j] == number_product) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Integer x [] = {0,20,30,3};
        //System.out.print(isProduct(x, 90));
        int result [] = foundProductOfTwoNumbers(x, 90);
        for(int i = 0; i<result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println(foundProductOfTwoNumbers(x, 90));
    }

    public static int [] foundProductOfTwoNumbers(Integer input[], int number) {
        if(input == null) {
            return new int [0];
        }

        Set<Integer>  inputData = new HashSet<>(Arrays.asList(input));
        int numbers [] = new int [2];

        for(int i = 0; i<input.length; i++) {
            if(input[i] == 0) {
                continue;
            }

            int remainder =  number % input[i];

            if(remainder == 0) {
                if (inputData.contains(number/input[i])) {
                    numbers[0] = input[i];
                    numbers[1] = number/input[i];
                }
            }
        }
        return numbers;
    }



}
