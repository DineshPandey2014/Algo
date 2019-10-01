package Misc.Array;

/**
 * Created by dpandey on 10/4/17.
 */

import java.util.Stack;

/**
 *
 * Find the nearest smaller numbers on left side in an array
 *
 *  Input  :  arr[] = {1, 6, 4, 10, 2, 5}
 *  Output :         {_, 1, 1,  4, 1, 2}
 *
 *  First element ('1') has no element on left side.
 *  For 6 there is only one smaller element on left side which is '1'.
 *  For 10 there are three smaller elements on left side (1,6,4). Nearest among three elements is 4.
 *
 *  Here we are using the data structure as Stack.
 *
 */

public class FindSmallestNumberOnLeftSideInArray {
    static void PrintSmallestFromLeft(int arr[])
    {
        Stack stack = new Stack();
        for(int i=0; i< arr.length; i++) {
            while(!stack.empty() && ( (int) stack.peek() >= arr[i])) {
                stack.pop();
            }

            if(stack.empty()) {
                System.out.print("_ ");
            } else {
                System.out.print(stack.peek() + " ");
            }
            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[]  =   {2,5,5,0,1,8,1,9,2};
        PrintSmallestFromLeft(arr);
    }
}
