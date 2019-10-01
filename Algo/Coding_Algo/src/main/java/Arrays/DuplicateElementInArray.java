package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=hl3638wuhPc
 *
 * Created by dpandey on 9/18/17.
 *
 * Can be solve in 5 ways.
 *
 * 1) Brute Force(Naive method) : O(n^2)
 * 2) Using Sorting : O(nlog(n)) + O(n)
 * 3) Using hashSet : O(n) but space complexity O(n)
 * 4) Using HashMap : O(n) but space complexity O(n)
 * 5) Using Negation : O(n)
 *
 */
public class DuplicateElementInArray {
    /*
     * Using has set
     *
     */
    static void  usingHasSet(int input[]) {
        Set<Integer> set = new HashSet<>();
        for(int element : input) {
            if(set.add(element) == false) {
                System.out.println("Yes we have duplicate in the array");
            }
        }
    }

    /*
     * Using negation.
     *
     */
    /*
     * This technique will work if the numbers are less thant the lenght of the array.
     * Example: If array is the length of 5. Then numbers should be between 0 to 4 it should be positive.
     *
     */
    static void useNegationTechnique(int input[]) {

        for(int i = 0; i < input.length; i++) {
            if(input[Math.abs(input[i])] < 0) {
                System.out.println("From negation method duplicate exist " + Math.abs(input[i]));
            } else {
                int value = Math.abs(input[i]);
                input[value] = -input[value];
            }
        }
        System.out.println("input : "+ input);
    }

    public static void main(String args[]) {
        int input[] = {1,2,3,4,1};
       // usingHasSet(input);
        useNegationTechnique(input);
    }
}
