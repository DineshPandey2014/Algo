package Graph;

import org.junit.Test;

public class Shortest_Word_Distance {
  /*
  https://leetcode.com/problems/shortest-word-distance/


     Algorithm : We have array of words. We need to find the shortest distance between two words.
     Brute force solution is using two for loops.

     Brute Force : O(n2)
     1. First for loop find the matching first word and it's index. Iterate the array and find the
     Second matching word. Take the difference of index and see if it is minimum index or not.
     Update if it is minimum.

     One Pass Algo : O(n)
     1. Here we will have two pointer index. Update each pointer when we find the words and take the
     difference of the index. If it is minimum from the prior index update it.
    */

  @Test
  public void testShortestDistance() {
    /*

    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    Input: word1 = “coding”, word2 = “practice”
    Output: 3

    Input: word1 = "makes", word2 = "coding"
    Output: 1

    */
    // 3
    String [] input = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "coding";
    String word2 = "practice";
    int shortestDistance = shortestDistance(input, word1, word2);
    System.out.println(shortestDistance);

  }

   // One Pass algorithm.
  public int shortestDistance(String[] words, String word1, String word2) {
      if(words == null || words.length == 0 || word1 == null || word2 == null) {
        return -1;
      }

      int shortestDistance = Integer.MAX_VALUE;

     int indexOne = -1;
     int indexTw0 = -1;

     for (int i = 0; i < words.length; i++ ) {
       String incomingWord = words[i];
       if(incomingWord.equals(word1)) {
         indexOne = i; //0
       }

       if(incomingWord.equals(word2)) {
         indexTw0 = i;
       }

       int temp = Math.abs(indexOne - indexTw0);

       if(shortestDistance > temp && (indexOne != -1 && indexTw0!= -1)) {
         shortestDistance = temp;
       }
     }
    return shortestDistance;
  }

  // Two pass Brute force : Time COmplexity will O(n2)
  public int shortestDistance_BruteForce(String[] words, String word1, String word2) {
    int shortestDistance = Integer.MAX_VALUE;

    for (int i = 0; i < words.length; i++) {
      String incomingWordOne = words[i];
      // Hold the index of word1 first matching position
      if(incomingWordOne.equals(word1)) {
        // In this inner loop we will find the index of second word starting from index 0
        for (int j = 0; j < words.length; j++) {
          String incomingWordTwo = words[j];
          if(incomingWordTwo.equals(word2)) {
            // When we have index of two words take the difference of there indexes.
            // Update if it is minimum.
            shortestDistance = Math.min(shortestDistance, Math.abs(i-j));
          }
        }
      }

    }
    return shortestDistance;
  }
}
