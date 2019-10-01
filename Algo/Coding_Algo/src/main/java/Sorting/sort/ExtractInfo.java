package Sorting.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ExtractInfo {

    @Test
   public void solve() {

        String arr [] ={
            "key1 abcd",
            "key2 zzz",
            "key1 hello",
            "key3 world",
            "key1 hello"
        };


        List<String> list = new LinkedList();
        int count = 0;


        Arrays.sort(arr);

        String tempKey = null;
        String tempValue = null;

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String splitArr [] = str.split(" ");
            String key = splitArr[0];
            String value = splitArr[1];

            if(tempKey == null) {
                tempKey = key;
                tempValue = value;
            }

            if(key.equals(tempKey)) {
                count++;
                tempValue = value;
            }

            if(!key.equals(tempKey) && tempKey != null) {
                String output = tempKey + ":"+ count + ","+ tempValue;
                list.add(output);
                tempKey = key;
                tempValue = value;
                count = 1;
            }

        }
        String output = tempKey + ":"+ count + ","+ tempValue;
        list.add(output);
        //return list.toArray(new String [list.size()]);

        //return list.toArray(new String [list.size()]);
    }


}
