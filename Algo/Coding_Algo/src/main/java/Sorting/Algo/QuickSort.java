package Sorting.Algo;

import org.junit.Test;

/**
 * Good video
 * https://www.youtube.com/watch?v=MS44PvRzPSQ
 *
 * https://www.youtube.com/watch?v=MZaf_9IZCrc
 *
 * https://www.geeksforgeeks.org/quick-sort/
 *
 * https://www.youtube.com/watch?v=COk73cpQbFQ&t=856s
 *
 *  Time complexity average case  O(nlog(n))
 *
 *  Worst case time complexity is O(n2)
 *
 *  In place algorithm
 *
 */
public class QuickSort {

    /**
     * This function takes last element as pivot
     * places pivot elements at its correct position in
     * sorted array and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     *
     * @return partition index
     */
    int partiton(int arr[], int start, int end) {

        // Take the pivot as the last element of the array
        int pivot = arr[end];
        int i = start -1; // index of pivot. initally it will be -1

        // J is less than the end. As end we chose as pivot as last element.
        // J initalize as start
        for (int  j = start; j < end; j++) {

            // if current element is smaller than or equal to pivot. Then swap the element with the i th element.
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]= temp;
            }
            // If current element is greater than pivot then don't do any thing.
        }
        // Now we need to swap the pivot to it's right position. For this increment i by 1;
        i++;
        // swap arr[i+1] and arr[end] (or pivot)
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        // Return the index of pivot
        return i;
    }

    public void Quicksort(int arr[], int start, int end) {

     if(start >= end) {
         return;
     }

     int pi = partiton(arr, start, end);
     Quicksort(arr, start, pi-1);
     Quicksort(arr, pi+1, end);

    }

    @Test
  public  void testSorting() {
        //int arr[] = {2, 7, 8, 9, 1, 5};
        int arr[] = {3,1,2};
        int n = arr.length;
        printArray(arr);
        Quicksort(arr, 0, arr.length-1);
        printArray(arr);
    }

    /* A utility function to print array of size n */
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


}
