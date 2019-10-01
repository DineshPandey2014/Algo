package Graph;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/discuss/58775/My-Java-BFS-solution
 *
 * https://www.youtube.com/watch?v=pCvUGQ4l1-8
 *
 */
public class CourseSchedule_BFS {


         /*
         Algo :

         1. First initalized the map with all vertex. Having neighbours as empty list
         2. Initalized the degree for all vertex here vertex is numOfCourses
         3. Populate the graph map with parents and their child or neighbour using prerequisites relationships.
         4. Populate the indegree map with child as key and the count incremented using prerequisites relationships. Here might be we will have some courses whose indegree is zero. or

       Example A--->B---->C
         A indegree 0
         B indegree 1
         C indegree 1

         5. Now populate the queue iterate indegree map and find the count of those vertex whoose indegree
         is zero. Add those vertex to Queue.

         6. Now iterate the queue. Get the node and find all the List<Node> neighbours to this node.
         7. Add the node of queue to List of node which is result whose indegree is zero
         8. Now when we iterate the node neighbours then we need to decrement indegree of each mode in
         the indegree map and simultenaously we need to check the indegrree of each node if it zero
         then add in the queue.

         // How to check if all the courses are taken as per the prequestie requirement.
         9. Size of list must be equals to numCourse. If they are equal return true else return false.
        */



  @Test
  public void testCanFinish() {
    int [] [] input = {{0,1},{0,2}, {1,3}, {2,3}};
    boolean result = isCourseSchedulePossible(4, input);
    System.out.println(result); //true
  }


  private boolean isCourseSchedulePossible(int numCourses, int[][] prerequisites) {

    // Child as key and Value as count
    Map<Integer, Integer> inDegree = new HashMap<>();

    // Parent as key and child as values
    Map<Integer, List<Integer>> graph = new HashMap<>();

    // Initalize the graph and Indegree map
    // Initalized the map. Here the courses starts from 0 to n-1;
    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new ArrayList<>());
      inDegree.put(i, 0);
    }

    // Now populate the indegree of all the Vertex and Map
    for (int i = 0; i < prerequisites.length; i++) {
      int parent = prerequisites[i][0];
      int child = prerequisites[i][1];
      graph.get(parent).add(child);
      inDegree.put(child ,inDegree.get(child) + 1);
    }

    // Poll all the vertex whose indegree is zero.
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      int vertex = entry.getKey();
      if(entry.getValue() == 0) {
        queue.add(vertex);
      }
    }

    List<Integer> result = new ArrayList<>();

    while(!queue.isEmpty()) {
      int vertex  = queue.poll();
      // Now we need to get all his childs and decrement the indegree
      List<Integer> children = graph.get(vertex);
      result.add(vertex);
      for (Integer child : children) {
        inDegree.put(child, inDegree.get(child) - 1);
        if(inDegree.get(child) == 0) {
          queue.add(child);
        }
      }
    }

    return result.size() == numCourses;

  }

//  // N is num of courses
//  //
//  public boolean canFinish(int numCourses, int[][] prerequisites) {
//    Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
//    int[] indegree = new int[numCourses];
//    Queue<Integer> queue = new LinkedList<Integer>();
//    int count = numCourses;
//
//    for (int i = 0; i < numCourses; i++) {
//      map.put(i, new ArrayList<Integer>());
//    }
//
//    for (int i = 0; i < prerequisites.length; i++) {
//      map.get(prerequisites[i][0]).add(prerequisites[i][1]);
//      indegree[prerequisites[i][1]]++;
//    }
//
//    for (int i = 0; i < numCourses; i++) {
//      if (indegree[i] == 0) {
//        queue.offer(i);
//      }
//    }
//
//    while (!queue.isEmpty()) {
//      int current = queue.poll();
//      for (int i : map.get(current)) {
//        if (--indegree[i] == 0) {
//          queue.offer(i);
//        }
//      }
//      count--;
//    }
//    return count == 0;
//  }

}
