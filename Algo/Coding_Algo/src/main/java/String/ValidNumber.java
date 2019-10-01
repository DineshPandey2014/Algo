package String;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/valid-number/
 *
 * Validate if a given string is numeric.
 Some examples:
 "0"  true
 "0.1"  true
 "abc"  false
 Example Questions Candidate Might Ask:
 Q: How to account for whitespaces in the string?
 A: When deciding if a string is numeric, ignore both leading and trailing whitespaces.
 Q: Should I ignore spaces in between numbers – such as “1 1”?
 A: No, only ignore leading and trailing whitespaces. “1 1” is not numeric.
 Q: If the string contains additional characters after a number, is it considered valid?
 A: No. If the string contains any non-numeric characters (excluding whitespaces and decimal
 point), it is not numeric.
 Q: Is it valid if a plus or minus sign appear before the number?
 A: Yes. “+1” and “-1” are both numeric.
 Q: Should I consider only numbers in decimal? How about numbers in other bases such as
 hexadecimal (0xFF)?
 A: Only consider decimal numbers. “0xFF” is not numeric.
 Q: Should I consider exponent such as “1e10” as numeric?
 A: No. But feel free to work on the challenge that takes exponent into consideration. (The Online
 Judge problem does take exponent into account.)
 */
public class ValidNumber {

  @Test
  public void testIsNumber() {
    Assert.assertEquals(true, isNumber("0"));
    Assert.assertEquals(true, isNumber("2.2"));
    Assert.assertEquals(true, isNumber("   3.4"));
    Assert.assertEquals(true, isNumber("   3333.4444  "));
    Assert.assertEquals(true, isNumber("   22.33e10"));
  }

  public boolean isNumber(String s) {
    int start = 0;
    int n = s.length();
    boolean isNumeric = false;

    while (start < n && Character.isWhitespace(s.charAt(start))) {
      start++;
    }

    if (start < n && (s.charAt(start) == '+' || s.charAt(start) == '-')) {
      start++;
    }

    //Handled the case when we have decimal number like "+22", "-44"
    while (start < n && (Character.isDigit(s.charAt(start)))) {
      start++;
      isNumeric = true;
    }

    // To handle the case of decimalpoint. "+22.2"
    if (start < n && s.charAt(start) == '.') {
      start++;
      while (start < n && (Character.isDigit(s.charAt(start)))) {
        start++;
        isNumeric = true;
      }
    }

    // To handle the case of exponential. After e you might get + or - sign and then decimal number
    // "+22.2e+10"
    if(isNumeric && start < n && s.charAt(start)== 'e') {
      start++;
      if (start < n && (s.charAt(start) == '+' || s.charAt(start) == '-')) {
        start++;
      }
      isNumeric = false;
      while (start < n && (Character.isDigit(s.charAt(start)))) {
        start++;
        isNumeric = true;
      }
    }

    while (start < n && Character.isWhitespace(s.charAt(start))) {
      start++;
    }

    return isNumeric && start == n;
  }


}
