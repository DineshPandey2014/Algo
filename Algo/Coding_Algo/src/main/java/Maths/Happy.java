package Maths;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/happy-number/

https://www.youtube.com/watch?v=gW4hSbRoQoY

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class Happy {
  public boolean isHappy(int n) {

    Set<Integer> seen = new HashSet();

    while(n != 1) {
      int sum = 0;
      int current  = n;
      while(current != 0) {
        sum = sum + (current%10) * (current%10);
        current = current/10;
      }
      if(seen.contains(sum)) {
        return false;
      }
      seen.add(sum);
      n = sum;

    }

    return true;
  }
}
