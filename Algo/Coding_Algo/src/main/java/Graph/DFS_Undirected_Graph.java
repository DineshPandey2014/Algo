package Graph;

import org.junit.Test;

import java.util.*;

public class DFS_Undirected_Graph {

  public Map<String, NodeDFS> mapGraphDFS = new HashMap<>();

  public NodeDFS getNode(String label) {
      if(mapGraphDFS.containsKey(label)) {
        return mapGraphDFS.get(label);
      } else {
        NodeDFS node = new NodeDFS(label);
        mapGraphDFS.put(label, node);
        return node;
      }
  }

  public void addNeighbour(String source, String destination) {
    NodeDFS s = getNode(source);
    NodeDFS d = getNode(destination);
    s.getNeighbours().add(d);
    d.getNeighbours().add(s);
  }

  public boolean pathExists(Map<String , NodeDFS> graph, String source, String destination) {
      Set<NodeDFS> visited = new HashSet<>();
      return pathExists(graph.get(source), graph.get(destination), visited);
  }
  // Recursive call to find is there is a path from source to destinaton
  public boolean pathExists(NodeDFS source, NodeDFS destination, Set<NodeDFS> visited) {

    // Exit Condition
    if(source.getLabel().equalsIgnoreCase(destination.getLabel())) {
      return true;
    }

    // Exit Condition
    if(visited.contains(source)) {
      return false;
    }

    visited.add(source);

    for (NodeDFS node : source.getNeighbours()) {
      if(pathExists(node, destination, visited)) {
        return true;
      }

    }
    return false;
  }

  @Test
  public void testIsPathExist() {
    DFS_Undirected_Graph dfsUndirectedGrap = new DFS_Undirected_Graph();
    dfsUndirectedGrap.addNeighbour("A" , "B");
    dfsUndirectedGrap.addNeighbour("C", "F");
    dfsUndirectedGrap.addNeighbour("A", "F");
    System.out.println(dfsUndirectedGrap.pathExists(dfsUndirectedGrap.mapGraphDFS, "A", "F"));
  }
}

class NodeDFS {
  private String label;
  private List<NodeDFS> neighbours;

  public NodeDFS(String label) {
    this.label = label;
    this.neighbours = new ArrayList<>();
  }

  public String getLabel() {
    return label;
  }

  public List<NodeDFS> getNeighbours() {
    return neighbours;
  }
}
