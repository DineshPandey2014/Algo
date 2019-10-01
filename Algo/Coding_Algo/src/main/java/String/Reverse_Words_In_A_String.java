package String;


import org.junit.Test;

/**
 * Given an input string, reverse the string word by word.



 Example 1:

 Input: "the sky is blue"
 Output: "blue is sky the"
 Example 2:

 Input: "  hello world!  "
 Output: "world! hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.
 Example 3:

 Input: "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 */
public class Reverse_Words_In_A_String {

  @Test
  public void TestReverseWord() {
    String str = "Dinesh Pan  dey";

    // It will create a reverse String with one space.
    String output = reverseWords(str.trim());

    // In Second pass we will reverse each word which will having one space.
    char [] input = output.toCharArray();
    reversedInputCharacterArray(input);

    System.out.println(String.valueOf(input));

  }

  // It will create a reverse String with one space.
  // First PAss
  public String reverseWords(String str) {
    StringBuilder reverse = new StringBuilder();
    boolean addSpace = false;

    for (int i = str.length()-1 ; i >=0; i--) {
      char temp = str.charAt(i);
      if(temp == ' ') {
        if(addSpace == true) {
          reverse.append(" ");
          addSpace = false;
        }
        //continue;
      } else if(temp != ' ') {
        reverse.append(temp);
        addSpace = true;
      }

    }
    return reverse.toString();
  }

  // Second Pass Here we have character array
  // Will reverse each word
  // Example : yed naP hseniD --->dey Pan Dinesh
  public void reversedInputCharacterArray(char [] input) {
    int j = 0;
    for (int i = 0; i < input.length; i++ ) {
      char temp = input[i];
      if(temp == ' ') {
        reversedEachWordSwap(j , i-1, input);
        j = i + 1;
      }
    }
    reversedEachWordSwap(j, input.length-1, input);

  }

  public void reversedEachWordSwap(int startIndex, int endIndex, char [] input) {
     while(startIndex < endIndex) {
       char temp = input[startIndex];
       input[startIndex] = input[endIndex];
       input[endIndex] = temp;
       startIndex++;
       endIndex--;
     }
  }
}


