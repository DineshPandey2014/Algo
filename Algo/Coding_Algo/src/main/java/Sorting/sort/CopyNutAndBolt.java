package Sorting.sort;

import java.util.*;

public class CopyNutAndBolt {

    public static void main (String args[]) {
         int [] y = {-2, 2 , 0 ,-1 ,1};
        String x [] = originalSolution(y);
    }

    static String[] originalSolution(int input []) {
        //TreeSet<String> set = new TreeSet<>();
        Set<String> set = new HashSet<>();
        int n = input.length;
        // We will sort the input first. This is a pre-requisite for two pointer technique.
        Arrays.sort(input);
        for (int index = 0; index < n; index++) {
            int currentElement = input[index];
            // We need sum -currentElement so the sum of all three elements would be zero.
            int neededSum = -currentElement;
            // Maintain a left index to the next of current index
            // Maintain a right index to the last element of the array
            int left = index + 1, right = n - 1;
            while (left < right) {
                int sum = input[left] + input[right];
                if (sum == neededSum) {
                    /*
                     * If we find the triplet
                     * 1. Add it to the set
                     * 2. Move either the left pointer or the right pointer
                     */
                    if (!set.contains(
                            currentElement + "," + input[left] + "," + input[right])) {
                        set.add(currentElement + "," + input[left] + "," + input[right]);
                    }
                    left++;
                } else if (sum > neededSum) {
                    // If sum is more than intended, decrement the right pointer
                    right--;
                } else {
                    // If sum is less than intended, increment the left pointer
                    left++;
                }
            }
        }
        // Return the array from the set
        return set.toArray(new String[set.size()]);
    }

    /*
    static String[] findZeroSum(int[] arr) {
        Arrays.sort(arr);
        List<String> input = new ArrayList<>();
        Set<String> set = new HashSet();


        if(arr.length == 3) {
            if(arr[0] + arr[1] + arr[2] == 0) {
                input.add(String.valueOf(arr[0])+ "," + String.valueOf(arr[1]) + "," + String.valueOf(arr[2]));
            }
            return input.toArray(new String[input.size()]);
        }

        for (int i = 0 ; i < arr.length; i++) {

            int target = arr[i];
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int sum = arr[l] + arr[r] + target;
                if(sum == 0) {
                    if(!set.contains(String.valueOf(target) + "," + String.valueOf(arr[l]) + "," + String.valueOf(arr[r]))) {
                        set.add(String.valueOf(target) + "," + String.valueOf(arr[l]) + "," + String.valueOf(arr[r]));
                    }
                    l++;
                   // r = arr.length - 1;
                } else if(sum  > 0) {
                    r--;
                } else {
                    l++;
                   // r = arr.length - 1;
                }

            }
        }


        return set.toArray(new String[input.size()]);

    }*/

/*
    static String[] findZeroSum(int[] arr) {
        Arrays.sort(arr);
        List<String> input = new ArrayList<>();
        Set<String> set = new HashSet();


        if(arr.length == 3) {
            if(arr[0] + arr[1] + arr[2] == 0) {
                input.add(String.valueOf(arr[0])+ "," + String.valueOf(arr[1]) + "," + String.valueOf(arr[2]));
            }
            return input.toArray(new String[input.size()]);
        }

        for (int i = 0 ; i < arr.length; i++) {

            int target = arr[i];
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int sum = arr[l] + arr[r] + target;
                if(sum == 0) {
                    if(!set.contains(String.valueOf(target) + "," + String.valueOf(arr[l]) + "," + String.valueOf(arr[r]))) {
                        set.add(String.valueOf(target) + "," + String.valueOf(arr[l]) + "," + String.valueOf(arr[r]));
                    }
                    l++;
                } else if(sum  > 0) {
                    r--;
                } else {
                    l++;
                    r = arr.length - 1;
                }

            }
        }
        return set.toArray(new String[input.size()]);

    }*/

}
