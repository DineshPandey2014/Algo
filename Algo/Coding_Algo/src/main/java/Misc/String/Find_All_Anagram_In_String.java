package Misc.String;

import java.util.*;

/**
 * Created by dpandey on 11/7/17.
 */
public class Find_All_Anagram_In_String {
    // It will hold the index of start if substring.
    public List<Integer> result = new ArrayList();

    public List<Integer> findAnagrams(String text, String pattern) {

        if(text == null || pattern == null)  {
            return result;
        }

        if(pattern.length() > text.length()) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }

        int match = 0;

        /*
        for(int i = 0) {

        }*/
        return null;
    }

    public static void main(String args[])
    {
        Find_All_Anagram_In_String object = new Find_All_Anagram_In_String();

        //System.out.println(findAnagrams("xyizxyiz", "xyiz"));

    }


}
