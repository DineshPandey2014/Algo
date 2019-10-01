package Misc.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpandey on 10/6/17.
 */
public class ConvertDecimalToBinary {

    /**
     * Convert decimal to binary.
     *
     * @param
     */

    public static void convertDecimalToBinary(int n) {
        String binaryNumber;
        int number = n;
        List<Integer> lst = new ArrayList<>();

        while(number/2 != 0) {
            int binary =  number%2;
            lst.add(binary);

            number = number/2;

        }
        lst.add(1);
        //
        System.out.println(lst);
        for(int i = lst.size()-1; i>=0; i--) {
            System.out.println(lst.get(i)) ;
        }
    }

    public static void main(String args[]) {
        int [] x = {1,1,0,1,1,1};

        //convertDecimalToBinary(x);
       int y = findMaxConsecutiveOnes(x);

    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currCount = 0;

        if(nums.length == 1) {
            if(nums[0] == 1) {
                maxCount = 1;
            }
        }

        for (int  i = 0 ; i<nums.length; i++) {
            if(nums[i] == 1) {
                currCount++;
                maxCount = Math.max(maxCount, currCount);
            } else {
                currCount = 0;
            }

        }
        return maxCount;
    }
}
