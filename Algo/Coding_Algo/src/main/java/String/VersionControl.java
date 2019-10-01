package String;

/**
 * Leet Code : 278
 * Version control
 *
 * Using Binary Search techinque. To reduce the search path.
 *
 * We need to find the first bad version. As we are reducing the path left and right will concide.
 * We will return.
 *
 */
public class VersionControl {

  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    int mid = 0;

    while (left < right) {
      mid =  left + (right -left)/2;
      // Returns boolean

      /*
      if(isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid +1;
      }
      */

    }
    //Both left and right will concide to the first bad version.
    return left;
  }
}
