//package Graphs;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Created by dpandey on 9/16/17.
// */
//public class GraphsAdjacencyList {
//    // Driver program to test above functions
//    public static void main(String args[])
//    {
//        // create the graph given in above figure
//        int V = 5;
//        Graph graph = new Graph(V);
//        graph.addEdge(graph, 0, 1);
//        graph.addEdge(graph, 0, 4);
//        graph.addEdge(graph, 1, 2);
//        graph.addEdge(graph, 1, 3);
//        graph.addEdge(graph, 1, 4);
//        graph.addEdge(graph, 2, 3);
//        graph.addEdge(graph, 3, 4);
//
//        // print the adjacency list representation of
//        // the above graph
//        graph.printGraph(graph);
//    }
//}
//
//
//// A user define class to represent a graph.
//// A graph is an array of adjacency lists.
//// Size of array will be V (number of vertices
//// in graph)
//class Graph {
//    int V;
//    List<List> adjListArray;
//
//    // constructor
//    Graph(int V)
//    {
//        this.V = V;
//
//        // define the size of array as
//        // number of vertices
//        adjListArray = new LinkedList<>();
//
//        // Create a new list for each vertex
//        // such that adjacent nodes can be stored
//        for(int i = 0; i < V ; i++){
//            adjListArray.add(new ArrayList<>());
//        }
//    }
//
//    // Adds an edge to an undirected graph
//    static void addEdge(Graph graph, int src, int dest)
//    {   /*
//     * If the graph is undirected graph.
//     * There will be two path. Source to destination and destination.
//     *
//     * If the graph is directed graph then there will be only one path
//     */
//        graph.adjListArray.get(src).add(dest);
//        graph.adjListArray.get(dest).add(src);
//        // Add an edge from src to dest.
//        //graph.adjListArray[src].addFirst(dest);
//
//        // Since graph is undirected, add an edge from dest
//        // to src also
//        // graph.adjListArray[dest].addFirst(src);
//    }
//
//    // A utility function to print the adjacency list
//    // representation of graph
//    static void printGraph(Graph graph)
//    {
//        for(int v = 0; v < graph.V; v++)
//        {
//            System.out.println("Adjacency list of vertex "+ v);
//            System.out.print("head");
//            List atVertex = graph.adjListArray.get(v);
//            System.out.println(atVertex);
//        }
//    }
//}
