package Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by dpandey on 9/18/17.
 *
 * https://www.youtube.com/watch?v=WruoYDGfWSk
 * https://www.youtube.com/watch?v=WruoYDGfWSk
 *
 * Four Ways to find the maximum occurences
 *
 * 1) Bruteforce   ---> O(n^2)
 * 2) Sorting      ---> O(nlogn) + o(n)
 * 3) HashMap      ---> O(n) and space complexity O(n)
 * 4) Addition.    ---> O(n)
 *
 */
public class CountMaximumOccuranceOfAnElement {

    static void  maxDuplicateBySortArray(int input[]) {
        Arrays.sort(input);
        int maxCount = 0;
        int maxCount_Index = 0;
        int count;

        for (int i = 0; i<input.length -1; i++) {
            count = 0;
            while(input[i] == input[i+1] ) {
                count++;
                i++;
            }

            if(count > maxCount) {
                maxCount = count;
                maxCount_Index = i;
            }
        }

        System.out.println("Sorting method element max occurence of element "+ input[maxCount_Index] );
    }

    static void checkDuplicateHashMap(int input[]) {
        int maxCount = 0;
        int count = 0;
        int maxOccuranceElement = -1;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<input.length; i++) {
            int element = input[i];
            if (map.get(element) == null) {
                map.put(element, 1);
            } else{
                int counter = map.get(element);
                map.put(element, counter++);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        for(Map.Entry entry : entrySet) {
            count = (Integer) entry.getValue();
            if(count > maxCount) {
                maxCount = count;
                maxOccuranceElement = (Integer) entry.getKey();
            }
        }

        System.out.println("Hash Map max occurences element: "+ maxOccuranceElement);
    }

    public static void main(String args[]) {
        int input [] = {22,22,33,33,33,33,44,44,77};

        maxDuplicateBySortArray(input);
        checkDuplicateHashMap(input);
    }
}
