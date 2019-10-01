package Arrays;

public class To_Lower_Case {

  public String toLowerCase(String str) {
    // Ascii Code of A ==> 65
    // Ascii Code of Z ===> 65 + 25 = > 90

    // Ascii code of a ==> 97
    // Ascii code of z ==> 97 + 25 =>  122

    // Difference of ascii code between A and a --> 97 - 65 => 32
    // To convert From upper case letter to lower case letter we need to add 32 ascii code

    // Algo :
        /* // We have a String convert String to Character array
           // Read Character array one character at a time.




        */
    StringBuffer strBuf = new StringBuffer();

    for (char c : str.toCharArray()) {
      if(Character.isUpperCase(c)){
        char input = (char) (c + 32);
        strBuf.append(input);
      } else {
        strBuf.append(c);
      }
    }


    return   strBuf.toString();
  }
}
