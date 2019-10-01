package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

  public static void main(String args[]) {
    String str = "()";
    System.out.println(isValid(str));
  }

  /**
   * Better of way doing
   */
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack();
    for (char c : s.toCharArray()) { // [
      if(c == '(') {
        stack.push(')');
      } else if(c == '{') {
        stack.push('}');
      } else if(c == '[') {
        stack.push(']');
      } else if(stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty() == true ? true: false;
  }
  /*
  public static boolean isValid(String s) {

    if(s == null) {
      return false;
    }

    if(s.length() == 0) {
      return true;
    }

    Map<Character,Character> map = new HashMap();
    Stack<Character> stack = new Stack();

    map.put('{', '}');
    map.put('[', ']');
    map.put('(', ')');

    // String ()
    for (int i = 0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(map.get(c) != null) {
        stack.push(c);
      } else {
        if(!stack.isEmpty()) {
          char stackShar = stack.pop();
          char x = map.get(stackShar);
          if(x != c) {
            return false;
          }
        } else {
          return true;
        }
      }
    }
    return stack.isEmpty();
  }*/
}
