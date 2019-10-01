package String;

public class StringEncryption {

  public static void main (String args[]) {
    String str = caesarCypherEncryptor("abc",52);
    System.out.println(str);
  }

  public static String caesarCypherEncryptor(String str, int key) {
    int i = 0;
    int j = str.length()-1;
    int k = (int) 'z';
    System.out.println(k);

    String encryptedString = "";
    while(i <= j) {
      int x = str.charAt(i) + key;
      while(x > k) {
        x = x - k + 96;
        System.out.println("---"+x);
      }
      char c = (char) x;
      encryptedString = encryptedString + String.valueOf(c);
      i++;
    }
    return encryptedString;
  }
}
