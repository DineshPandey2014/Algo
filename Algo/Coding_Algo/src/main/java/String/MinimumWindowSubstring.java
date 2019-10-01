package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

  public static void main (String args[]) {

    String s = "cabwefgewcwaefgcf";
    String t = "cae";
    String minWindow = minWindowString(s, t);
    System.out.println(minWindow);
  }

  public static  String  minWindowString(String s, String t) {

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
     * Now once the Counter is zero. We need another inner loop to remove the character which are not needed. Or shrink
     * the window till the count is zero.
     *
     */
    while(end < s.length()) {
      char rightChar = s.charAt(end);
      if(map.containsKey(rightChar)) {
        if(map.get(rightChar) > 0) {
          count--;
        }
        map.put(rightChar, map.get(rightChar) - 1);
      }
      end++;
      while(count == 0) {
        if(strLength > end - start) {
          left = start;
          right = end;
          strLength = end - start;
        }
        char leftChar = s.charAt(start);
        if(map.containsKey(leftChar)) {
          map.put(leftChar, map.get(leftChar) + 1);
          if(map.get(leftChar) > 0) {
            count++;
          }
        }
        start++;
      }

    }



    return strLength == Integer.MAX_VALUE ? "" : s.substring(left, right);
  }


  public static  int minWindow(String s, String t) {
    int count = 0;
    int length = s.length();
    int end = 0;
    int start = 0;
    int minimumWindow = Integer.MAX_VALUE;

    Map<Character, Integer> map = new HashMap();

    Set<Character> set = new HashSet();
    int j = 0;


    while(j < t.length()) {
      set.add(t.charAt(j));
      j++;
    }

    while (end < length) {
      char c = s.charAt(end);

      if (set.contains(c)) {
        if (!map.containsKey(c)) {
          map.put(c, 1);
        } else {
          map.put(c, map.get(c) + 1);
        }
      }

      if (map.size() == t.length()) {
        minimumWindow = Math.min(minimumWindow, end - start + 1);
        char c_start = s.charAt(start);
        if (map.containsKey(c_start)) {
          int x = map.get(c_start);
          if (x == 1) {
            map.remove(c_start);
          } else {
            map.put(c_start, map.get(c_start) - 1);
          }
        }
        start++;
      } else {
        end++;
      }

    }

   return minimumWindow;
    }




}
