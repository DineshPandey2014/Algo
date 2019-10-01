package Tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=nxHBg7hm0rs
 *
 *
 */
class TreeNodeDuplicate {
   int val;
   TreeNodeDuplicate left;
   TreeNodeDuplicate right;
   TreeNodeDuplicate(int x) { val = x; }
  }

  /*
         1
       / \
      2   3
     /   / \
    4   2   4
       /
      4

   Input --->  [1,2,3,4,null,2,4,null,null,4]
   OutPut---> [[4],[2,4]]

   */
public class Find_Duplicate_Subtrees {

  public List<TreeNode> findDuplicateSubtrees(TreeNodeDuplicate root) {
    List<TreeNode> list = new LinkedList();
    Map<String, Integer> map = new HashMap<>();
    duplicatSubTreePostOrder(root, map, list);
    return list;
  }


  private String duplicatSubTreePostOrder(TreeNodeDuplicate root,Map map, List list) {
    if(root == null) {
      return "#";
    }

    String left = duplicatSubTreePostOrder(root.left, map, list);
    String right = duplicatSubTreePostOrder(root.right, map, list);
    String key = left + "," + right + "," + root.val;
    if(!map.containsKey(key)) {
      map.put(key, 1);
    } else {
      // Now here we will get the duplicate. We need to store the duplicate Node to List once.
      // Means if there two or more sub tree are duplicate then put only once to map
      int count = (int) map.get(key);
      if(count == 1) {
        // Add to the list only once when the count is 2.
        list.add(key);
      }
      map.put(key, count +1);
    }

    return key;
  }

}
