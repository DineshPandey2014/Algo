package Maths;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Integer_To_English_Words {

  @Test
  public void testWordToNumber() {
    String result = numberToWords(899);
    System.out.println(result);

  }


  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    Map<Integer, String> map = new HashMap<>();
    // Step 1: fill the hash map
    fillHashMap(map);

    StringBuffer sb = new StringBuffer();
    int groupId = 1;

    // Step 2: group the num with 3 digits
    while (num > 0) {
      int group = num % 1000;

      if (groupId > 1 && group > 0) {
        String groupStr = getGroupName(groupId);
        sb.insert(0, groupStr);
      }

      String str = numberToWordsHelper(group, map);
      sb.insert(0, str);

      groupId++;
      num /= 1000;
    }

    String result = sb.toString();
    if (result.charAt(result.length() - 1) == ' ') {
      return result.substring(0, result.length() - 1);
    } else {
      return result;
    }
  }

  private void fillHashMap(Map<Integer, String> map) {
    map.put(1, "One ");
    map.put(2, "Two ");
    map.put(3, "Three ");
    map.put(4, "Four ");
    map.put(5, "Five ");
    map.put(6, "Six ");
    map.put(7, "Seven ");
    map.put(8, "Eight ");
    map.put(9, "Nine ");
    map.put(10, "Ten ");
    map.put(11, "Eleven ");
    map.put(12, "Twelve ");
    map.put(13, "Thirteen ");
    map.put(14, "Fourteen ");
    map.put(15, "Fifteen ");
    map.put(16, "Sixteen ");
    map.put(17, "Seventeen ");
    map.put(18, "Eighteen ");
    map.put(19, "Nineteen ");
    map.put(20, "Twenty ");
    map.put(30, "Thirty ");
    map.put(40, "Forty ");
    map.put(50, "Fifty ");
    map.put(60, "Sixty ");
    map.put(70, "Seventy ");
    map.put(80, "Eighty ");
    map.put(90, "Ninety ");
    map.put(100, "One Hundred ");
    map.put(1000, "One Thousand ");
  }

  private String getGroupName(int groupId) {
    String result = null;
    switch(groupId) {
      case 2: result = "Thousand ";
        break;

      case 3: result = "Million ";
        break;

      case 4: result = "Billion ";
        break;
    }

    return result;
  }

  private String numberToWordsHelper(int num, Map<Integer, String> map) {
    int pos = 0;
    StringBuffer sb = new StringBuffer();

    if (num <= 0) {
      return "";
    }

    int tmp = num;
    while (tmp > 0) {
      pos++;
      tmp /= 10;
    }

    while (num > 0) {
      if (num <= 20) {
        sb.append(map.get(num));
        break;
      }

      int digit = num / (int) Math.pow(10, pos - 1);
      int curr = digit * (int) Math.pow(10, pos - 1);

      if (pos == 3) {
        sb.append(map.get(digit));
        sb.append("Hundred ");
      } else {
        sb.append(map.get(curr));
      }

      num = num % (int) Math.pow(10, pos - 1);
      pos--;
    }

    return sb.toString();
  }
}
