package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_Home_Work {

   public static void main (String args[]) {
       String [] x = wordBreak();
       System.out.println("----Length---"+ x.length);
   }

    static String[] wordBreak() {
       //String [] strDict = {"app", "apple", "let", "pie"};

        // a
        //e
        //i
        //int
        //inter
        //interview
        //kick
        //kicker
        //kickstart
        //star
        //start
        //view
        String [] strDict = {"a", "e", "i", "int", "inter", "interview", "kick", "kicker", "kickstart", "star", "view" };


        String str = "catsanddog";

        List<String> list = new ArrayList();
        list.add("cat");
        list.add("cats");
        list.add("sand");
        list.add("and");
       list.add("dog");


        Set<String> set = new HashSet<>(list);
        List<String> lst = new ArrayList();

        /*
        for (String str : strDict) {
            set.add(str);
        }*/

        //word_break("applepie", set, 0, lst);
        word_break("catsanddog", set, 0, lst);
        return lst.toArray(new String [lst.size()]);

    }


    public static boolean word_break(String strWord, Set<String> strDict, int start, List<String> lst) {

        if(start == strWord.length()) {
            return true;
        }


        for(int end = start + 1; end <= strWord.length(); end++) {
            if(strDict.contains(strWord.substring(start, end)) && word_break(strWord, strDict, end, lst)) {
                lst.add(strWord.substring(start, end));
                return true;
            }

        }

        return false;

    }
}
