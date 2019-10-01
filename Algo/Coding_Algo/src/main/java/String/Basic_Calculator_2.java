package String;

import org.junit.Test;

import java.util.Stack;

public class Basic_Calculator_2 {

  @Test
  public void testCalculate() {
    //int result = calculate(" 3/2 ");

    int result = calculate("23+2*2");
    System.out.println(result);
  }

  public int calculate(String s) {
    char sign = '+';
    int result = 0;
    int num = 0;
    Stack<Integer> stack = new Stack(); // It will hold the numer as like : 2, -1, +4 and so on

    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == ' ') {
        continue;
      }
      if(Character.isDigit(s.charAt(i))) {
        num = s.charAt(i) - '0'; // To get the inter value subtract the Ascii code of '0'
        while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
          num = num * 10 + s.charAt(i+1) - '0';
          i++;
        }
      }

        if(!Character.isDigit(s.charAt(i)) || s.charAt(i) != ' ' || i <= s.length()-1) {
        if(sign == '+') {
          stack.push(num);
        } else if(sign == '-') {
          stack.push(-num);
        } else if(sign == '*') {
          stack.push(stack.pop() * num);
        } else if (sign == '/') {
          stack.push(stack.pop() / num);
        }
        sign = s.charAt(i);
        num = 0;
      }
    }

    while(!stack.isEmpty()) {
      result = result + stack.pop();
    }

    return result;
  }


//  public int calculate(String s) {
//    int len;
//    if(s==null || (len = s.length())==0) return 0;
//    Stack<Integer> stack = new Stack<Integer>();
//    int num = 0;
//    char sign = '+';
//    for(int i=0;i<len;i++){
//      if(Character.isDigit(s.charAt(i))){
//        num = num*10+s.charAt(i)-'0';
//      }
//      if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
//        if(sign=='-'){
//          stack.push(-num);
//        }
//        if(sign=='+'){
//          stack.push(num);
//        }
//        if(sign=='*'){
//          stack.push(stack.pop()*num);
//        }
//        if(sign=='/'){
//          stack.push(stack.pop()/num);
//        }
//        sign = s.charAt(i);
//        num = 0;
//      }
//    }
//
//    int re = 0;
//    for(int i:stack){
//      re += i;
//    }
//    return re;
//  }
}
