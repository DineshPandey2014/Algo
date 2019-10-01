package SlidingWindow;


import java.util.HashMap;
import java.util.Map;

/*
   https://leetcode.com/problems/minimum-window-substring/

   Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.



 */
public class Minimum_Window_SubString {

  public static  String  minWindow(String s, String t) {

    /**
     * Length of the String that's need to be matched.
     */
    int count = t.length();

    int start = 0;
    int end = 0;
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int strLength = Integer.MAX_VALUE;


    /*
     * Populate the map with all the characters that needs to match with String.
     * Key will be Charcter
     * Value will be count. Same character cab be matched multiple times
     */

    // Populate the map with all the charaters count for the String that needs to be matched
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if(!map.containsKey(c)) {
        map.put(c, 1);
      } else {
        map.put(c, map.get(c) + 1);
      }
    }


    /*
     * First move right pointer to expand the window.
     *
     * Loop the input String till you have all the matching characters of String s.
     * If input character from S matched with the Character of T which is in map. Decrement the counter.
     * If Counter is 0. It means that this is one of the substring which have all the characters of T.
     * It might be shortest or longest we need to store the start, and end param for length.
     *
     * Now once the Counter is zero. We need another inner loop to remove the character which are not needed. Or shrink the window till the count is zero.
     *
     */
    while(end < s.length()) {
      char rightChar = s.charAt(end);
      if(map.containsKey(rightChar)) {
        // Here we are decrementing the matching character value.
        if(map.get(rightChar) > 0) {
          count--;
        }
        // Once the character length is 0 it will become -1 and it means we matched all the counts
        // Character. And the current window we have more characters then which is needed.
        map.put(rightChar, map.get(rightChar) - 1);
      }
      end++;

      // When count is zero. It means we find the substring which contains all the characters of matching
      // String, Which might not be minimum substring. Now we will shrink the window.
      while(count == 0) {
        if(strLength > end - start) {
          left = start;
          right = end;
          strLength = end - start;
        }
        char leftChar = s.charAt(start);

        /*
          Here we will try to shrink the window.
          Moving left pointer and see if the map contains the character increment the count in the map
          and see if it the count is still negative and not greater the zero. It meanes we can shrink    the window from left and we will not increment the count. Which will remain zero 0.
        */
        if(map.containsKey(leftChar)) {
          map.put(leftChar, map.get(leftChar) + 1);
          // When count is 1 means our current String is not having all the characters and one character
          // is missing. Now this while loop breaks and it will go to outer while. And then we
          // Expand window from right.
          if(map.get(leftChar) > 0) {
            count++;
          }
        }
        start++;
      }

    }

    // Here at last we can check if the length of the SubString is Integer.Max_Value. It means we didn't find the
    // MAtching String, Will return empty String else we will return s.subString(left, right);
    return strLength == Integer.MAX_VALUE ? "" : s.substring(left, right);
  }
}
