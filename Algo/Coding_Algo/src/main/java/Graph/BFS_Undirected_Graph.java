package Graph;

import org.junit.Test;

import java.util.*;

/**
 * Undirected graphs
 *
 * To find shortest distance without any weight. We will use BFS
 *
 * To find shortest distance with weight. Use djkistra algorithm.
 */
public class BFS_Undirected_Graph {
  public Map<String, NodeBFS> neighbourMap = new HashMap<>();

  public NodeBFS getNode(String label) {
      if(neighbourMap.containsKey(label)) {
        return neighbourMap.get(label);
      } else {
        NodeBFS node = new NodeBFS(label);
        neighbourMap.put(label, node);
        return node;
      }
  }

  public void addNeighbour(String source, String destination) {
      NodeBFS s = getNode(source);
      NodeBFS d = getNode(destination);
      s.getNeighboursList().add(d);
      d.getNeighboursList().add(s);
  }

  public boolean isPath(Map<String, NodeBFS> graph, String source, String destination) {
      // Queue to store the children of the node.
      Queue<NodeBFS> queue = new LinkedList<>();

      // Set of node visited.
      Set<NodeBFS> visited = new HashSet<>();

      NodeBFS node = graph.get(source);
      queue.add(node);

      while(!queue.isEmpty()) {
        NodeBFS neighbourBFS = queue.poll();

        if(neighbourBFS.getLabel().equalsIgnoreCase(destination)) {
          return true;
        }

        if(visited.contains(neighbourBFS)) {
          continue;
        }
        visited.add(neighbourBFS);

        //Add all the neighbours to queue.
        for (NodeBFS neighbourNode : neighbourBFS.getNeighboursList()) {
          queue.add(neighbourNode);
        }
      }
      return false;
  }

  @Test
  public void findPath() {
    BFS_Undirected_Graph bfsUndirectedGrap = new BFS_Undirected_Graph();
    bfsUndirectedGrap.addNeighbour("A" , "B");
    bfsUndirectedGrap.addNeighbour("A" , "E");
    bfsUndirectedGrap.addNeighbour("B" , "C");
    bfsUndirectedGrap.addNeighbour("B" , "F");
    bfsUndirectedGrap.addNeighbour("C" , "G");
    bfsUndirectedGrap.addNeighbour("C" , "D");
    bfsUndirectedGrap.addNeighbour("E" , "F");
    bfsUndirectedGrap.addNeighbour("F" , "G");
    bfsUndirectedGrap.addNeighbour("G" , "H");
    bfsUndirectedGrap.addNeighbour("D" , "H");

    // Find path exist from A to H.
    System.out.println(isPath(bfsUndirectedGrap.neighbourMap, "B", "E"));
  }
}

class NodeBFS {
  private String label;
  private List<NodeBFS> neighboursList;

  public NodeBFS(String label) {
    this.label = label;
    this.neighboursList = new LinkedList<NodeBFS>();
  }

  public List<NodeBFS> getNeighboursList() {
    return neighboursList;
  }

  public String getLabel() {
    return label;
  }
}