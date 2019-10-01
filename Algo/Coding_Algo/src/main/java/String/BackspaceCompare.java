package String;

import java.util.Stack;

public class BackspaceCompare {

  public static void main (String args[]) {
    System.out.println(backspaceCompare("aaaa#", "aaa"));
  }

  public static boolean backspaceCompare(String S, String T) {
    if(S == null || T == null) {
      return false;
    }
    return build(S).equals(build(T));
  }

  public static String build(String S) {
    Stack<Character> stackS = new Stack();
    for(char cs : S.toCharArray()) {
      if(cs != '#') {
        stackS.push(cs);
      } else if(!stackS.isEmpty()){
        stackS.pop();
      }
    }
    return String.valueOf(stackS);
  }
}
