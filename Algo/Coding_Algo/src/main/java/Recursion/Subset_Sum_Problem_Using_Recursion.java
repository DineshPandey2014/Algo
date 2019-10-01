package Recursion;

/**
 * http://www.techiedelight.com/subset-sum-problem/
 *
 * Using recursion exponential algo Time complexity is O(2(n).
 *
 * 1) We include current item in the subset and recurse for remaining item with remaining sum.
 * 2) We exclude current item from subset and recurse for remaining items.
 *
 * Finally we get true if we get subset by including or excluding current item else we return false.
 * The base case of recursion would be when no items left or sum becoumes required sum we return
 * true subset is found.
 *
 */


public class Subset_Sum_Problem_Using_Recursion {

    public static void main (String args[]) {
        long arr [] = {1,0};
        long k = 0;
        int sum = 0;
        int index  = 0;
        int count = 0;
        boolean input = findSum(arr, sum,   k, index, count);
        System.out.println(input);
    }

    // Return true if there exist sub array of array [0 ....n] with given sum.
    static boolean findSum(long [] arr, long sum,  long k, int i, int count) {

        // Return true if sum becomes 0 (subset found) // base case.
        if( sum == k && count != 0) {
            return true;
        }

        // Base case no items left
        if(i < 0  || i > arr.length -1) {
                return false;
        }

        //Case 1: Exclude current item in the subset (A[n] and recurse for remaining items (n-1). With sum
       boolean exclude = findSum( arr,  sum , k, i + 1, count++);

        // Case 2: Exclude current item n from subset and recurse for remaining tems.
       boolean include =  findSum(arr,sum + arr[i],  k, i + 1, count++);

        // return true if we can get subset by including or excluding the current item.
        return include || exclude;
    }

}
