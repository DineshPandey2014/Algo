package Maths;

import org.junit.Test;

public class SquareRoot {

  @Test
  public void mySqrt() {
    int x = 10;
    int output = mySqrt(x);
    System.out.println(output);
  }


  public int mySqrt(int x) {
    if(x<=1)
      return x;

    int start = 1;
    int end = x/2; // Square root is always less the the half of the number.

    while(start<=end) {
      int mid = start + (end-start)/2;
      // mid * mid > x ---> mid > x/mid
      if(mid > x/mid) {
        end = mid-1;
      } else {
        start = mid+1;
      }
    }
    return end;
  }

//  public int findSqrt(int n) {
//    if(n == 0) {
//      return n;
//    }
//    int start = 1;
//    int end  = n;
//
//    while(true) {
//      int mid = start + (end - start)/2;
//      if(mid > n/mid) {
//          end = end -1;
//      } else {
//        if(mid +1 > n/(mid +1)) {
//          return mid;
//        }
//        start = mid + 1;
//      }
//
//    }
//
//  }

  /*
  int findSqrtBinarySearch(int x) {
    long start = 0;
    long end = x;

    while(start + 1 < end) {
      long mid = start + (end -start)/2;
      if(mid * mid == x) {
        return (int)mid;
      } else if(mid * mid > x) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if(end * end == x) {
      return (int)end;
    }
    return (int) start;
  }*/
}
