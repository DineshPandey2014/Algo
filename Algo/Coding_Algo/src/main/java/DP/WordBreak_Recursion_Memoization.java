package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * In the previous approach we can see that many subproblems were redundant, i.e we were calling the recursive
 * function multiple times for a particular string. To avoid this we can use memoization method, where an
 * array memomemo is used to store the result of the subproblems. Now, when the function is called again for
 * a particular string, value will be fetched and returned using the memomemo array, if its value has
 * been already evaluated.

 With memoization many redundant subproblems are avoided and recursion tree is pruned and thus it reduces the
 time complexity by a large factor.

 */
public class WordBreak_Recursion_Memoization {

   public static void main (String args[]) {
       String str = "catscat";
       List<String> list = new ArrayList();
       list.add("cats");
       list.add("cat");

       /*
        String str = "catsanddog";

        List<String> list = new ArrayList();
        list.add("cat");
        list.add("cats");
        list.add("and");
       list.add("dog");
       */


       boolean bol = word_Break(str, new HashSet(list), 0, new Boolean[str.length()]);

        System.out.println(bol);
   }

    public static boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

}
