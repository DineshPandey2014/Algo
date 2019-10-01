package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  //abcaabbd
  public static void main(String args[]) {
    int x = lengthOfLongestSubstring("abcb");
    System.out.println("Length of longest substring"+x);

  }

  /**
   * It's two pointer approach. With i and j as two pointer.
   * J is fast pointer and i is slow pointer.
   *
   * Here if there is duplicate found at J. It will not add that character to Set.
   * Will increment i by one. And remove the character from Set.
   * Till Set is empty. And then add Jth chcaracter again.
   *
   *  The idea is use a hash set to track the longest substring without repeating characters so far,
   *  use a fast pointer j to see if character j is in the hash set or not, if not, great,
   *  add it to the hash set, move j forward and update the max length, otherwise, delete from
   *  the head by using a slow pointer i until we can put character j to the hash set.
   *
   * https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet
   *
   * @param s
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {

    int i = 0;
    int j = 0;
    int maxLength = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    Set<Character> set = new HashSet<>();
    // abcaabbd
    while (j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        j++;
         if(Math.max(maxLength, j - i) > maxLength) {
           leftIndex = i;
           rightIndex = j;
           maxLength = j -i;
         }

      } else {
        System.out.println("Removing character at i  -->"+s.charAt(i));
        set.remove(s.charAt(i));
        i++;
      }
    }
    System.out.println("---i---"+i);
    System.out.println("---j---"+j);
    System.out.println("Longest Substring--->" +s.substring(leftIndex, rightIndex));
    return maxLength;
  }


}