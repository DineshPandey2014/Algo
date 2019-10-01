package String;

import org.junit.Test;

import java.util.Stack;

public class Calculator {

  @Test
  public void testCalculator() {
    String  input = "22+3-4+(5-9)";
    int result = calculate(input);
  }
  public int calculate(String s) {
    int len = s.length(), sign = 1, result = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < len; i++) {
      if (Character.isDigit(s.charAt(i))) {
        int sum = s.charAt(i) - '0';
        while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
          sum = sum * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        result += sum * sign;
      } else if (s.charAt(i) == '+')
        sign = 1;
      else if (s.charAt(i) == '-')
        sign = -1;
      else if (s.charAt(i) == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else if (s.charAt(i) == ')') {
        result = result * stack.pop() + stack.pop();
      }

    }
    return result;
  }


    @Test
  public void testInputString() {
    //String  input = "22+3-4+5-9";
    String  input = "22-3-4";
    int result = calculatorUsingSimpleStringInput(input);
    System.out.println(result);
  }

  public int calculatorUsingSimpleStringInput(String strInput) {
    int sign = 1;
    int result = 0;

    for(int i = 0; i < strInput.length(); i++) {
      if(Character.isDigit(strInput.charAt(i))) {
        int number = strInput.charAt(i) - '0';
        while(i + 1 < strInput.length() && Character.isDigit(strInput.charAt(i + 1))) {
          number = number * 10 + strInput.charAt(i+1) - '0';
          i++;
        }
        result = result + number * sign;
      } else if(strInput.charAt(i) == '+') {
        sign = 1;
      } else if(strInput.charAt(i) == '-') {
        sign = -1;
      }
    }
    return result;
  }



//  @Test
//  public void testInputString() {
//    //String  input = "22+3-4+5-9";
//    String  input = "22-3-4";
//    int result = calculatorUsingSimpleStringInput(input);
//    System.out.println(result);
//  }

//  public int calculatorUsingSimpleStringInput(String strInput) {
//    String curr = strInput;
//    Stack<Integer> numbers = new Stack();
//    Stack<Character> character = new Stack();
//    while (!strInput.isEmpty()) {
//      int indexOfPlus = strInput.indexOf("+");
//      int indexOfMinus = 0;
//      if(indexOfPlus == -1) {
//        indexOfMinus = strInput.indexOf("-");
//      }
//
//      if(indexOfPlus != -1) {
//        curr = strInput.substring(0, indexOfPlus);
//        int number = Integer.valueOf(curr);
//        numbers.push(number);
//        char c = strInput.charAt(indexOfPlus);
//        character.push(c);
//        strInput = strInput.substring(indexOfPlus + 1);
//      } else if(indexOfMinus != -1) {
//        curr = strInput.substring(0, indexOfMinus);
//        int number = Integer.valueOf(curr);
//        numbers.push(number);
//        char c = strInput.charAt(indexOfMinus);
//        character.push(c);
//        strInput = strInput.substring(indexOfMinus + 1);
//      } else if(indexOfPlus == -1 && indexOfMinus == -1) {
//        curr = strInput.substring(0, 1);
//        int number = Integer.valueOf(curr);
//        numbers.push(number);
//        strInput = "";
//      }
//
//    }
//
//    int total = 0;
//    while(!character.isEmpty()) {
//      char c = character.pop();
//      if(c == '+') {
//        total = numbers.pop() + numbers.pop();
//        numbers.push(total);
//        total = 0;
//      } else if(c == '-') {
//        total = total + numbers.pop() - numbers.pop();
//        numbers.push(total);
//        total = 0;
//      }
//    }
//
//    return numbers.pop();
//
//  }


}
