package Misc.Array;

import org.junit.Test;

/**
 * Created by dpandey on 11/15/17.
 */
public class Product_of_Array_Except_Self {

    @Test
    public void productOfArray() {
        int number[] = {1,2,3,4};
        System.out.println(productExceptSelf(number));

    }
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        //int number = {1,2,3,4};
        // {24,12,8,6}
        int left = 1;
        int right = 1;
        int length = nums.length;

        int [ ] leftArray  = new int [length];

        // Left multiplication
        for(int i = 0; i<length; i++) {
            leftArray[i] = left;
            left = left * nums[i];
        }

        // Right side multipication with left side.
        for (int i = length-1; i >= 0 ; i--) {
            leftArray[i] = leftArray[i]  * right;
            right = right * nums[i];
        }
        return leftArray;
    }
}
