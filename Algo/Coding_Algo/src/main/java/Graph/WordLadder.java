package Graph;

/**
 * Best solution
 *
 * https://algs4.cs.princeton.edu/41graph/WordLadder.java
 *
 * https://www.youtube.com/channel/UCRjaWhSn5QxelsND7x4k4Fg/videos
 */

import org.junit.Test;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
  Map<String, List<String>> graph = new HashMap();

  @Test
  public void testPathWordLadder() {
    List<String> list = new ArrayList<>();
    list.add("hit");
    list.add("hot");
    list.add("dot");
    list.add("dog");
    list.add("lot");
    list.add("log");
    list.add("cog");
    Map<String, List<String>>  wordList = getVertexChangeInOneChar(list);

    int pathSize = ladderLength("hit", "lot");
    System.out.println(pathSize);
  }
  public int ladderLength(String beginWord, String endWord) {

    Queue<String> queue = new LinkedList<>();
    Map<String, String> traverse = new HashMap<>();

    queue.add(beginWord);
    //String parent = null;
    boolean found = false;
    traverse.put(beginWord, null);
    String foundVertex = null;

    while(!queue.isEmpty()) {
      String parentVertex = queue.poll();

      List <String> neighbour = graph.get(parentVertex);
      for (String nighbourVertex : neighbour ) {

        if(traverse.containsKey(nighbourVertex)) {
          continue;
        }
        traverse.put(nighbourVertex, parentVertex);

        if(nighbourVertex.equalsIgnoreCase(endWord)) {
          foundVertex = nighbourVertex;
          found = true;
          break;
        }
        queue.add(nighbourVertex);
      }

      if(found) {
        break;
      }
    }

     List<String> path = new ArrayList();
     path.add(foundVertex);
     while(traverse.get(foundVertex) != null) {
       foundVertex = traverse.get(foundVertex);
       path.add(foundVertex);
     }
    return path.size();
  }



  Map<String, List<String>> getVertexChangeInOneChar(List<String> wordList) {
    for (String wordStart : wordList) {
      for (String wordTemp : wordList) {
        if(isNeighbour(wordStart, wordTemp)) {
          if(graph.containsKey(wordStart)) {
            List<String> list = graph.get(wordStart);
            list.add(wordTemp);
            graph.put(wordStart, list);
          } else {
            List<String> input = new ArrayList<>();
            input.add(wordTemp);
            graph.put(wordStart, input);
          }
        }
      }
    }
    return graph;
  }

  /**
   * Two String are
   */
  public boolean isNeighbour(String a, String b) {
    // If the length of two String is not equal then return false
    if(a.length() != b.length() || a.equals(b)) {
      return false;
    }
    int difference = 0;
    for (int i = 0; i < a.length(); i++) {
      if(a.charAt(i) != b.charAt(i)) {
        difference++;
      }
      if(difference > 1) {
        return false;
      }
    }

   // Object o = new Object();

    return true;
  }
}


