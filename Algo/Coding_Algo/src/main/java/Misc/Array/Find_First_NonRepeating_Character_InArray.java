package Misc.Array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by dpandey on 10/28/17.
 *
 *
 */
public class Find_First_NonRepeating_Character_InArray {

    public static void main(String args[]) {
       // String inputString = ;
        String inputString = "abcdz";

        for(int x = 0; x < inputString.length(); x++) {
            System.out.println((int) inputString.charAt(x));
        }

        Integer nonRepeatingChar = getFirstNonRepeatingCharacter(inputString);
        if(nonRepeatingChar != null) {
            System.out.println("Non repeating character---> : " + nonRepeatingChar);
        } else {
            System.out.println("There is no repeating character");
        }
    }

    /*
     * Using LinkedHashMap, In this solution we need iterate the hashMap again to find the count
     * of the character whose count is 1.
     *
     * Time COmplexity Order of 1
     *
     * Another approach : https://www.youtube.com/watch?v=U7rxgP-fp8E
     *
     * Another approach is taking two loop. Naive solution or brute force soulution
     *
     */

    public static Integer getFirstNonRepeatingCharacter(String inputString) {
        int[] array = new int[26];

        for(int i = 0; i<inputString.length(); i++) {
            int x = 'a'; // Ascii code 97
            System.out.println(x);
            array[inputString.charAt(i) - 'a'] = array[inputString.charAt(i) - 'a'] + 1;
        }


        for(int i = 0; i < inputString.length(); i++){
            if(array[inputString.charAt(i) - 97] == 1){
                return i;
            }
        }
        return -1;
    }


}
