package Arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection_Of_Two_Arrays {
  /*
    1. Naive Approach: By taking two Hash Set.
     Frist set to hold all the elements of first array.
     Second set will hold the common elements of second array and first set.

    2. Better Solution:  Two pointer approach. Using sort
       Algo :1.  Arrays.sort(nums1)
                 Arrays.sort(nums2)
             2. Take two pointer i and j less then the length of the two array
             3. Compare each array index if both are equal increment both. Add the common
             element to Set.
             4. If first element in the array is less then the other element array increment
             first counter say i
             5 Else increment count of j
             6. Exit if one of the counter is bigger then the length of the array

 */

  @Test
  public void testIntersection() {
   int [] nums1 = {1,2,2,1};
    int [] nums2 = {2,2};
    int [] result = intersection(nums1, nums2); //2

    for(int x : result) {
      System.out.println(x);
    }
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int i = 0;
    int j = 0;

    Set<Integer> result = new HashSet();

    while(i < nums1.length && j < nums2.length) {
      if(nums1[i] == nums2[j]) {
        if(!result.contains(nums1[i])) {
          result.add(nums1[i]);
        }
        i++;
        j++;
      } else if (nums1[i]  < nums2[j] ){
        i++;
      } else if(nums1[i]  > nums2[j]) {
        j++;
      }

    }

    int l = 0;
    int [] output = new int [result.size()];

    Iterator<Integer> e = result.iterator();

    while(e.hasNext()) {
      int data = e.next();
      output[l] = data;
      l++;

    }

    return output;
  }
}
