package Misc.String;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by dpandey on 11/2/17.
 */
public class MatchingParenthesis {

    public static void main(String args[]) {
        System.out.println("------"+isValid("{{)}"));
        System.out.println("------"+isValid("]()"));
        System.out.println("------"+isValid("()["));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else  if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }

        }
        return stack.isEmpty();
    }
}
