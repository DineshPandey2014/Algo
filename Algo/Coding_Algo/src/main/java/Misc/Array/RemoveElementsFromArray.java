package Misc.Array;

import org.junit.Test;

/**
 * Created by dpandey on 12/20/17.
 */
public class RemoveElementsFromArray {
    /*
     * Given an array and value, remove all the instances of that value in place and return the new length
     * Do not allocate extra space for another array, you must do this in place with in constant memory.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * Example : [3,2,2,3], val = 3
     * Your function should return length = 2, with the first two elements nums being 2.
     *
     * case : [3,2,2,3] --->Remove all occurences of 3 ---> [2,2,3,3] ---> Return the index of the array.
     *
     */
    @Test
    public void testRemoveElements() {
        int x [] =  {1,2,3,2};
        int y  = removeElementsFromArray(x, 2);
        System.out.println(y);
    }

    public int removeElementsFromArray(int x[], int y) {
        int  j = 0;
        for (int i = 0; i < x.length; i++) {
            if(x[i] != y) {
                x[j] = x[i];
                j++;
            }

        }
        return j;
    }
}
