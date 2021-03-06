package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/friend-circles/

There are N students in a class. Some of them are friends, while some are not.
Their friendship is transitive in nature. For example, if A is a direct friend of B,
and B is a direct friend of C, then A is an indirect friend of C.
And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
then the ith and jth students are direct friends with each other, otherwise not. And you have to output
the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 */
public class FriendsCircle {

  public static void main (String args[] ){

    int input [][] = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 2}
    };

    int countCircle = findCircleNum(input);
    System.out.println(countCircle);
  }

  public static int findCircleNum(int[][] M) {
    int[] visited = new int[M.length];
    int count = 0;
    Queue< Integer > queue = new LinkedList< >();
    for (int i = 0; i < M.length; i++) {
      if (visited[i] == 0) {
        queue.add(i);
        while (!queue.isEmpty()) {
          int s = queue.remove();
          visited[s] = 1;
          for (int j = 0; j < M.length; j++) {
            if (M[s][j] == 1 && visited[j] == 0)
              queue.add(j);
          }
        }
        count++;
      }
    }
    return count;
  }

}
