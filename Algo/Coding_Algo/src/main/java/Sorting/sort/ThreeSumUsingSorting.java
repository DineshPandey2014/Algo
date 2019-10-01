package Sorting.sort;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Solution at leet code.
 *
 * https://leetcode.com/problems/3sum/discuss/7498/Python-solution-with-detailed-explanation
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note: The solution set must not contain duplicate triplets.

 Sort based algorithm

 a+b = -c. 3SUM reduces to 2SUM problem.
 Handling Duplicates in 2SUM

 Say index s and e are forming a solution in a sorted array. Now givens nums[s], there is a unique nums[e] such that nums[s]+nums[e]=Target. Therefore, if nums[s+1] is the same as nums[s], then searching in range s+1 to e will give us a duplicate solution. Thus we must move s till nums[s] != nums[s-1] to avoid getting duplicates.
 while s<e and nums[s] == nums[s-1]:
 s = s+1


 Handling Duplicates in 3SUM

 Imagine we are at index i and we have invoked the 2SUM problem from index i+1 to end of the array. Now once the 2SUM terminates, we will have a list of all triplets which include nums[i]. To avoid duplicates, we must skip all nums[i] where nums[i] == nums[i-1].
 if i > 0 and nums[i] == nums[i-1]:
 continue


 */
public class ThreeSumUsingSorting {

    static String[] findZeroSum(int[] arr) {

        Arrays.sort(arr);
        Set<String> set = new HashSet();
        int n = arr.length;

        for (int i = 0 ; i < n; i++) {

            int l = i + 1; int r = n - 1;

            while (l < r) {
                int sum = arr[l] + arr[r] + arr[i];
                if(  sum == 0) {
                    if(!set.contains(arr[i] + "," + arr[l] + "," + arr[r])) {
                        set.add(arr[i] + "," + arr[l] + "," + arr[r]);
                    }
                    l++;
                } else if(sum  > 0) {
                    r--;
                } else {
                    l++;
                }

            }
        }
        return set.toArray(new String[set.size()]);
    }


    @Test
    void testFistInput() {
        int x [] = {-2,-1,0,1,2,};
        String y [] = findZeroSum(x);
    }
}
