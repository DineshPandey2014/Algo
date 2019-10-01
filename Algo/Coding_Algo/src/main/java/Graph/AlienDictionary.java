package Graph;

import org.junit.Test;

import java.util.*;

public class AlienDictionary {

  @Test
  public void findAlienDictionaryOrder() {
    String [] input = {"wrt","wrf","er","ett","rftt"};
    String output = findOrder(input);
    System.out.println(output);
  }

  private String findOrder(String[] words) {
    Map<Character, Integer> inDegree = new HashMap<>();
    Map<Character, List<Character>> graph = new HashMap<>();

    // First initalize these two maps
    for (String word : words) {
      for(Character charInput : word.toCharArray()) {
        inDegree.putIfAbsent(charInput, 0);
        graph.putIfAbsent(charInput, new ArrayList<Character>());
      }
    }

    // Find the indegree for each child from it's parent.
    // Here we will comare two words with neighbour

    for(int i = 1; i < words.length; i++) {
      String parent = words[i-1];
      String child = words[i];
      // ac
      // ade
      // c(parent) -> d (child)
      for(int j = 0; j < Math.min(parent.length(), child.length()); j++) {
        Character parentChar = parent.charAt(j);
        Character childChar = child.charAt(j);
        if(parentChar != childChar) {
          graph.get(parentChar).add(childChar);
          inDegree.put(childChar, inDegree.get(childChar) + 1);
          break;
        }
      }
    }

    Queue<Character> queue = new LinkedList<>();

    // Now In the queue we will add all the child whose incoming degree is zero
    for(Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
      if(entry.getValue() == 0) {
        queue.add(entry.getKey());
      }
    }

    StringBuilder strBuilder = new StringBuilder();

    // Iterate the queue Find the child whose Indgree is zero.
    // And then find all it's neighbour and decrement the degree of all the vertex and then check
    // If any of it's neighbour is whise degree is zeror. If yes then add to Queue
    while(!queue.isEmpty()) {
      Character vertex = queue.poll();
      strBuilder.append(vertex);
      List<Character> list = graph.get(vertex);
      for (Character childNeighbour : list) {
        inDegree.put(childNeighbour, inDegree.get(childNeighbour) -1);
        if(inDegree.get(childNeighbour) == 0) {
          queue.add(childNeighbour);
        }
      }
    }

    String result = strBuilder.toString();

    if(result.length() == inDegree.size()) {
      return result;
    }

    return "";
  }
}
