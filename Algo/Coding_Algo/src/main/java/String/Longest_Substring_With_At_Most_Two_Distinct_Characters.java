package String;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_With_At_Most_Two_Distinct_Characters {

  public static void main(String args[]) {
        int longestString =   getLongestSubstringLengthExactly2DistinctChars("eceba"); // 2
        System.out.println(longestString);

  }

  static int getLongestSubstringLengthExactly2DistinctChars(String s) {

    char arrayc [] = s.toCharArray();
    if (s == null || s.length() < 2) {
      return 0;
    }

    int start = 0;
    int end = 0;
    int max = 0;
    int index = 0;

    int whereCharacteChanges = 0;
    char temp = ' ';
    Set<Character> set = new HashSet();
    // ababababa
    while(end < s.length()) {
      char first = arrayc[end]; //s.charAt(end);

      if(temp != first && set.size() != 2) {
        whereCharacteChanges = end;
      }

      temp = first;


      if(!set.contains(first)) {
        set.add(first);
      }

      if(set.size() > 2) {
        max = Math.max(max, end - start);
        start = whereCharacteChanges;
        end  = start;
        set = new HashSet();
        end--;
      }

      end++;
    }

    if(set.size() == 2)  {
      max=Math.max(max, end - start);
    }

    return max;
  }

}
