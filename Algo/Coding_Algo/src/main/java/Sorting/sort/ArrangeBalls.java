package Sorting.sort;

import org.junit.jupiter.api.Test;

/**
 * Given balls of three colors (Red, Green and Blue) arranged randomly in a line.

 The task is to arrange them such that all balls of the same color are together and their collective color groups are in the correct order (Red balls first, Green balls next and Blue balls last).

 These are the colors similar to the Dutch National Flag, hence the problem name.

 This is a popular sorting problem.

 Input Format:

 A string of letters, where each letter represents a ball with color.

 'R' = Red Ball
 'G' = Green Ball
 'B' = Blue Ball

 Balls are arranged in the line, in the same order as they appear in the string.

 Output Format:

 A string of letters, in sorted order.
 Constraints:

 1 <= length of string <= 200000
 Do this in ONE pass over the string - NOT TWO passes, just one pass.
 Your solution can only use O(1) extra memory i.e. you have to do this in-place. Don't use any other memory for processing.
 If you are using a language where Strings are immutable, then you cause copy it into a character array. That still counts as constant extra memory for this purpose.

 Sample Test Case:

 Sample Input:

 GBGGRBRG

 Sample Output:

 RRGGGGBB

 Explanation:

 In the input there are total 2 red balls, 4 green balls and 2 blue balls. In output red balls should come first, then green and then blue. So RRGGGGBB is the correct output.

 Notes:
 A naive solution to this problem, is to simply count how many balls of each color, and then overwrite the array with that many balls in the expected order of colors. However, realize that that is not how it's ""practically"" feasible to do ""with actual balls"". i.e. you can overwrite variables in a program, but there is no way to "overwrite" a ball of a certain color with another color. i.e. that is an invalid solution.

 */
public class ArrangeBalls {


    @Test
    void  testInput() {

    }

}
