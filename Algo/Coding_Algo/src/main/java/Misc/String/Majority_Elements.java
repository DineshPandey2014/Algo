package Misc.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dpandey on 11/22/17.
 * A majority element in an array A[] of size n is an element that appears more than n/2 times
 * Hence there is atmost one such elements
 *
 * https://www.youtube.com/watch?v=uwogtyFiDLg
 *
 * More voting algorithm. This is two step process.
 *
 * 1. Get an element occuring most of the time in the array. This phase will make sure that if there is a majority
 * element then it will return that only.
 *
 * 2. Check if the element obtained from above step is majority element.
 *
 */
public class Majority_Elements {


    /**
     *
     * Using  hashmap.
     *
     * 1) Time complexity O(n)
     * 2) Space complexity is O(n)
     *
     *
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> input = new HashMap<>();
        if(nums == null) {
            throw new IllegalArgumentException("Input array is empty");
        }

        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty");
        }

        if (nums.length == 1) {
            return nums [0];
        }

        int majorityNum = nums.length/2;
        for (int i=0; i<nums.length; i++) {
            if(!input.containsKey(nums[i])) {
                input.put(nums[i], 1);
            } else {
                input.put(nums[i], (input.get(nums[i]) + 1));
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (input.get(nums[j]) > majorityNum) {
                return nums[j];
            }
        }
        return Integer.MAX_VALUE;
    }


    public int majorityElement_More_Algorithm(int[] nums) {
        // 2,2,3,4,5,6,6,7
        int majority = nums[0];
        int count = 1;

        if(nums.length == 1) {
            return nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            if(majority == nums[i]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    majority = nums[i];
                    count = 1;
                }
            }
        }

        int count_majority = 0;
        for (int i = 0; i < nums.length; i++) {
            if(majority == nums[i]) {
                count_majority++;
            }
        }

        if(count_majority > nums.length/2) {
            return majority;
        }
        return Integer.MAX_VALUE;
    }
}
