package Tree;

/**
 * https://www.youtube.com/watch?v=j5uXyPJ0Pew&index=1&list=PL2_aWCzGMAwL3ldWlrii6YeLszojgH77j
 *
 * Search of node in a binary tree.
 *
 * n + n/2 +n/4+n/8 ......1
 *
 * Time Complexity = (n/2raise to power k) = 1
 *
 *  k = log to base(2) n = logn
 *
 */
public class BinarySearch_Using_Iterative_Find_An_Element {

   /*
   public void findNumberTest() {

        int inputData [] = {23,55, 66, 88, 99};
        int y = 66;
        System.out.println("Index of the element--> "+findElement(inputData, y));
    }
    */

   public static void main (String args[]) {
       int inputData [] = {23,55, 66, 88, 99};
       int y = -1;
       System.out.println("Index of the element--> "+findElement(inputData, y));

   }

    // Here we will return of the element of the array once it is found.
   public static int findElement(int []inPutArray, int element) {
        int left = 0;
        int right = inPutArray.length -1;
        while (left <= right) {
            int mid = (left +right)/2;
            if(inPutArray[mid] == element) {
                // Found elemement
                return mid;
            } else if(inPutArray[mid] < element) {
                // Reset the pointer
                left = mid + 1;
            } else if(element < inPutArray[mid]) {
                right = mid -1;
            }
        }
         throw new IllegalArgumentException("Not found the number") ;
    }


}
