package Misc.Array;

/**
 * Created by dpandey on 1/30/18.
 */
public class Segregate0sAnd1s {

    public static void main (String args[]) {
        int array [] = {0,1,0,1,1,0};
        segregate0SAnd1s(array);

        for (Integer x : array) {
            System.out.println(x);
        }
    }

    private static void segregate0SAnd1s(int numbers[]) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;
        while(leftPointer < rightPointer) {
            while(numbers[leftPointer] == 0) {
                leftPointer++;
            }

            while(numbers[rightPointer] == 1) {
                rightPointer--;
            }

            // swap the numbers
            if(leftPointer < rightPointer) {
                int temp = numbers[leftPointer];
                numbers[leftPointer] = numbers[rightPointer];
                numbers[rightPointer] = temp;
                leftPointer++;
                rightPointer--;
            }

        }


    }
}
