package Sorting.HomeWork.SortingOne.Iterative;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class IsPlaindrome {

    /*
    @Test
    void testPlaindromeOne() {
        String str ="";
        assertTrue(isPlaindrome(str));
    }

    @Test
    void testPlaindromeTwo() {
        String str ="abc";
        assertTrue(isPlaindrome(str));
    }

    @Test
    void testPlaindromeThree() {
        String str ="aba";
        assertEquals(isPlaindrome(str), true);
    }*/

    public static void main(String args[]) {
        String str ="aba";
        Set<String> set = new HashSet<>();
        findAllDecomposedPlaindrome(str, "", set);

        String array [] = set.toArray(new String[set.size()]);

        for(String strOut : array) {
            System.out.println(strOut);
        }

    }

    static void findAllDecomposedPlaindrome(String input, String plainStr, Set<String> set) {

        if(input.length() == 0) {
            if(isPlaindrome(plainStr)) {
                set.add(plainStr.concat("|"));
            }
            return;
        }


        findAllDecomposedPlaindrome(input.substring(1), plainStr, set);
        findAllDecomposedPlaindrome(input.substring(1), plainStr + input.charAt(0), set);

    }



    static boolean isPlaindrome(String str) {

        int i = 0;
        int j = str.length() -1;

        while(i<=j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }

        }
        return true;
    }
}
