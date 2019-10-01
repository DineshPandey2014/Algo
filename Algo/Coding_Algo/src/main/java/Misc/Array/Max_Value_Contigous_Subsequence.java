package Misc.Array;

/**
 * Created by dpandey on 11/13/17.
 *
 * https://www.youtube.com/watch?v=dVsspsEEHWE
 * kadane's algorithm
 *
 * https://www.youtube.com/watch?v=86CQq3pKSUw
 */
public class Max_Value_Contigous_Subsequence {

    public static void main(String args[]) {
        int array[] = {4,3,2,-1,6,9};
        maxSubArray(array);
    }

    public static int maxSubArray(int[] nums) {
        int max_current = nums[0];
        int max_global = nums[0];

        for (int i = 1; i<nums.length; i++) {
            max_current = Integer.max(nums[i], max_current + nums[i]);
            if(max_current > max_global) {
                max_global = max_current;
            }
        }
        System.out.println(max_global);
        return  max_global;
    }
}
