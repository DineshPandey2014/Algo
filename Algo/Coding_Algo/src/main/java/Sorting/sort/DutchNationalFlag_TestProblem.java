package Sorting.sort;

import org.junit.jupiter.api.Test;

/**
 * Dutch national flag problem algorithm
 *
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 *
 * https://www.youtube.com/watch?v=BOt1DAvR0zI
 *
 * Good video
 * https://www.youtube.com/watch?v=CNVN76UWpBo
 *
 * Code
 * http://interviewmakertech.blogspot.com/2014/12/given-array-of-red-green-and-blue-balls.html
 *
 * // http://interviewmakertech.blogspot.com/2014/12/blog-post.html#
 *
 * Time Complexity is O(n)
 * In place algorithm.
 */
public class DutchNationalFlag_TestProblem {

    @Test
    public void testInput() {

        String str = "GBGGRBRG";
       String output = dutch_flag_sort(str);
    }

    static String dutch_flag_sort(String balls) {
        int i = 0;  // i pointer represent red ball
        int j = 0;  // j also point to red.
        int k = balls.length() -1;

        // If at j is pointing to red ball and j<=k swap a[i] and a[j] and increment i++, j++
        // If at j is pointing to green ball no swap and j<=k . Just increment pointer j++. Let the green ball in the center.
        // If at j is pointing to  blue ball and j<=k. Swap between a[j] and a[k]
        char input [] = balls.toCharArray();

        while(j<=k) {
            char c = input[j];

            if(c == 'R') {
                char temp = c;
                input[j] = input[i];
                input[i] = temp;
                i++;
                j++;
            }

            if(c == 'G') {
                j++;
            }

            if(c == 'B') {
                char temp = c;
                input[j] = input[k];
                input[k] = temp;
                k--;
            }
        }

        return new String (input);
    }

}
