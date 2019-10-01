package Heap_Priority_Queue;


import java.util.*;

public class kClosest {

  public static void main (String args[]) {

    int[][] points = {{1, 3}, {-2, 2}, {-2, 4}};
//    int outPut [] [] = kClosest(points, 1);
//    System.out.println(outPut);
//  }

    Point [] input = { new Point(1, 3), new Point(-2, 2), new Point(-2, 4) };
    List<Point> outputList = getKClosetPoints(input, 1);
    System.out.println(outputList);
  }

  /**
   * Brute force.
   * Step 1: Find distance for all the points from origin which is (0,0)
   * Step 2: Sort them tine complexity will be O(nlog n)
   * Step 3: Find the distance of Kth shortest distance.
   * Step 4: Run another for loop find all the points whose distance is sless then or equal to Kth distance
   *         Copy them in Array
   *
   * @param points
   * @param K
   * @return
   */
  public static int[][] kClosest(int[][] points, int K) {
    int N = points.length;
    int[] dists = new int[N];
    for (int i = 0; i < N; ++i)
      dists[i] = dist(points[i]);
    Arrays.sort(dists);
    //Arrays.sort(dists);
    int distK = dists[K-1];

    int[][] ans = new int[K][2];
    int t = 0;
    for (int i = 0; i < N; ++i)
      if (dist(points[i]) <= distK)
        ans[t++] = points[i];
    return ans;
  }

  public static int dist(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }


  public static List<Point> getKClosetPoints(Point []  points, int k ) {
    int n = points.length;
    PriorityQueue<Point> pq = new PriorityQueue<>(new Point());

    for(int i = 0; i < n; i++) {
        pq.add(points[i]);
    }

    List<Point> result = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      result.add(pq.remove());
    }

    return result;
  }
}


class Point implements Comparator<Point> {
  int x;
  int y;

  Point() {}

  public Point(int x1, int y1) {
    this.x = x1;
    this.y = y1;
  }

  @Override
  public int compare(Point p1, Point p2) {
    return p1.x * p1.x - p2.y * p2.y;
  }

}