package Misc.String;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpandey on 11/6/17.
 *
 * Question that canbe asked to Interviewer
 *
 * 1) All caps or lower case
 * 2) All Alphanumeric (a-z, A-Z, 0-9)
 * 3) Other characters are allowed
 */
public class Longest_Substring_Without_Repeating_Characters {

    @Test
    public void testLongestSubstring() {
        int longestSubString_Without_Repeating_Characters = lengthOfLongestSubstring("abcad");
        System.out.println(longestSubString_Without_Repeating_Characters);
    }

    public int lengthOfLongestSubstring(String s) {
        /*
         * Taking two pointer one is slow and one is fast.
         * say i is slow means it will increment only when we found duplicate char in the string
         *
         */
        int i = 0;
        int  j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while(j<s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}
