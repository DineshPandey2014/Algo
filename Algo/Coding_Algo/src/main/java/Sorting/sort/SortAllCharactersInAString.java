package Sorting.sort;

import org.junit.jupiter.api.Test;


/**
 *  Sort an array of characters (ASCII only, not UTF8).

 Input: A string of characters, like a full English sentence, delimited by a newline or NULL. Duplicates are okay.
 Output: A string of characters, in sorted order of their ASCII values. You can overwrite the existing array.

 Solution Complexity: Aim for linear time and constant additional space.

 (What to understand from this problem: ASCII is great, because it's limited to 256. Remember that for any input that is bound to a range)

 Solution: This is a trivial problem :-)
 *
 */
public class SortAllCharactersInAString {

    @Test
    void testInput() {
        String output = sortCharacters("This is easy");
     //   Assertions.assertEquals();

    }

    static String sortCharacters(String inString) {

        String  str [] = new String[256];

        for (int i = 0; i < inString.length(); i++) {

            char inputChar = inString.charAt(i);
            int index = inString.charAt(i);
            String inputString = String.valueOf(inputChar);
            if(inputString != " ") {

                if(str[index] == null) {
                    str[index] = inputString;
                } else {
                    String temp = str[index];
                    temp = temp + inputString;
                    str[index] = temp;
                }
            }
        }

        StringBuffer strBuff = new StringBuffer();

        for(int j = 0; j < str.length; j++) {
            if(str[j] !=null) {
                strBuff.append(str[j]);
            }
        }

        return strBuff.toString();
    }

}
