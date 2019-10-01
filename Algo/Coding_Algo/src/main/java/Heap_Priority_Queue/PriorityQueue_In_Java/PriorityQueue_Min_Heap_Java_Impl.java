package Heap_Priority_Queue.PriorityQueue_In_Java;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=9w_mXzP6ttE
 *
 * https://www.youtube.com/watch?v=1mm1I40cniQ
 *
 */
public class PriorityQueue_Min_Heap_Java_Impl {

  @Test
  public void testInteger() {
    PriorityQueue<Integer> pq = new PriorityQueue();
    addIntegerElementInPriorityQueue(pq);
    removeIntegerElementFromPQ(pq);
  }

  /**
   * It will add element in ascending order
   * @param pq
   */
 public  void addIntegerElementInPriorityQueue(PriorityQueue<Integer> pq) {
   pq.add(100);
   pq.add(10);
   pq.add(200);
   pq.add(40);
   pq.add(500);
  }


  public  void removeIntegerElementFromPQ(PriorityQueue<Integer> pq) {
      while(!pq.isEmpty()) {
       int output = pq.poll();
       System.out.println(output); // 10,40,100,200,500
      }
  }

  @Test
  public void testString() {
    PriorityQueue<String> pq = new PriorityQueue();
    addStringElementInPriorityQueue(pq);
    removeStringElementFromPQ(pq);
  }

  /**
   * It will add element in ascending order
   * @param pq
   */
  public  void addStringElementInPriorityQueue(PriorityQueue<String> pq) {
    pq.add("dinesh");
    pq.add("amit");
    pq.add("aviral");
    pq.add("divyanshi");
    pq.add("kanchu");
  }

  public void removeStringElementFromPQ(PriorityQueue<String> pq) {
    while(!pq.isEmpty()) {
      String output = pq.poll();
      System.out.println(output); // amit,aviral,dinesh,divyanshi,kanchu
    }
  }

  @Test
  public void testCharacter() {
    PriorityQueue<Character> pq = new PriorityQueue();
    addCharacterElementInPriorityQueue(pq);
    removeCharacterElementFromPQ(pq);
  }

  /**
   * It will add element in ascending order
   * @param pq
   */
  public  void addCharacterElementInPriorityQueue(PriorityQueue<Character> pq) {
    pq.add('d');
    pq.add('w');
    pq.add('a');
    pq.add('f');
    pq.add('b');
  }

  public void removeCharacterElementFromPQ(PriorityQueue<Character> pq) {
    while(!pq.isEmpty()) {
      Character output = pq.poll();
      System.out.println(output); // amit,aviral,dinesh,divyanshi,kanchu
    }
  }
}