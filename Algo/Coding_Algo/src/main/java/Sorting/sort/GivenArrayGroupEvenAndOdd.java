package Sorting.sort;

import org.junit.jupiter.api.Test;

public class GivenArrayGroupEvenAndOdd {

     int[] solve(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        int tempLeft;
        int tempRight;
        while(i < j ) {

            // increment i if it is even. Left side of array will hold even numbers
            while(i < arr.length-1)  {
                // It's even. Continue
                if(arr[i]%2 == 0) {
                    i++;
                } else {
                    // Found odd number. Need to swap hold it in temp.
                    tempLeft = arr[i];
                    break;
                }
            }

            // increment j if it is odd. Right side array will hold odd numbers
            while(j > 0) {
                // If it is odd keep continue
                if(arr[j]%2 != 0) {
                    j--;
                } else {
                    tempRight = arr[j];
                    break;
                }
            }

            // Now swap between i is holding even and j is holding odd
            if(i < j) {
                int temp = arr[j];
                // Assign odd number
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;

            }
        }
        return arr;
    }

    @Test
    public void testInputOne() {
        int x[] = {4, 9, 5, 2, 9, 5, 7, 10};
        solve(x);
    }

}
