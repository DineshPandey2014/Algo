package Sorting.sort;

import org.junit.jupiter.api.Test;

public class MergeTwoSortedArray_InplaceAlgorithm {

    @Test
    public void testMergeAlgo() {
        int arr1 [] = {1,2,3};
        int arr2 [] = {14,15,16,0,0,0};
        merger_first_into_second(arr1, arr2);

        int arr [] = {1,2,6,9,11,14};
    }

    static int[] merger_first_into_second(int[] arr1, int[] arr2) {
        int i = arr1.length -1; // 3
        int j = arr1.length -1; // 3
        int k = arr2.length -1; // 6

        while(i >=0 && i != k ) { // 3
            int temp2 = arr2[j]; //
            int temp1 = arr1[i];

            if(temp2 >= temp1) {
                arr2[k] = temp2;
                j--;
            } else {
                arr2[k] = temp1;
                i--;
            }
            k--;
        }

            while (i >=0) {
                arr2[k] = arr1[i];
                i--;
                k--;
            }

        return arr2;
    }
}
