package Misc.String;

import org.junit.Test;

/**
 * Created by dpandey on 11/6/17.
 *
 * Given two String (lowercase a--->z) how many characters do we need to remove from either to make them anagram ?
 * Example: hello, billion --> Answer: hello ---> billion  --->
 *
 * hello ---> (Count --> h -->1, e-->1, l-->2, o-->1)  -->h,e,
 * billion --> (Count --> b -->1, i-->2, l-->2, o-->1, n-->1) --> b,i,i,n
 *
 * Total -> 6 character need to remove.
 *
 * Anagram--> It is an arrangement of characters. Two String are anagram when then have same set of characters
 * but in different order.
 *
 */
public class Given_Two_String_How_Many_Characters_Removed_To_Make_Them_Anagram {


    @Test
    public void testAnagram() {
        int [] x = returnCharCount("Dindne");
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
