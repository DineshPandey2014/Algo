package Arrays;


import java.util.*;

/**
 * https://www.youtube.com/watch?v=ySTQCRya6B0&t=496s
 *
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z
 * where different letters represent different tasks. Tasks could be done without original order.
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks, there must
 be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.



 Example:

 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.


 Note:

 The number of tasks is in the range [1, 10000].
 The integer n is in the range [0, 100].

 *
 */
public class TaskScheduler {

  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();

    // Store each character
    for(char c : tasks) {
      if(!map.containsKey(c)) {
        // Add as frequency of one
        map.put(c, 1);
      } else {
        int count = map.get(c);
        // incerement the frequency
        map.put(c, count+1);
      }
    }
    // Holds all the count of the Characters. Returned as max count
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    maxHeap.addAll(map.values());

    int cycles = 0;
     // A,A,A,A,B,B
    while(!maxHeap.isEmpty()) {
        // Here we will keep the count after we executed the task.
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i <=n; i++) {
          if(!maxHeap.isEmpty()) {
            // Remove the element A from the map
            temp.add(maxHeap.poll());
          }
        }

        for (int i : temp) {
              // Decrement the count of A
              --i;
              if(i > 0) { // If still i > 0 it means that task still needs to run.
                maxHeap.add(i);
              }
        }

        if(maxHeap.isEmpty() ) {
          cycles = cycles + temp.size();
        } else {
          cycles = cycles + n + 1;
        }
    }
      return cycles;
  }

}
