package String.KMP;

import java.util.ArrayList;
import java.util.List;

/**
 * KMP
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 *
 * Time complexity for brute force
 * m = Length of text
 * n = Length of pattern to be matched
 *
 * Time complexity brute force O(mn)
 *
 * Assume that n = length of haystack and m = length of needle, then the runtime
   complexity is O(nm).

 Have you considered these scenarios?
 i. needle or haystack is empty. If needle is empty, always return 0. If haystack is
 empty, then there will always be no match (return –1) unless needle is also
 empty which 0 is returned.
 ii. needle’s length is greater than haystack’s length. Should always return –1.
 iii. needle is located at the end of haystack. For example, “aaaba” and “ba”. Catch
 possible off-by-one errors.
 iv. needle occur multiple times in haystack. For example, “mississippi” and
 “issi”. It should return index 2 as the first match of “issi”.
 v. Imagine two very long strings of equal lengths = n, haystack = “aaa…aa” and
 needle = “aaa…ab”. You should not do more than n character comparisons, or
 else your code will get Time Limit Exceeded in OJ
 */

public class PatternSearchUsingKMP {

  public static void main(String args[]) {

    String input = "abxabcabcaby";
    String pattern = "abcab";

    getAllMatchingIndex("abxabcabcabydefabcaby", "abcaby") ;
  }


  private static void getAllMatchingIndex(String str, String pattern) {
    int i = 0;
    int j = 0;

    int k = 0;
    char charArray [] = str.toCharArray();
    char patternArray [] = pattern.toCharArray();

    int [] prefixArray = getPrefixKMPArray(pattern);

    List<Integer> matchingIndex = new ArrayList();

    while (i < charArray.length) {

      if(charArray[i] == patternArray[j]) {
        if(j == pattern.length()-1) {
          matchingIndex.add(i-j+1);
          i++;
          j = 0;
        } else {
          j++;
          i++;
        }

      } else {
        if(j!=0) {
          j = prefixArray[j-1];
        } else {
          i++;
        }

      }
    }

    for(Integer input : matchingIndex) {
      System.out.println(input);
    }
  }

  private static int[]  getPrefixKMPArray(String pattern) {
    char arrayPat [] = pattern.toCharArray();

    int patternArr [] = new int[pattern.length()];

    patternArr[0] = 0;

    int  i = 1;
    int  j = 0;

    while (i < pattern.length()) {
      if(arrayPat[i] == arrayPat[j]) {
        patternArr[i] = j + 1;
        i++;
        j++;
      } else {
        if(j != 0) {
          j = patternArr[j - 1];
        }
        if(j == 0) {
          patternArr[i] = 0;
          i++;
        }
      }
    }
    return patternArr;
  }
}
