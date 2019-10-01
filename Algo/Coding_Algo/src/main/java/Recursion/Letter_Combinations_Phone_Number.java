package Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 *
 * https://www.youtube.com/watch?v=6tRoYAHSNsA
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 Example:

 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:

 Although the above answer is in lexicographical order, your answer could be in any order you want.


 */
public class Letter_Combinations_Phone_Number {

  @Test
  public void testCombination() {
      char c ="abc".charAt(0);
      int x = '0';
      int y = c;
      int z = 'a' - '0';


//    System.out.println(c);
//    System.out.println(x);
//    System.out.println(z);

    List<String> poutput = letterCombinations("23");
  }


  // Number 1 and 0 there are no characters. So for  these position we don't have to mapped any thing

  private String inputPhoneMapper [] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList();
    helper(digits, 0, "", result);
    return result;
  }


  public void  helper(String digits, int index, String combination,  List<String> result) {
    if( digits.length() == index) {
      result.add(combination);
      return ;
    }



    // Example char '2' --> Ascii code will 50
    //         char '0' --> Ascii code will 48
    // Difference index = 50 - 48 = 2;
    String letters = inputPhoneMapper[digits.charAt(index) - '0'];
    for(char letter : letters.toCharArray()) {
      helper(digits, index + 1, combination + letter, result);
    }
  }
}