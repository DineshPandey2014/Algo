package Graph;

//https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 Example 1:

 Input: 2, [[1,0]]
 Output: [0,1]
 Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 course 0. So the correct course order is [0,1] .
 Example 2:

 Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 Output: [0,1,2,3] or [0,2,1,3]
 Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
public class Course_Schedue_Two {

  public int[] findOrder(int numCourses, int[][] prerequisites) {

    Map<Integer, List<Integer>> mapGraph = new HashMap<>();
    Map<Integer, Integer> indegree = new HashMap<>();

        /*
         Algo :

         1. First initalized the mapGraph with all vertex. Having neighbours as empty list
         2. Initalized the degree for all vertex here vertex is numOfCourses
         3. Populate the graph map with parents and their child or neighbour using prerequisites relationships.
         4. Populate the indegree map with child as key and the count incremented using prerequisites relationships. Here might be we will have some courses whose indegree is zero. or

       Example A--->B---->C
         A indegree 0
         B indegree 1
         C indegree 1

         5. Now populate the queue iterate indegree mapGraph and find the count of those vertex whoose indegree
         is zero. Add those vertex to Queue.

         6. Now iterate the queue. Get the node and find all the List<Node> neighbours to this node.
         7. Add the node of queue to List of node which is result whose indegree is zero
         8. Now when we iterate the node neighbours then we need to decrement indegree of each mode in
         the indegree mapGraph and simultenaously we need to check the indegrree of each node if it zero
         then add in the queue.

         // How to check if all the courses are taken as per the prequestie requirement.
         9. Size of list must be equals to numCourse. If they are equal return true else return false.
        */

    // Initalized the mapGraph. Here the courses starts from 0 to n-1;
    // Initalize the indegree
    for(int i = 0; i < numCourses; i++) {
      // Default for neighbour will be empty list.
      mapGraph.put(i, new ArrayList<>());
      // initallized indegree for all the courses as zero
      indegree.put(i, 0);
    }

    // Populate the graph and indgree map.
    for (int i = 0; i < prerequisites.length; i++) {
      int parent = prerequisites[i][0];
      int child =  prerequisites[i][1];
      // Adding neighbour of parent to list which are child
      mapGraph.get(parent).add(child);
      // Incrementing the indegree count of child. Initally it is zero then it will be one
      indegree.put(child, indegree.get(child) + 1);
    }

    Queue<Integer> queue = new LinkedList<>();

    // Populate the queue with indegree 0
    // Iterate indgree map. Find the vertex or parent whose value is zero
    for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
      int child = entry.getKey();
      int degree = entry.getValue();
      if(degree == 0) {
        queue.add(child);
      }
    }
        /*
         6. Now iterate the queue. Get the node and find all the List<Node> neighbours to this node.
         7. Add the node of queue to List of node which is result whose indegree is zero
         8. Now when we iterate the node neighbours then we need to decrement indegree of each mode in
         the indegree mapGraph and simultenaously we need to check the indegrree of each node if it zero
         then add in the queue.
        */

    // To get the order out we need to store the result in Stack
        /* Example :

          A ---> B --->C
          B---->D

          # Graph
          A---> [B]
          B --->[C, D]

          #In degree
          B --> 2
          A --->0
          C----> 1

          It means To complere Course A we need to finish B. To finish B we need to finish C and D first.

          Order will be any one [C, D, B, A] or [D, C, B, A]

        */

    Stack<Integer> result = new Stack();

    while (!queue.isEmpty()) {
      int parent = queue.poll();
      result.add(parent);

      // Decrement indegree to all its neighbour
      for( Integer child : mapGraph.get(parent)) {
        indegree.put(child, indegree.get(child) - 1);
        // Check for this node if indegree is zero add to queue
        if(indegree.get(child) == 0) {
          queue.add(child);
        }
      }
    }

    if(result.size() == numCourses) {
      int output [] = new int [numCourses];
      for (int j = 0; j < numCourses; j++) {
        output[j] = result.pop();
      }
      return output;
    } else {
      // Empty array if not able to finish. Array need to initalize with 0
      return  new int [0];
    }
  }
}
