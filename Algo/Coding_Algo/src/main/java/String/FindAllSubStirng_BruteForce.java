package String;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubStirng_BruteForce {

  public static void main(String args[]) {
    String str = "dinesh";

    List<String> subStringList = getAllSubstring(str);

    System.out.println("--Size---"+subStringList.size());

    for(String substring : subStringList) {
      System.out.println(substring);
    }
  }

  /**
   *  Substring is continous character String.
   *
   *  To get all substring time complexity is O(n^2)
   *
   *  For n character.
   *  1) Substring start with first character are n.
   *  2) Substring start with second character are n-1
   *  3) Substring start with third character is n-2
   *
   *  and so on...
   *
   *  Time Complexity is ---> (n, n-1, n-2, n-3, n-4 .....3,2,1) = ((n) (n-1)/2) = O(n^2)
   *
   *
   *
   * @return
   */
 public static List<String> getAllSubstring(String s) {
   List<String> allSubString = new ArrayList();

   //dinesh
   for(int i = 0; i < s.length(); i++) {
     for(int j = i; j <= s.length(); j++) {
       String str = s.substring(i,j);
       allSubString.add(str);
     }
   }
    return allSubString;
 }

}
