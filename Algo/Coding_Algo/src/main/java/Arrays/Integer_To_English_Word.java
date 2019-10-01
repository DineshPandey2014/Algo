package Arrays;

import org.junit.Test;

public class Integer_To_English_Word {

  private final String [] THOUSAND = {"", "Thousand", "Million", "Billion"}; // Multiple of thousand

  private final String [] LESS_THEN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Tweleve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"}; // Less then twenty

  private final String [] TENS = {"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  @Test
  public void testNumberToWords() {

    String result = numberToWords(20);
    System.out.println(result);

  }

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    StringBuilder str = new StringBuilder();
    int index = 0;

    while(num > 0) {
      if(num % 1000 != 0) {
         StringBuilder tmp = new StringBuilder();
         helper(tmp, num % 1000);
        str.insert(0, tmp.append(THOUSAND[index]).append(" "));
      }
      index++;
      num = num/1000;
    }
    return str.toString();
  }

  private void helper(StringBuilder sb, int num) {
    if(num == 0) {
      return;
    } else if(num < 20) {
      sb.append(LESS_THEN_TWENTY[num]).append(" ");
      return;
    } else if(num < 100) {
        sb.append(TENS[num/10]).append(" ");
        helper(sb, num%10);
    } else {
      sb.append(LESS_THEN_TWENTY[num/100]).append(" Hundred ");
      helper(sb, num%100);
    }

  }

}
