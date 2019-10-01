package Sorting.sort;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TopK {


    @Test
    public void testSecondOutPut() {
        int [] arr = {4, 8, 9, 6, 6, 2, 10, 2, 8, 1, 2, 9};
        //heapSort(arr, k);
        int k = 7;
        Arrays.sort(arr);

        List<Integer> output = new ArrayList();

       // int p = 0;
        int temp = 0;
        for (int j = arr.length - 1; j >= 0; j--) {

            if(temp == 0) {
                output.add(arr[j]);
                temp = arr[j];
            } else {
                if(output.size() == k) {
                    break;
                }
                if(temp != arr[j]) {
                    output.add(arr[j]);
                    temp = arr[j];
                }
            }

        }
       // Integer x [] = new Integer [output.size()];
        output.toArray();
    }

@Test
    public void dutch_flag_sort(String balls) {
        /*
         * Write your code here.
         */
        String s = "RGBRGB";
         char [] x = balls.toCharArray();
            Arrays.sort(x);
            String sortedString = new String(x);
    }

   @Test
   public void testInput() {


       int [] arr = {4, 1, 8, 1, 9, 10, 3, 9, 4, 4, 2, 5, 7, 1, 3, 5, 8};
       int k = 8;
       heapSort(arr, 8);

       int output  [] = new int [8];

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
       System.out.println(output);


   }

    static int[] topK (int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        heapSort(arr, k);

        for (int k1 = arr.length-1; k1 <=0; k1--) {
            set.add(arr[k1]);
        }
        int output [] = new int [set.size()];
        int l = 0;
        for(Integer x : set) {
            output[l] = x;
            l++;
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

        if(l < n && r < n ) {
            if(arr[l] > arr[r] && arr[l] > arr[i]) {
                largest = l;
            }

            if(arr[r] > arr[l] && arr[r] > arr[i]) {
                largest = r;
            }

        } else {
            if (l < n && arr[l] > arr[i]) {
                largest = l;
            }
        }

        // Swap get the largest to the node and called heapify again
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n, largest);
        }
    }

    /*
    static int[] topK(int[] arr, int k) {
        int z [] = arr;
        Arrays.sort(arr);
        Set<Integer> set = new HashSet();


        for(int j =arr.length -1; j >= 0; j-- ) {
            set.add(arr[j]);
        }

        int y [] = new int [k];
        int l = 0;

        List<Integer> lst = new ArrayList<>();
        lst.addAll(set);

        Collections.reverse(lst);

        for (Integer temp : lst) {
            if (l < k)  {
                y[l] = temp;
                l++;
            }
        }

        return y;
    }*/


/*
    @Test
    void testApp() {
        int z [] = {4,
                8
                9
                6
                6
                2
                10
                2
                8
                1
                2
                9
        };
        topK(z, 2);
    }*/
}
