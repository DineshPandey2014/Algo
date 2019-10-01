package Recursion;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Understand the Set and combination
 * https://www.youtube.com/watch?v=aqTGvDZorW4
 *
 * Good Video
 * https://www.youtube.com/watch?v=KCEPvdLqlYI
 *
 * https://www.youtube.com/watch?v=pD2VNU2x8w8&t=27s
 *
 * https://www.youtube.com/watch?v=EJwCUCjb9HM
 * Number of combination is : 2 * n (Each element can be there or not there)
 *
 *
 *
 * Subsequence

 A subsequence is a sequence that can be derived from another sequence by zero or more elements,
 without changing the order of the remaining elements.

 For the same example, there are 15 sub-sequences.
 They are (1), (2), (3), (4), (1,2), (1,3),(1,4), (2,3), (2,4), (3,4), (1,2,3), (1,2,4), (1,3,4), (2,3,4), (1,2,3,4).
 More generally, we can say that for a sequence of size n, we can have (2n-1) non-empty sub-sequences in total.

 A string example to differentiate: Consider strings “geeksforgeeks” and “gks”. “gks” is a subsequence of
 “geeksforgeeks” but not a substring. “geeks” is both a subsequence and subarray. Every subarray is a subsequence.
 More specifically, Subsequence is a generalization of substring.

 Substring: is a continous String geek, ge, g, eek, ek, k
 */

public class AllSubsequence_UsingRecursion {

    public static void main(String args[]) {
        String input = "123";

        List<String> outputList = new ArrayList();

        String output = "";
        generateAllSubSequenceOfString_WithSubString(input,output);
       // generateAllSubSequenceOfString_Without_Substring(input,output, 0);
    }



    static void generateAllSubSequenceOfString_WithSubString(String input, String output) {

        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        // Logic:  // Each character either will be selected or not selected.


        // Input String will get reduce by one character in each step.
        // We will do substring by index 1.
        // First branch Chracter is not selected in the output. As such there is no change.
        if(input.length() >=1) {
            generateAllSubSequenceOfString_WithSubString(input.substring(1), output);
        }

        // In Second branch in the output first character is selected.
        if(input.length() >=1) {
            generateAllSubSequenceOfString_WithSubString(input.substring(1), output + input.charAt(0));
        }
    }


    static void generateAllSubSequenceOfString_Without_Substring(String input, String output, int index) {

        if(input.length() == index) {
            System.out.println(output);
            //outputList.add(output);
            return;
        }
        // Logic:  // Each character either will be selected or not selected.


        // Input String will get reduce by one character in each step.
        // We will do substring by index 1.
        // First branch Chracter is not selected in the output. As such there is no change.
        if(input.length() >=1) {
            generateAllSubSequenceOfString_Without_Substring(input, output, index +1);
        }

        // In Second branch in the output first character is selected.
        if(input.length() >=1) {
            generateAllSubSequenceOfString_Without_Substring(input, output + input.charAt(index), index +1);
        }
    }

    @Test
    public void test() {
        int x [] = {1,2,3};
       List<Integer> output = (List) Arrays.asList(x);
    }

}

/*
3
2
23
1
13
12
123
 */