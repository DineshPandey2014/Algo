package Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1

Algorithm:

Here we are not solving this problem that we solved for Shortest Word Distance. This will give us Time limit exceeded
exception. Because it can call shortest method multiple times. In that case it will iterate the array multiple times.
If array has million String. IT won't work.


 */
public class Shortest_Word_Distance_II {

  Map<String, List<Integer>> map = null;


  public Shortest_Word_Distance_II(String[] words) {
    map = new HashMap<String, List<Integer>>();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if(!map.containsKey(word)) {
        List<Integer> list = new ArrayList();
        list.add(i);
        this.map.put(word, list);
      } else {
        List<Integer> inputList =  map.get(word);
        inputList.add(i);
        this.map.put(word, inputList);
      }
    }
  }


  public int shortest(String word1, String word2) {
    // All the indexes are in sorted order. As we are looping the array. And keeping
    // the indexes in the list.
    List<Integer> listOne = map.get(word1);
    List<Integer> listTwo = map.get(word2);

    // Now we iterate the list. Taking two pointer sal loc1 pointing the listOne
    // and loc2 pointing the pointer to listTwo.
    // Take the difference between two pointer find the minimum difference.
    // Increment the counter

    int shortestDistance = Integer.MAX_VALUE;
    int loc1 = 0;
    int loc2 = 0;

    while(loc1 < listOne.size() && loc2< listTwo.size()) {
      int locOneIndex = listOne.get(loc1);
      int locTwoIndex = listTwo.get(loc2);
      shortestDistance = Math.min(shortestDistance, Math.abs(locOneIndex - locTwoIndex));

      if(locOneIndex < locTwoIndex) {
        // locOneIndex is lower we need to decrease the shortes distance.
        // So we increment locOneIndex;
        loc1++;
      } else {
        // locTwoIndex is lower we need to decrease the shortes distance.
        // So we increment locTwoIndex;
        loc2++;
      }
    }
    return shortestDistance;
  }

  /*

  Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
   */
  public static void main(String args[]) {
    String words [] = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "coding";
    String word2 = "practice";

    Shortest_Word_Distance_II shortestDistance = new Shortest_Word_Distance_II(words);
    int shotretDistance = shortestDistance.shortest(word1, word2);
    System.out.println(shotretDistance);
  }

}
