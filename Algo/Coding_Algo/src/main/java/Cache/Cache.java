package Cache;

/**
 *
 * https://www.youtube.com/watch?v=3ZfzYLnJXz4&index=6&list=PLQ9cQ3JqeqU9HbOKdU82FU_vkpboOGFFU
 *
 *
 * LRU cache implementation with Array.
 *
 *  void create(int capacity)
 *
 *  int get(int k)
 *  int set(int v)
 *
 *
 * 1) Adding fresh element in the begning.
 * 2) Eviction will happen from the last.
 * 3) Cache Get operation for Array implementation will be O(n).
 *     For finding the element in the array we need to traverse entire array.
 * 4) Cache set operation for Array implementation will be O(n). If element already exist traverse to that element.
 *    Moving all the element to right. Will be O(n) operation.
 *
 *  Time complexity for get operation implementation will be O(n).
 *
 *  Time complexity for set operation implementation will be O(n).
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache implemenation as Single linked list.
 *
 *  void create(int capacity)
 *
 *  int get(int k)
 *  int set(int v)
 *
 * 1) Adding fresh element as Node at the begnining of the list.
 * 2) Eviction will happen from the last.
 * 3) Get operation for Linked list will be O(n).
 *    Traversing all the elements or node.
 * 4) Deletion or the new element is same which is already existing in the list. Need to remove and put it
 *    as the first element you need to the previous element to connect it with the next element
 *
 *    2-->3 -->4--->5
 *
 *    Now 4 is coming again. Need to add the first element. Need to know previous of 4
 *
 *    4--->2--->3---->5
 *  5) Set operation will be O(n)
 *
 *  To remember the previous element that's why we need to go to DoublyLinkec List.
 *
 *   Only problem with Array and Linked list implementation is Search of the lement which os Order of (1).
 *
 *  ["LRUCache","get","put","get","put","put","get","get"]
    [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

 Output:
 [null,-1,null,-1,null,null,2,-1]

 Expected:
 [null,-1,null,-1,null,null,2,6]
 */

public class Cache {
  public static void main(String args[]) {
    LRUCache cache = new LRUCache(2);
    int x1  = cache.get(2);
    System.out.println("----x1--> "+x1); // -1
    cache.put(2, 6);

    int x2  = cache.get(1);
    System.out.println("----x2--> "+x2); // -1

    cache.put(1, 5);
    cache.put(1, 2);

    int x3  = cache.get(1);
    System.out.println("----x3--> "+x3); // 2

    int x4  = cache.get(2);
    System.out.println("----x4--> "+x4); // 6
  }
}

class LRUCache {
  Map<Integer, Integer> map;
  ArrayList<Integer> list;
  int capacity;

  public LRUCache(int capacity) {
    map = new HashMap();
    list = new ArrayList();
    this.capacity = capacity;
  }

  public int get(int key) {
    if(map.containsKey(new Integer(key))) {
      list.remove(new Integer(key));
      list.add(new Integer(key));
      return map.get(new Integer(key));
    }
    return -1;
  }


  public void put(int key, int value) {
    if(capacity >0 && map.size() == capacity ) {
      if(map.containsKey(new Integer(key))) {
        map.put(new Integer(key), new Integer(value));
        list.remove(new Integer(key));
        list.add(new Integer(key));
      } else {
        Integer x = list.get(0);
        list.remove(x);
        map.remove(x);
      }
    }

    if(!map.containsKey(new Integer(key))) {
      map.put(new Integer(key), new Integer(value));
      list.add(new Integer(key));
    } else {
      map.remove(new Integer(key));
      list.remove(new Integer(key));
      list.add(new Integer(key));
      map.put(new Integer(key), new Integer(value));
    }
  }
}

