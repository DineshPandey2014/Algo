package String;

/**
 * https://www.youtube.com/watch?v=WCaigw6Bz1M
 * http://hackercs.com/videos/The-Tree-Abstract-Data-Type-ADT--Part-1/
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 */

import org.junit.Test;

/**
 * A word is defined as a sequence of non-space characters.
   The input string does not contain leading or trailing spaces.
  The words are always separated by a single space.
 "wordOne wordTwo" ---> "wordTwo wordOne"

 Note if String is given. Create an array of character. So that we can do in place algorithm

 */
public class ReverseOrderingOfWord {
    public void reverseWords(char[] str) {
        int startIndex = 0;
        int lastIndex = str.length -1;
        reverseString(startIndex, lastIndex, str);
        int j = 0;
        for(int i = 0; i < str.length; i++) {
            char temp = str[i];
            if(temp == ' ') {
                reverseString(j , i -1, str);
                j = i +1;
            }
        }
        // Corner Case when you cross the array for last word you will not find the char ' '
        reverseString(j, lastIndex, str);

    }

    // First reverse the String
    public void reverseString(int startIndex, int endIndex, char [ ] characterArray) {
        while(startIndex < endIndex) {
            char temp = characterArray[startIndex];
            characterArray[startIndex] = characterArray[endIndex];
            characterArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

}