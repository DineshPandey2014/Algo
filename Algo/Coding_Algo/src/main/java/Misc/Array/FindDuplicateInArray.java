package Misc.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpandey on 9/13/17.
 *
 * https://www.youtube.com/watch?v=hl3638wuhPc
 *
 *
 */

/**
 *
 *  1. Brute force naive : O(n2) Time complexity
 *
 *  2. Using Sorting : O(n log n) + O (n) Time complexity
 *
 *  3. Using HashSet : O(n) time complexity and O(n) space complexity extra space.
 *
 *  4. Using HashMap : O(n) but space complexity and O(n) space complexity extra space.
 *
 *  5. Negatin : O(n) best
 *
 *
 */
public class FindDuplicateInArray {

    public static void main(String args[]) {
        int x [] = {1,2,2,1,3,3,4};
        findDuplicateInArray(x);
    }


    public static void findDuplicateInArray(int [] input) {
        Set<Integer> nonDuplicate = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        for(int i = 0; i < input.length; i++) {
            if(!nonDuplicate.contains(input[i])) {
                nonDuplicate.add(input[i]);
            } else {
                duplicate.add(input[i]);
            }
        }
    }
}
