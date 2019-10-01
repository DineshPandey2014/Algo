package Misc.Array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpandey on 12/27/17.
 */
public class ContainsDuplicate {

    @Test
    public void testDulicate() {
        int nums [] = {3,3};
        boolean x = containsDuplicate(nums);
        System.out.println(x);
    }



    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length ; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }
}
