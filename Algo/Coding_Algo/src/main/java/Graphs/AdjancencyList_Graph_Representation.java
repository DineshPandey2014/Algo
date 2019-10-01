package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



public class AdjancencyList_Graph_Representation {

  private static int vertex;
  private List<List> adjListArray;
  public AdjancencyList_Graph_Representation (int vertex) {
    this.vertex = vertex;
    adjListArray = new ArrayList<>(vertex);

    for (int i = 0; i < vertex; i++) {
      adjListArray.add(new ArrayList());
    }
  }


  public void addVertex(int start, int end) {
    adjListArray.get(start).add(end);
    adjListArray.get(end).add(start);
  }

  public static void main(String args[]) {
    AdjancencyList_Graph_Representation graph = new AdjancencyList_Graph_Representation(5);
    graph.addVertex(0, 1);
    graph.addVertex(0, 4);
    graph.addVertex(1, 2);
    graph.addVertex(1, 3);
    graph.addVertex(1, 4);
    graph.addVertex(2,3);
    graph.addVertex(3, 4);
    printGraph(graph);

  }

  // A utility function to print the adjacency list
  // representation of graph
  public static void printGraph(AdjancencyList_Graph_Representation graph)
  {
    for(int i = 0; i<vertex; i++) {
      System.out.println("Adjacency List vertex from " + i);
      List listVertex  = graph.adjListArray.get(i);
      System.out.println(listVertex);
    }
  }

}
