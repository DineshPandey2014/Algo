/*

 1. Sorting Tips.

    Sort Array using : Arrays.sort(); // For sorting Arrays
    Sort List using : Collections.sort(); // For sorting list.

 2. Comparable VS Comparator

    Difference between Comparable and Comparator

    Comparable : compareTo() // Takes one object

    1. Default natural sorting order.
    2. Present in Java.lang package.
    3. Comparable interfaace contains only one method compareTo() method
    4. All wrapper classes and String class implements comparable interface
       Example : Integer, Double, Float, Long, String,

    Comparator : compare() // Takes two object

    1. Customized sorting order.
    2. Present in java.util package.
    3. Contains two methods a) compare() and b) equals method.
    4. Implements classes are
    Example : Collator, RuleBasedCollator

 3. How to iterate HashMap having key and Values

 for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    Integer key = entry.getKey();
    Integer value = entry.getValue();
    }


4. Creating empty priority queue. Min Heap Implementation
   PriorityQueue<Integer> pQueueMinHeap = new PriorityQueue<>();

   Creating empty priority queue. MAX Heap Implementation
   PriorityQueue<Integer> pQueueMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

  PollMethod  => pQueue.poll();
  PeekMethod  => pqueue.peek();
              => pQueue.isEmpty();
              => pQueue.add();

5.

  Binary Heap Construction :

  Binary Heap Construction : O (n)
  Polling                  : O(log(n)
  Peeking                  : O(1)
  Adding                   : O(log(n))


6. Two find which is maximum of two given values. Math.max();

7 Graph :

  1. BFS :  Always used BFS to find shortest distance without weight.
  2. Djkistra : Djkistra algorithm is used to find shortest distance with weight.


8. Algo how to create a graph as Adjacency list.

  a) Take a Map<Integer, Node> map
  b) addEdge(int source, int destination)  // It will add the edges to the graph. If graph is undirected graph will
     add source and destination together.
  c) getNode(int label) // It will return the node for source. If source is not present add the node to map. and list will be empty
  d) Graph for DFS and BFS will be creates similarly.

9. DFS Algo How it works uses Stack data structure based on recursion.
   https://www.youtube.com/watch?v=iaBEKo5sM7w

10: Binary Search Time Complexity :

   Worst Case : Log(n) => log of base 2
   How it is calculated: n + n/2 + n/4 .....1

   Let's say in K step we are able to reduce the search from n to 1

   n/2^k = 1   // Take log of both side

   k = log n  // Worst case time taken for comparison is log n


11: POSTFIX evaluation
    p-q => pq- =>
    For stack we evealuate from left to right
    operand 2 = q
    operand 1 =p
    Result After pop from stack => -p + q

    PREFIX evluation
    p-q => -pq
    For stack evaluation is done from righ to left
    1. push q first to Stack then
    2. push p to stack
    When operator comes say - pop it
    Result= p - q
 */

