package BitWise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dpandey on 11/26/17.
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * https://www.youtube.com/watch?v=SpMwf4CIy4k
 *
 * Using bit XOR wise operator. It will cancel the same number. Left is the one which is not having a pair.
 *
 * Here we need to do without using extra
 */
public class Single_Number {

    /*
     * Using exclusive or operator (XOR). It will cancel the sum of same number to 0
     *
     *  2 ^ 2 --> 10 ^ 10 --> 00
     *  No extra space used.
     *
     */
    public int singleNumber_Using_Exclusive_OR_OPERATORE(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Integer.MAX_VALUE;
    }
}
