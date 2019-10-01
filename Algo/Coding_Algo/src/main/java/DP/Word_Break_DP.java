package DP;

import java.util.*;

public class Word_Break_DP {

    public static void main(String args []) {

        String [] strDict = {"a", "e", "i", "int", "inter", "interview", "kick", "kicker", "kickstart", "star","start",  "view" };
        String  s = "interviewkickstart"; //

        /*
        String [] strDict = {"cat", "cats", "and", "dog", "sand"};
        String  s = "catsanddog";
        */
                //List<String> list = new ArrayList<>();
      List list = (List) Arrays.asList(strDict);

       // list.add("pen");
       // boolean b  = wordBreak(s,DXDDXZSDGD MM,KMNNMB NBTFD34W4TYUO;P;//.KJUY GYGTGYGHUHHYGYGYT6565ILL.;[PLKJHUYYGTFT list);

        List<String> str =  wordBreak( s , new HashSet(list));
        String array [] = str.toArray(new String[str.size()]);

        System.out.println(s.length());
    }

    public static  boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }




    public static List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<String>();

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(sub);
                            pos[j]=list;
                        }else{
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<String>();
        }else{
            ArrayList<String> result = new ArrayList<String>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }


    public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }
    }
}
