package String;

public class CompareVersion {

  public static void main (String args[]) {
    int result = compareVersion("1.1", "1.1");
    System.out.println(result);
  }

  public static int compareVersion(String version1, String version2) {

    String [] split1 = version1.split("\\.");
    String [] split2 = version2.split("\\.");
    int i = 0;

    while(i < split1.length || i < split2.length) {
      int num1 = i< split1.length ? Integer.parseInt(split1[i]):0;
      int num2 = i < split2.length ? Integer.parseInt(split2[i]):0;
      if (num1 > num2) {
        return 1;
      } else if(num1 < num2) {
        return -1;
      }
      i++;
    }
    return 0;
  }

}
