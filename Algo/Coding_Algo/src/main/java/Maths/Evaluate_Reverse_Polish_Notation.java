package Maths;

import org.junit.Test;

import java.util.Stack;

/*

https://www.youtube.com/watch?v=jos1Flt21is

https://www.youtube.com/watch?v=MeRb_1bddWg

https://www.youtube.com/watch?v=MeRb_1bddWg


Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9


Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

 */
//https://leetcode.com/problems/evaluate-reverse-polish-notation/

public class Evaluate_Reverse_Polish_Notation {


  @Test
  public void testReverseEval() {
  // ["2", "1", "+", "3", "*"]


    String str [] = {"2", "1", "+", "3", "*"};
    int result = evalRPN(str);
    System.out.println("result ==>"+ result);
//    String strOne [] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//    int resultTwo = evalRPN(strOne);
//    System.out.println("resultTwo ==>"+ resultTwo);

  }

  // Will Take Stack
  public int evalRPN(String[] tokens) {
        /*
            Time Complexity : O(n) iterate complete array
            Space complexity : O(d)
        */

    if(tokens == null || tokens.length == 0) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();

// To convert String to Integer. Use Intger.parseInt(str) == > Will give you integer value
    for (String token : tokens) {
      if(token.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if(token.equals("-")) {
        // In post fix p -q => pq- => When we push in stack first p goes and then q goes
        // When we pop first q attached minus with it
        // And then attached +
        // And then popped p
        // IT will become ad -q + p.
        stack.push(-stack.pop() + stack.pop());
      } else if(token.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if(token.equals("/")) {
        // In postfix implementation p/q ==> p/q/ ==> In Stack first p goes anf then q goes
        int n1 = stack.pop(); // this is q
        int n2 = stack.pop(); // this is p
        // p/q ==> n2/n1
        stack.push(n2 / n1);
      } else {
        int number = Integer.parseInt(token);
        stack.push(number);
      }
    }


    return  stack.pop();
  }
}
