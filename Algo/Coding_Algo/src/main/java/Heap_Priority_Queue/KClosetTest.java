package Heap_Priority_Queue;


import java.util.Comparator;
import java.util.PriorityQueue;

class KClosetTest {

  public static void main(String args[]) {
    // [[3,3],[5,-1],[-2,4]]

    int [] [] x = new int [][] {{3,3}, {5,-1}, {-2,4}};
    int  K = 2;
    int [] [] output = kClosest(x, K);

  }

  public static int[][] kClosest(int[][] points, int K) {
    int result [] [] = new int [K] [2] ;

    PointOne point [] = new PointOne[points.length];

    for(int i = 0; i < points.length; i++) {
      int x = points[i][0];
      int y = points[i][1];
      PointOne p = new PointOne(x,y);
      point[i] = p;
    }

    PriorityQueue<PointOne> pq = new PriorityQueue(new PointOne());

    for(int i = 0; i < point.length; i++) {
      pq.add(point[i]);
    }


    for(int j = 0; j < K; j++ ) {
      PointOne out = pq.remove();
      int x [] [] = new int [1][2];
      x[0][0] = out.x;
      x[0][1]= out.y;
      result[j] = x[0];
    }
    return result;
  }


}

class PointOne implements Comparator<PointOne> {
  int x;
  int y;

  PointOne() {

  }

  public PointOne(int x1, int y1) {
    this.x = x1;
    this.y = y1;
  }

  @Override
  public int compare(PointOne p1, PointOne p2) {
    return p1.x * p1.x + p1.y * p1.y - p2.x * p2.x + p2.y * p2.y;
  }

}