package Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_Adjacency_List_Directed_Graph {

  public Map<Integer, NodeDirectedGraph> graphDirected = new HashMap();

  public void addEdge(int source, int destination) {
    NodeDirectedGraph sourceNode = getNode(source);
    sourceNode.getAdjacencyList().add(new DirectedEdge(destination));
  }

 public  List<DirectedEdge> findAdjacent(int label) {
   NodeDirectedGraph node =  graphDirected.get(label);
   return node.getAdjacencyList();
  }

   private NodeDirectedGraph getNode(int source) {
     if (graphDirected.containsKey(source)) {
       return graphDirected.get(source);
     } else {
       NodeDirectedGraph node = new NodeDirectedGraph(source);
       graphDirected.put(source, node);
       return node;
     }
   }

   public boolean isConnected(int source, int destination) {
     NodeDirectedGraph sourceNode = graphDirected.get(source);
     List<DirectedEdge>  EdgeList = sourceNode.getAdjacencyList();

     for (DirectedEdge edge : EdgeList) {
      if(edge.getEndVertex() == destination) {
        return true;
      }
     }
     return false;
   }


   public void printGraph() {
    for (Map.Entry<Integer, NodeDirectedGraph> graph : graphDirected.entrySet()) {
      StringBuffer strBuf = new StringBuffer();

      int key = graph.getKey();

      strBuf.append(key).append("===>");

      NodeDirectedGraph nodeDirectedGraph = graph.getValue();
      List<DirectedEdge> edge = nodeDirectedGraph.getAdjacencyList();
      // Get all the neighbours of key

      for (DirectedEdge directedEdge : edge) {
        strBuf.append(directedEdge.getEndVertex()).append("===>");
      }

    System.out.println(strBuf.toString());
    }

   }



  @Test
  public void testBuildWeightedGraph() {
    Graph_Adjacency_List_Directed_Graph graph = new Graph_Adjacency_List_Directed_Graph();
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    graph.addEdge(3, 0);
    graph.printGraph();

  }

}


class NodeDirectedGraph {
  int label;
  List<DirectedEdge> adjacencyList;

  public NodeDirectedGraph(int label) {
    this.label = label;
    adjacencyList = new ArrayList<>();
  }

  public int getLabel() {
    return label;
  }

  public List<DirectedEdge> getAdjacencyList() {
    return adjacencyList;
  }
}

class DirectedEdge {
  private int endVertex;

  public DirectedEdge(int endVertex) {
    this.endVertex = endVertex;
  }

  public int getEndVertex() {
    return endVertex;
  }
}


