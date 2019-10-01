package String;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubstring_Leetcode {
  public static void main (String args[]) {

    String s = "Helloworld";
    String t = "wrl";
    String minWindow = minWindow(s, t);
    System.out.println(minWindow);
  }

  public static String minWindow(String s, String t) {

    Map<Character, Integer> map = new HashMap();

    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, 0);
    }

    for(char temp : t.toCharArray()) {
        if(map.containsKey(temp)) {
          map.put(temp, map.get(temp) + 1);
        }
          else {
            return "";
          }
        }

        int start = 0;
         int end = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int numberOfTargets = t.length();

        while(end < s.length()) {
          char current = s.charAt(end);
            if(map.get(current) > 0) {
              numberOfTargets--;
            }
            map.put(current, map.get(current)-1);


          while(numberOfTargets == 0) {
              if(minLength > end -start +1) {
                minLength = end -start +1;
                minStart = start;
              }
              char startChar = s.charAt(start);
              if(map.get(startChar) >=0 ) {
                numberOfTargets++;
              }
                map.put(startChar, map.get(startChar)+1);
                start++;

          }
          end++;
        }
          return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }


}

