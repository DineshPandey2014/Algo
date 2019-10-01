package Arrays;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.

 Time Complexity : We need to iterate each String in the array. Then each String of length K need
 to sort time complexity to sort one String is K (logK)

 Total Time Complexity: O( NK(log K))
 Space Complexity : O(NK)

 */

import java.util.*;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList();
    if(strs == null || strs.length == 0) {
      return result;
    }

    Map<String, List<String>> anagramMap = new HashMap<>();

    for(int i = 0; i < strs.length; i++) {
      String sortedString = sort(strs[i]);
      if(anagramMap.containsKey(sortedString)) {
        List<String> out = anagramMap.get(sortedString);
        out.add(strs[i]);
      } else {
        List<String> list = new ArrayList();
        list.add(strs[i]);
        anagramMap.put(sortedString, list);
      }
    }

    for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
      result.add(entry.getValue());
    }

    return result;
  }

  private String sort(String input) {
    char inputCharacter [] = input.toCharArray();
    Arrays.sort(inputCharacter);
    //Arrays.sort(inputCharacter);
    return new String(inputCharacter);
  }
}
