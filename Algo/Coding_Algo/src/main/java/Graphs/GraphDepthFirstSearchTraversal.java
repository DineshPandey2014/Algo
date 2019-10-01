package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dpandey on 9/18/17.
 */
public class GraphDepthFirstSearchTraversal {
    List<Integer> adjList [];
    int vertexCount;
    boolean visited [];

    GraphDepthFirstSearchTraversal(int vertex) {
        visited = new boolean[vertex];
        adjList = new ArrayList[vertex];
        this.vertexCount = vertex;

        for(int i=0; i<vertex; i++ ) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    void traverseDFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        Iterator<Integer> iter = adjList[vertex].iterator();
        while(iter.hasNext()) {
            int vertexVisited = iter.next();
            if(!visited[vertexVisited]) {
                traverseDFS(vertexVisited);
            }
        }
    }

    public static void main(String args[]) {
        GraphDepthFirstSearchTraversal dfs = new GraphDepthFirstSearchTraversal(7);
        dfs.addEdge(0,1);
        dfs.addEdge(0,3);
        dfs.addEdge(1,3);
        dfs.addEdge(1,2);
        dfs.addEdge(1,4);
        dfs.addEdge(2,4);
        dfs.addEdge(2,5);
        dfs.addEdge(5,6);
        dfs.addEdge(6,4);
        //dfs.addEdge(2,5);
        //dfs.addEdge(5,6);
        dfs.traverseDFS(0);
    }
}
