package Sorting.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class NutAndBolt {

     String [] findPairs(int [] nuts, int [] bolts, int low, int high) {

         if (low < high) {
             // Partition of nuts
             // Take pivot from bolts and use it for nuts to compare.
             int pivotIndex = partition(nuts, low, high, bolts[new Random().nextInt(high-low+1) + low]);

             // Partition of bolts
             // For bolts take a partition index of nuts. Find pivot using nuts array.
             partition(bolts, low, high, nuts[pivotIndex]);

             //if (pivotIndex > 0) {
                 findPairs(nuts, bolts, low, pivotIndex - 1);
            // }

             findPairs(nuts, bolts, pivotIndex + 1, high);
         }

        String [ ] output = new String [bolts.length];

        for(int i = 0; i < bolts.length; i++ ) {
            output[i] = nuts[i] + " " + bolts[i];
        }
        return output;
    }

     int partition(int arr[], int low, int high, int pivot) {
        int i = low;
        int temp3, temp, temp2;
        for(int j = low; j < high; j++) {

            if(arr[j] < pivot) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            } else if(arr[j] == pivot) {
                // If we found the pivot before the last element. We need to move the pivot in the end.
                // So that we can compare all the elements
                // Here we need to reduced the index of J.
                temp2 = arr[j];
                arr[j] = arr[high];
                arr[high] = temp2;
                j--;

            }
        }

         // Swap the pivot to index i+1.
         temp3 = arr[i];
        arr[i] = arr[high];
        arr[high] = temp3;
        return i;
    }


    @Test
    public void testInputTWO() {
        int NUTS [] = {
                44,
                2,
                50,
                26,
                49,
                17
        };
        int BOLTS [] = {50,
                2,
                17,
                26,
                49,
                44};

        String y [] = findPairs(NUTS, BOLTS, 0, NUTS.length-1);

        for(int i = 0; i < y.length; i++) {
            System.out.println(y[i]);

        }
    }

    @Test
    public void testInput() {
         int NUTS [] = {
                 24,
                 12,
                 99,
                 11,
                 91,
                 46,
                 38,
                 63,
                 93,
                 20,
                 54,
                 83,
                 61,
                 32,
                 90,
                 26,
                 67,
                 88,
                 87,
                 94
                 };
         int BOLTS [] = {12,
                 54,
                 26,
                 99,
                 24,
                 91,
                 38,
                 63,
                 83,
                 90,
                 20,
                 32,
                 67,
                 11,
                 46,
                 93,
                 94,
                 87,
                 61,
                 88};

       String y [] = findPairs(NUTS, BOLTS, 0, NUTS.length-1);

       for(int i = 0; i < y.length; i++) {
           System.out.println(y[i]);

       }
    }




}
