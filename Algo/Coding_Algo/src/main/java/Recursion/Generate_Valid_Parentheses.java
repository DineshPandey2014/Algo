package Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=pD2VNU2x8w8
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 s
 * https://leetcode.com/problems/generate-parentheses/
 *
 *
 */
public class Generate_Valid_Parentheses {

  @Test
  public void generateParenthese() {
    List<String> output = generateParenthesis(3);
    System.out.println(output);
  }

  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList();

    // Note here we will start from index 0;
    getAllParenthesis(list, "", 0, 0, n);
    return list;
  }

  public void getAllParenthesis(List<String> output, String cur, int open, int close, int n) {

    // open is the count of left parenthesis
    // close is the count of right parenthesis
    // n is the count
    if(open == n && close == n) {
      output.add(cur);
      return;
    }
      // 0,1,2 --> after concating index 2, open count becomes 3. And then we need to print the output.
      if(open < n) {
        getAllParenthesis(output, cur+"(", open +1, close, n);
      }

      //
      if(close < open) {
        getAllParenthesis(output, cur+")", open, close + 1, n);
      }

  }
}
