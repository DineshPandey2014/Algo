package Misc.Array;

import org.junit.Test;

/**
 * Created by dpandey on 10/29/17.
 */
public class Merge_Two_Sorted_Array {

   @Test
   public void testMergeSort() {
       int nums2 [] = {2,6,7};
       int nums1 [] = {3,10,12,0,0,0};
       merge(nums1, 3, nums2, 3);
       System.out.println(nums1);

   }

    /**
     * Here sizeofNums1 is the length of the array. Represents number of element count
     *
     * Here num1 is bigger array which need to absorb the num2 array
     *
     *  int nums1 [] = {3,10,12,0,0,0};
     *  sizeofNums1 = 3
     *
     *  int nums2 [] = {2,6,7};
     *  sizeOfNums2 = 3
     *
     *
     * @param nums1
     * @param sizeofNums1
     * @param nums2
     * @param sizeOfNums2
     */
        public static void merge(int[]nums1, int sizeofNums1, int[] nums2, int sizeOfNums2) {
            int k = sizeofNums1 + sizeOfNums2 -1;
            int i = sizeofNums1 -1;
            int j = sizeOfNums2 -1;

            /*
             * Here we need to take j as the index of shrter array which need to merge. If J is merged then
             * the bigger array is already merged.
             */
            while(j >= 0) {
                if(i >=0 && nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }

        }
}
