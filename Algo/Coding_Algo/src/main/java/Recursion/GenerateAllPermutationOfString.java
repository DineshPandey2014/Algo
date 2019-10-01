package Recursion;

/**
 * Geeta class video. Best video
 * Algoexpert video to get all permutation.
 */

/*
   https://www.youtube.com/watch?v=IPWmrjE1_MU

 *  Write a function that takes in an array of unique integers and returns an array an array of all
 *  permutations of those integers. If the input is empty your function should returns an empty array.
 *
 *  Sample Input: [1,2,3]
 *  Sample OutPut: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,2,1], [3,1,2]
 *
 *  Time Complexity : O(!n * n)
 *  Space Complexity: It holds the !n permutations and each element is length of n
 *                    O(!n * n)
 *
 */
public class GenerateAllPermutationOfString {

  public static void main(String args[]) {

    String s = "123";
    computePermute(s.toCharArray(), 0);
  }

  static void computePermute(char[] input, int start) {
    // Exit condition of permutation
    if (start == input.length - 1) {
      System.out.println(String.valueOf(input));
    } else {
      for (int i = start; i < input.length; i++) {
        swap(input, start, i);
        computePermute(input, start + 1);
        swap(input, start, i);

      }
    }
  }

    public static void swap ( char[] input, int i, int j){
      char temp = input[i];
      input[i] = input[j];
      input[j] = temp;
    }


}