package Misc.String;

import org.junit.Test;

/**
 * Created by dpandey on 11/6/17.
 */
public class Given_Two_String_Is_ValidAnagram {
    public static int NUMBER_LETTERS = 26;

    @Test
    public void isValidAnagram() {
        boolean isValidAnagram = isAnagram("dinesh", "dinesh");
        System.out.println(isValidAnagram);

    }

    public boolean isAnagram(String s, String t) {
        if( s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        int arrayOne [] = returnCharCount(s);
        int arrayTwo [] = returnCharCount(t);
        // Assuming the letters are lowercase a-z
        for(int i = 0; i<NUMBER_LETTERS; i++) {
            if(arrayOne[i] != arrayTwo[i]){
                return false;
            }
        }
        return true;
    }

    public int [] returnCharCount(String s) {
        int [] stringCharCount = new int[26];
        int offSet = (int)'a';

        for(int i = 0; i<s.length(); i++) {
            int arrayIndexOne =  s.charAt(i);
            int index = arrayIndexOne - offSet;
            stringCharCount[index] = stringCharCount[index] + 1;
        }
        return stringCharCount;
    }
}
