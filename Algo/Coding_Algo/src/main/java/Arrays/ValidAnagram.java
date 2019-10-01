package Arrays;

/**
 * https://www.youtube.com/watch?v=ikO4qKG_IWc&t=2s
 *
 * https://www.youtube.com/watch?v=3MwRGPPB4tw
 */
public class ValidAnagram {

  public static void main(String args[]) {
     /*
      https://leetcode.com/problems/valid-anagram/

        Algo :
        1. Take the array of size 26. As each String can have a character from a to z. It's lower case
        int inputArray [] = new int [s.length()];


        2. We know ascii code for a is 97 and ascii code for z is 122.
        3. Find ascii code of each character.
        4. Iterate each String S. Increment the counter for each character in S.
        5. Iterate each String T. Decrement the counter for each character in T.

        6. If it is anagram then inputArray value for index should be 0 for each value
        else it is return false;


        Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

        */

    System.out.println(isAnagram("anagram", "nagaram"));
  }

  public static boolean isAnagram(String s, String t) {
    int [] charCount = new int[26]; // By default it will initalize as 0

    for (int i = 0; i <s.length(); i++) {
      charCount[s.charAt(i) - 'a']++; // Array value increment by 1
    }

    for (int i = 0; i <t.length(); i++) {
      charCount[t.charAt(i) - 'a']--; // Array value decrement by 1
    }

    for (int i = 0; i <charCount.length; i++) {
      if(charCount[i] > 0) { // Check if
        return false;
      }

    }
    return true;
  }



  public boolean isAnagram_More_Explaination(String s, String t) {
        /* More Explaination

        Algo :
        1. Take the array of size 26. As each String can have a character from a to z. It's lower case
        int inputArray [] = new int [s.length()];


        2. We know ascii code for a is 97 and ascii code for z is 122.
        3. Find ascii code of each character.
        4. Iterate each String S. Increment the counter for each character in S.
        5. Iterate each String T. Decrement the counter for each character in T.

        6. If it is anagram then inputArray value for index should be 0 for each value
        else it is return false;

        */

    int result [] = new int [26];

    // Increment each index value for String S
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int index = c - 'a';
      result[index]++;
    }

    // Decrement each index value for String T
    for(int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      int index = c - 'a';
      result[index]--;
    }

    for (int number : result) {
      if(number != 0) {
        return false;
      }
    }
    return true;
  }
}
