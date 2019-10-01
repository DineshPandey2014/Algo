package String;

import java.util.Stack;

/**
 * Leet Code 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 Example 1:

 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"
 Example 2:

 Input: ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()"

 */
public class LongestValidParentheses {

  public static void main(String args[]) {
    int lengthLongest = longestValidParentheses("())");
    System.out.println(lengthLongest);
  }

  public static int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack();
    char leftBrace = '(';
    int result = 0;

    /*
     * Here we will push the first index as -1.
     * Idea of pushing is when we have pattern () ---> First we push ( and then we pop ) ---> And then calculate
     * the max length by using by using Math.max(result, i - stack.peek())
     *
     * Check if stack is empty when for incoming bracket we will push it's index here it is 2
     */
    stack.push(-1);

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c == leftBrace) {
        stack.push(i);
      } else {
        // Pop the previous element
        stack.pop();
        if(!stack.empty()) {
          result = Math.max(result, i - stack.peek());
        } else {
          stack.push(i);
        }
      }
    }
    return result;
  }
}
