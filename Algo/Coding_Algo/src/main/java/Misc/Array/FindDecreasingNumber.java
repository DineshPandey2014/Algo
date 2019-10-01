package Misc.Array;

import org.junit.Test;

/**
 *
 * http://algorithms.tutorialhorizon.com/find-the-increasing-or-decreasing-point-in-an-array/
 * Created by dpandey on 9/28/17.
 *
 *
 * Objec­tive:  Given an array of integer which is first increasing then decreasing.
 * Find the ele­ment in array from which point it starts decreasing.
 * OR
 * Given an array of inte­ger which is first increas­ing then decreas­ing. Find the max­i­mum ele­ment in that array.
 * Sim­i­lar Prob­lem: Given an array of inte­ger which is first decreas­ing then increas­ing. Find the ele­ment in array from which point it starts increas­ing.
 * OR
 * Given an array of inte­ger which is first decreas­ing then increas­ing. Find the min­i­mum ele­ment in that array.
 */
public class FindDecreasingNumber {

    /**
     * Brute force
     *
     * @param input
     * @return
     *
     * Time Complexity O(N)
     */
    public int findMaxInteger(int [] input) {
        //4,5,6,7,8,9
        // 1,2,3,4,6,5,4,3,2,1
        // 4,2,1
        // 7
        // 4,5,6,7,8,3,2,1
        int i = 0;
        int temp = 0;

        if(input == null) {
            throw new RuntimeException("input array can not be null");
        }

        if(input.length == 1) {
            return input[0];
        }

        while(i < input.length -1)  {
            if( input[i] < input[i+1]) {
                temp = i+1;
            }
            i++;
        }
        return input[temp];
    }

    @Test
    public void testfindMaxInteger() {

        int [] a1 = {1,2,4};
        System.out.println("----Max Integer---"+findMaxInteger(a1)); // 4

        int [] a2 = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
        System.out.println("----Max Integer---"+findMaxInteger(a2)); // 55

        int [] a3 = {4,2,1};
        System.out.println("----Max Integer---"+findMaxInteger(a3)); // 4
    }


    /**
     * Time Complexity: O(Logn)
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public  int  FirstDecreasingBinarySearch(int arr[], int low, int high) {
        // function to find the
        // maximum element

       /* Base Case: Only one element is
          present in arr[low..high]*/
        if (low == high) {
            return arr[low];
        }

        /**
         * If there are two elements first is greater then second element.
         * First is maximum
         *
         */
        if((low == high + 1) && (arr[low] >= arr[high])) {
            return arr[low];
        }

        /**
         * If there are two elements second is greater then first.
         * Second is maximum.
         *
         */
        if((low == high + 1)  && (arr[low] <= arr[high])) {
            return arr[high];
        }

        /**
         *  If we reach a point where arr[mid] is greater than both of it's adjacent element
         *  arr[mid-1] and arr[mid+1] then arr[mid] is the maximum is the max element.
         *
         */
        int mid = (low + high)/2;

        if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
            return arr[mid];
        }

        /**
         * 1. if arr[mid] is greater then arr[mid+1] then maximum element lies on left side.
         * 2. if arr[mid] is greater then arr[mid-1] then maximum element lies on right side
         *
         */

        if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid -1]) {
            return FirstDecreasingBinarySearch(arr,low , mid-1);
        } else {
            return FirstDecreasingBinarySearch(arr,mid + 1, high);
        }
    }

    @Test
    public void testFirstDecreasingBinarySearch() {
        int [] a1 = {1,2,4};
        System.out.println("----Max Integer---"+FirstDecreasingBinarySearch(a1, 0, a1.length-1)); // 4

        int [] a2 = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
        System.out.println("----Max Integer---"+FirstDecreasingBinarySearch(a2, 0, a2.length-1)); // 55

        int [] a3 = {4,2,1};
        System.out.println("----Max Integer---"+FirstDecreasingBinarySearch(a3, 0, a3.length-1)); // 4
    }
}
