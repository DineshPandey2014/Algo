package Recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * https://www.techiedelight.com/print-distinct-subsets-given-set/
 *
 *
 * Given a array [1,2]
 * Total number of subsets in the array. 2^n {Each character can be included or not 2 choilce and we have two numbers}
 *
 * Two decision included or not
 *
 *                   {1,2}
 *              /            \
 *          {} [2]        {1} [2]
 *          /   \            /  \
 *        {}   {2}        {1}   {1,2}
 *
 *
 *
 */
public class GenerateAllSubset {
  public static void main(String[] args)
  {
    String input = "123";
    List<String> ans = new ArrayList<>();
    char[] in = input.toCharArray();
    char[] out = new char[in.length];
    getAllSubsets(in, 0, out, 0, ans);
  }

   /*
    * in is input array.
    * int i is for index of input array
    *
    * out is output array.
    * int j is index of output array.
    *
    */
  static void getAllSubsets(char[] in, int i, char[] out, int j, List<String> s) {

    /**
     * Check the length of the inptu array index. When it is greater then the length of input array.
     * Take all the characters from output array that will be one subset and add to ArrayString.
     */
    if (i == in.length) {
      // printsubset(out, j);
      s.add(new String(out,0,j));
      return;
    }
    // Initally the first character is not included, Second is not included and so on..
    getAllSubsets(in, i+1, out, j, s);
    //Copy the character that is part of subset to output array.
    out[j] = in[i];
    // Increment the counter of i and j
    getAllSubsets(in, i+1, out, j+1, s);
  }


}



  


