package Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Explaination and difference between Vertex and Edges.
 *
 * https://stackoverflow.com/questions/44831436/java-implementing-weighted-graph
 */
public class GraphAdjacencyList_Undirected_Weighted_Graph {

  public Map<Integer, NodE> graphWeighted = new HashMap<>();

  public NodE getNode(int label) {
    if(graphWeighted.containsKey(label)) {
      return graphWeighted.get(label);
    } else {
      NodE node = new NodE(label);
      graphWeighted.put(label, node);
      return node;
    }
  }

  public void addEdge(int source, int destination, int weight) {
      NodE s = getNode(source);
      NodE d = getNode(destination);
      s.getAdjancecyList().add(new Edge(destination, weight));
      d.getAdjancecyList().add(new Edge(source, weight));
  }

  public List<Edge> findAdjacent(int index) {
    NodE node = graphWeighted.get(index);
     return node.getAdjancecyList();
  }

  /**
   * Find whether vertices and start and end are connected.
   *
   * @return true if start and end are part of same edge else return false.
   *
   */

  public boolean isConnected(int source, int destination) {

      // Get Source Node
      NodE sourceNode = graphWeighted.get(source);

      // Get Destination Node
      //NodE destinationNode = graphWeighted.get(destination);

      // If A is connected to B. When B is in neighbour to A. Means it is in the List of neighbours of A.
     // If B is connected to A . When A is neighbour to A. Means it is in the list of neighbour of B
     // In case of undirected graph if A is connected to B then both are neighbour to each other.

     List<Edge> sourceList = sourceNode.getAdjancecyList();

     for(Edge edge : sourceList) {
       if(edge.getEndVertex() == destination) {
         return true;
       }
     }
     return false;
  }



  @Test
  public void testBuildWeightedGraph() {
    GraphAdjacencyList_Undirected_Weighted_Graph graphWeighted = new GraphAdjacencyList_Undirected_Weighted_Graph();
    graphWeighted.addEdge(1,2,5);
    graphWeighted.addEdge(1,4,6);
    graphWeighted.addEdge(1,5,10);
    graphWeighted.addEdge(2,3,1);
    graphWeighted.addEdge(2,5,2);
    graphWeighted.addEdge(2,6,7);
    graphWeighted.addEdge(3,6,8);
    graphWeighted.addEdge(4,5,3);
    graphWeighted.addEdge(5,6,4);

    List<Edge>  adjacentList = graphWeighted.findAdjacent(1);

    for(Edge edge : adjacentList) {
      System.out.println(edge.getEndVertex());
    }

    System.out.println(graphWeighted.isConnected(6,1));
  }
}


class Edge {
  private int endVertex;
  private int weigth;

  public Edge(int endVertex, int weight) {
    this.endVertex = endVertex;
    this.weigth = weight;
  }

  public int getEndVertex() {
    return endVertex;
  }

  public int getWeigth() {
    return weigth;
  }
}

class NodE {
  int label;
  List<Edge> adjancecyList;

  public NodE (int label) {
    this.label = label;
    adjancecyList = new ArrayList<Edge>();
  }

  public int getLabel() {
    return label;
  }

  public List<Edge> getAdjancecyList() {
    return adjancecyList;
  }
}