package Sorting.Algo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *  You Tube video good one
 *  https://www.youtube.com/watch?v=LhhRbRXhB40
 *
 *  Good video about heap video.
 *  https://www.youtube.com/watch?v=40iljMQmqmY
 *
 *  Heap is a binary tree. Every node as almost two children or One Children or no children.
 *  Every heap is an almost complete binary tree. Heap is a left bianry tree. Fill the elements left to right.
 *
 *  Two type heap.
 *
 *  1) Max heap : In which root is always maximum element for every sub tree. ALmost complete binary tree.
 *
 *  2) Minimum heap : In which root is always contains minimum element tree. For every sub tree.
 *
 *
 *  For Understanding Heap Please Read https://www.programiz.com/dsa/heap-sort
 *  https://www.programiz.com/dsa/heap-sort
 *
 *  Time complexity for HeapSort in worst case or average case is same that is  ----> O(n(logn))
 *
 *  In place algorithm
 *
 *  https://www.unf.edu/~wkloster/3540/heap.java
 *
 *  Index Start from :- 0, 1, 2, 3, 4, 5
 *
 *   How to find the leaf node of the given parent node.
 *
 *   1) Node at index k in array has children at indexes 2k+1, 2k+2
 *
 *   2)Node at index k in array has parent at index (k-1)/2 [Truncate the fractional part]
 *
 *   3) Left Node after which there will be no leave node. will be (n/2 - 1)
 */
// Java program for implementation of Heap Sort
public class HeapSort
{
    public void sort(int arr[]) {
        // Total number of elements.
        int n = arr.length;

        // Build heap (rearrange array)
        int x = n / 2 - 1;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }

        Set<Integer> set = new HashSet<>();

        for(Integer setone : set){

        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest index as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}