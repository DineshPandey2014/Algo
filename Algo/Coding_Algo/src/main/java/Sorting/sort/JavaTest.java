package Sorting.sort;

import org.junit.jupiter.api.Test;

import java.util.*;

public class JavaTest {

    public static void main(String args[]) {

        if (4 <= 2) {
            System.out.println("111");
        } else if(4<=-4) {
            System.out.println("2222");
        } else {
            System.out.println("3333");
        }

    }

    @Test
    public void testInput() {
        String arr [] = {"key1 abcd", "key2 zzz", "key1 hello", "key3 world", "key1 hello"};

        Arrays.sort(arr);

        if("key1 cdcd".compareTo("key1 cbcd") > 0) {  // Greater then
            System.out.println("Yes");
        }




    }

    @Test
    public void dutch_flag_sort() {
        /*
         * Write your code here.
         */
        String s = "GBGGRBRG";
        char [] x = s.toCharArray();
        Arrays.sort(x);
        String sortedString = new String(x);
        StringBuilder str = new StringBuilder(sortedString).reverse();
        String strOne = str.toString();

        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("22");
        set.remove("22");
    }


    public int[] merger_first_into_second(int[] arr1, int[] arr2) {

        int j = arr2.length-1;

        int k = arr1.length -1;

        int i = arr1.length-1;

        while(i >= 0) {
            if(arr1[i] >= arr2[k]) {
                arr2[j] = arr1[i];
                i--;
                j--;
            } else {
                arr2[j] = arr2[k];
                j--;
                k--;
            }

        }
        // Copy the rest element
        if(i>=0) {
            while(i >= 0) {
                arr2[k] = arr1[i];
                k--;
                i--;
            }
        }

        return arr2;

    }


}
