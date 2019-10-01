package String;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

 */
public class Find_Unique_Character_In_String {

  /*
   Algo 1: Linear time solution.
   Time Complexity is O(N) ==> We need to iterate entire Stringa and then put the count in the hash map
   Space Complexity is (N) => If entire String have single character then the count of each character       is 1. Space will be equal to N.

   Approach :
   1. Take hash map. Key as character and value as count of each character. After iterating the
      String each time.
   2. Iterate the String second time. Find the char whose value is 1
   4. Return the index of the character if foind else return -1.

   */
  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(!map.containsKey(c)) {
        map.put(c, 1);
      } else {
        map.put(c, map.get(c) + 1);
      }
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(map.get(c) == 1) {
        return i;
      }
    }
    return -1;
  }
}
