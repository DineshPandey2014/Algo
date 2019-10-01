package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubstring_Using_Recursion {

    public static void main (String args[]) {
        String strInput = "geek";
        String strOutput = "";

        List<String> list = new ArrayList<>();
        int length = strInput.length();
        findAllSubstring(strInput, strOutput, list, length);

        for(String str : list) {
            System.out.println(str);
        }
    }


   static void findAllSubstring(String strInput, String output, List<String> list, int length) {

        if( 0 <output.length() && output.length()<= length ) {
            list.add(output);
            return;
        }

        for(int i = 0; i<length; i++) {
            for (int j = i; j < strInput.length() ; j++) {

                findAllSubstring(strInput.substring(j+1), output + strInput.substring(i,j+1), list, length);
            }
        }
    }


}
