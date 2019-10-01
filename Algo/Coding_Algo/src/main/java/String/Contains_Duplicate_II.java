package String;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_II {
  /**
   * Example [1,0,1, 1]
   * K = 1
   *
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      /**
       * If map contains the key but the difference between indexes doesn't match
       * It will over ride with the new value and with new index.
       * As we need to find K which is At most
       */
      if(map.containsKey(nums[i]) && ( i - map.get(nums[i]) <=k)) {
        return true;
      } else {
        map.put(nums[i], i);
      }
    }
    return false;
  }
}
