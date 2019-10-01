package Graph;


import org.junit.Test;

import java.util.*;

/**
 * Graph Represenation Of Undirected Graph Using AdjacencyList
 *
 * https://github.com/megha14/Lets-Code-Them-Up/blob/master/Algorithms/Graph/GraphAdjacencyList.java
 *
 * http://www.letscodethemup.com/graph-search-breadth-first-search/
 */
public class GraphAdjacencyList_Undirected_Graph {
  public Map<Integer, Node> graphMap = new HashMap<>();


  /**
   *
   *  Fetch node from HashMap if it is there. Other wise
   *  Create a node and returns it.
   *
   *
   *
   * @param label
   * @return
   */
  public Node getNode(int label) {
      if(graphMap.containsKey(label)) {
        return graphMap.get(label);
      } else {
        Node node = new Node(label);
        graphMap.put(label, node);
        return node;
      }
  }

  /**
   * Add edge between source and destination.
   * As this is undirected graph.
   * We need to add the edge in both direction.
   * 1) Source to Destination
   * 2) Destination to Source.
   *
   * @param source start index
   * @param destination end index
   * @return No return value.
   */
  public void addEdge(int source, int destination) {
      // Get nodes corresponding to source and destination vertices.
      Node sourceNode = getNode(source);
      Node destinationNode = getNode(destination);
      // Add node to adjacency list.
      sourceNode.getNeighbourList().add(destinationNode);
      destinationNode.getNeighbourList().add(sourceNode);
  }

  /**
   * Find and return all the adjacent vertices of the given vertex.
   * @param vertex
   * @return
   */
  public List<Node> findAdjacent(int vertex) {
    Node node = getNode(vertex);
    return node.getNeighbourList();
  }

  /**
   * Find whether vertices start and end are connected.
   * @param source start index
   * @param destination end index
   * @return true if start and end are part of same edge else return false;
   */
  public boolean isConnected(int source, int destination) {
      Node s = graphMap.get(source);
      Node d = graphMap.get(destination);

      if(s.getNeighbourList().contains(d) || d.getNeighbourList().contains(s)) {
        return true;
      }
      return  false;
  }

  @Test
  public void testGraph() {
    GraphAdjacencyList_Undirected_Graph graph = new GraphAdjacencyList_Undirected_Graph();
    graph.addEdge(1, 2);
    graph.addEdge(1, 4);
    graph.addEdge(1, 5);
    //graph.addEdge(2, 1);
    graph.addEdge(2, 3);
    graph.addEdge(2, 5);
    graph.addEdge(2, 6);
    //graph.addEdge(3, 2);
    graph.addEdge(3, 6);
    //graph.addEdge(4, 1);
    graph.addEdge(4, 5);
    //graph.addEdge(5, 1);
    //graph.addEdge(5, 2);
    //graph.addEdge(5, 4);
    graph.addEdge(5, 6);
    //graph.addEdge(6, 2);
    //graph.addEdge(6, 3);

//    for () {
//
//    }

    Node node = graph.graphMap.get(2);
    List<Node> neighbours = node.getNeighbourList();

    for(Node nodeInsideTheList : neighbours) {
        System.out.println(nodeInsideTheList.label);
    }

    System.out.println(graph.isConnected(6,2));

  }
}

class Node {
   int label;
   List<Node> neighbourList;
   public Node (int label) {
     this.label = label;
     neighbourList = new LinkedList<Node>();
   }

   public int getLabel() {
     return label;
   }

   public List<Node> getNeighbourList() {
     return neighbourList;
   }
}