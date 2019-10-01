package Tree;


public class BinarySearch_Using_Recursion_Find_An_ElementInde {


    public static void main (String args []) {
        int arr [] = {10, 12, 13, 14, 16};
        int k = 17;

        int index = findNumber(arr, k,  0, arr.length -1);
        System.out.println(index);
    }

    public static int findNumber (int [] arr, int k, int leftIndex, int rightIndex) {

        int mid =  (leftIndex + rightIndex)/2;

        if(mid < 0 || mid >= arr.length || leftIndex >= arr.length) {
            throw new IllegalArgumentException("Data not found");
        }

        if(arr[mid] == k) {
            return mid;
        }


        // Go right
        if(k > arr[mid]) {
            return findNumber(arr, k, mid + 1, rightIndex);
        }

        // Go left
        if(k < arr[mid]) {
            return findNumber(arr, k,leftIndex , mid-1);
        }

        throw new IllegalArgumentException("Data not found");
    }

}
