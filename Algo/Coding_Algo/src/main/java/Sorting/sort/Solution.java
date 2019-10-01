package Sorting.sort;

public class Solution {

    static int[] topK(int[] arr, int k) {
        heapSort(arr, k);

        int output  [] = new int [k];

        int p = 0;
        int temp = 0;
        for (int j = arr.length - 1; j >= 0; j--) {

            if(temp == 0) {
                output[p] = arr[j];
                temp = arr[j];
                p++;

            } else {
                if(p == k) {
                    break;
                }
                if(temp != arr[j]) {
                    output[p]  = arr[j];
                    temp = arr[j];
                    p++;
                }
            }

        }

        return output;
    }


    public static void heapSort(int [] arr, int k) {
        int n = arr.length;
        int numberOfMaxElements = 0;

        // Start Heapify from the left side of last node which have atleast one left child.
        for (int i = n/2 - 1; i >= 0 ; i--) {
            maxHeapify(arr, n, i);
        }

        // One by one extract the element from heap.
        for ( int j = n-1; j >=0; j--) {

            // Move current root to end. Move first element to end.
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            // call max heapify on the reduced heap
            // Here we need to heapify array again start from 0 index
            maxHeapify(arr, j, 0);
        }
    }

    // n = total num of number of elements
    // int i index of node from which we need to start hepify. Node index after that are leaves
    // Which are already heapify

    public static void maxHeapify (int arr[], int n, int i) {

        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l < n && arr[l] > arr[r] && arr[l] > arr[i]) {
            largest = l;
        }

        if(r < n && arr[r] > arr[l] && arr[r] > arr[i]) {
            largest = r;
        }

        // Swap get the largest to the node and called heapify again
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n, largest);
        }
    }




}
