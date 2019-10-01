//package Graphs;
//
//
//import java.util.*;
//
///**
// * https://www.youtube.com/watch?v=ab51mA4ewBg
// *
// * Created by dpandey on 9/16/17.
// *
// * ArrayList:
// * 1) Best choice if our frequent operation is retrieval.
// * 2) ArrayList is worst choice if our frequent operation is insertion and deletion.
// * 3) Underlying data structure for ArrayList is resizable or growable.
// * 4) ArrayList implements RandomAccess interface.
// * 5) ArrayList class can act a list only because it implements List interface.
// *
// * LinkedList:
// * 1) It is the best choice if our frequent operation is insertion and deletion.
// * 2) Linedlist is the worst choice if our frequent operation is retreival operation.
// * 3) Underlying data structures is Double Linked List.
// * 4) Linked List doesn't implement RandomAccess Interface.
// * 5) Linked list class can act as list and queue both because it implements List and Dequeu interface.
// *
// * Breath first search traversal algorithm.
// */
//public class GraphBreathFirstSearch {
//    private static int vertex;
//
//    private static List<Integer> adjList[];
//
//   public  GraphBreathFirstSearch() {
//
//    }
//
//   public GraphBreathFirstSearch(int vertex) {
//        adjList = new ArrayList[vertex];
//        this.vertex = vertex;
//        for(int i = 0; i<vertex; i++) {
//            adjList[i] = new ArrayList<>();
//        }
//    }
//
//    void addEdge(int vertex, int neighbour) {
//        adjList[vertex].add(neighbour);
//    }
//
// static  void   BreadthFirstTraversal(int rootNode) {
//       // Mark all vertices as not visited as false. By default.
//       boolean visited [] = new boolean[vertex];
//
//       // Create queue for BFS
//       Queue<Integer> queue = new LinkedList<Integer>();
//
//       //Mark the current node as visited and enqueue it.
//       visited[rootNode] = true;
//       queue.add(rootNode);
//
//       while(queue.size() != 0) {
//           // Dequeue a vertex from queue and print it.
//           int vertex = queue.poll();
//           System.out.print(vertex + " ");
//           /**
//            * Get all the adjacent vertices of the dequed vertex say s.
//            * If adjacent has not been visited, then mark it visited and enque it.
//            *
//            */
//           Iterator<Integer> i = adjList[vertex].listIterator();
//           while(i.hasNext()) {
//                int n = i.next();
//               if(!visited[n]) {
//                    visited[n] = true;
//                    queue.add(n);
//               }
//           }
//       }
//
//   }
//
//
//    public static void main(String args[]) {
//        GraphBreathFirstSearch gfs = new GraphBreathFirstSearch(4);
//        gfs.addEdge(0,1);
//        gfs.addEdge(0, 2);
//        gfs.addEdge(1,2);
//        gfs.addEdge(2,0);
//        gfs.addEdge(2,3);
//        gfs.addEdge(3,3);
//
//        System.out.println("Following are the breadth first traversal from vertex 2");
//        BreadthFirstTraversal(0);
//    }
//}
