package Grokking_Pattern.Topological_Sort;

import java.util.*;

public class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    if(vertices <= 0) {
      return sortedOrder;
    }

    Map<Integer, Integer> inDegree = new HashMap<>(); // Count the incming edge with every vertex
    Map<Integer, List<Integer>> graph = new HashMap<>(); // B

    // Initalize the indegree anf graph
    for(int i = 0; i < vertices; i++) { // Indegree to child from parent
      inDegree.put(i , 0); // Vetex of child as key
      graph.put(i , new ArrayList()); // Vertex of parent as key. Value as array List of all child
    }

    // b. Build the graph
    for (int i = 0; i < edges.length; i++) {
      int child = edges[i][1];
      int parent = edges[i][0];
      // As we initalize the graph as Map With empty list.
      // Now we need to get the list with respective parent and add the child
      graph.get(parent).add(child); // put the child into it's parent's list

      // Increment the degree of incoming vertex.
      inDegree.put(child,  inDegree.get(child)+1);
    }

    Queue<Integer> queue = new LinkedList<>();
    //Find all sources i.e., all vertices with 0 in-degrees
    // Iterate the map to find all the vertex whose degree is 0
    for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
      if(entry.getValue() == 0) {
        queue.add(entry.getKey());
      }
    }

    while(!queue.isEmpty()) {
      int vertexWithZeroDegree = queue.poll();
      sortedOrder.add(vertexWithZeroDegree);
      List<Integer> children = graph.get(vertexWithZeroDegree);
      for (Integer vertexChild : children) {
        //int child = inDegree.get(vertexChild);
        inDegree.put(vertexChild, inDegree.get(vertexChild) - 1);
        if(inDegree.get(vertexChild) == 0) {
          queue.add(vertexChild);
        }
      }
    }
    if( sortedOrder.size() != vertices) {
      return new ArrayList<>();
    }

    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = TopologicalSort.sort(4,
            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
            new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
            new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}


