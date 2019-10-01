package String;

/**
 * Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace
 character is found. Then, starting from this character, takes an optional initial plus or minus sign
 followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are
 ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no
 such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.


 */
public class String_To_Integer {
  public int myAtoi(String str) {

    int start = 0;
    int sign = 1;
    int length = str.length();
    char temp = str.charAt(start);
    long sum = 0;

    if(str == null || str.isEmpty() || str.equals("")) {
      return 0;
    }

    while(str.charAt(start) == ' ') {
      start++;
    }


    if(str.charAt(start) == '+') {
      sign = 1;
    } else if(str.charAt(start) == '-') {
      sign = -1;
    } else if(Character.isDigit(str.charAt(start))) {
       long number = str.charAt(start) - '0';

       while(start+1 < str.length() && Character.isDigit(str.charAt(start+1))) {
        number = number * 10 + str.charAt(start+1) - '0';
       }

       sum = number * sign;

       if(sum > Integer.MAX_VALUE) {
         return Integer.MAX_VALUE;
       }

       if(sum < Integer.MIN_VALUE) {
         return Integer.MAX_VALUE;
       }
    }

    return (int) sum;
  }
}
