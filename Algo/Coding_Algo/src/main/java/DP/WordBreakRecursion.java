package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakRecursion {

    public static void main(String args[]) {
        String str = "aa";
        List<String> list = new ArrayList();
        list.add("a");
        list.add("aa");

        /*
        String str = "catsanddog";

        List<String> list = new ArrayList();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("dog");
        */

       boolean bol =  wordBreak(str, list);

       System.out.println(bol);
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }

    /**
     * This is a recursive solution.
     *
     * c is in dict
     * ca is in dict
     * cat is in dict. Now from here it get into two parts. We will split the String and check recursive if next half String is in the dict
     *     ----> cat/sanddog ---> cat/sanddog --> Which will return false for sanddog part.
     *     ----->cats/anddog ---> anddog ---> and/dog ----> So we found three subset of this which is part of dict (cats/and/dog)
     *
     * This is recursive no memoization no dp.
     *
     * The naive approach to solve this problem is to use recursion and backtracking. For finding the solution, we check every possible prefix of
     * that string in the dictionary of words, if it is found in the dictionary, then the recursive function is called for the remaining
     * portion of that string. And, if in some function call it is found that the complete string is in dictionary, then it will return true.
     *
     *
     Time complexity : O(n^n) Consider the worst case where s = "aaaaaaa" and every prefix of ss is present in the
     dictionary of words, then the recursion tree can grow upto n^n
     ​​
     *
     *
     * @param s
     * @param wordDict
     * @param start
     * @return
     */
    public static boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }



    public static boolean isWordBreak(String s,Set set) {
        if(s.length() == 0) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if(set.contains(str)) {
                return  isWordBreak(s.substring(i), set);
            }
        }
        return false;
    }

    public static Set inDictionary (List<String> wordDict) {
        return new HashSet(wordDict);
    }
}
