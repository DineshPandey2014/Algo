package String;

import org.junit.Test;

/*
https://leetcode.com/problems/string-compression/

Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 */
public class StringCompression {

  int slowIndex = 0;
  int fastIndex = 1;
  int count = 0;
  char slowChar = ' ';

  @Test
  public void testStringCompression() {
    char c [] = {'a','a','b','b','c','c','c'};

    int result = compress(c);
    System.out.println(result);
  }

  public int compress(char[] chars) {

    while(fastIndex < chars.length) {
      count++;
      slowChar = chars[slowIndex];
      char fastChar = chars[fastIndex];
      if(slowChar == fastChar) {
        count++;
        fastIndex++;
      } else {

        chars[slowIndex+1] = '1';
        count = 0;
        //slowChar = chars[fastIndex];
        slowIndex = fastIndex;
        fastIndex++;
      }

    }
    chars[slowIndex + 1] = '1';
    return slowIndex+1;
  }
}
