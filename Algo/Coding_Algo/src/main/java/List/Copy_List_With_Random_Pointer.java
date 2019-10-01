package List;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_With_Random_Pointer {
  public Node copyRandomList(Node head) {
    // Take HashMap approach.
    Map<Node, Node> map = new HashMap<>();

    Node curr = head;

    while (curr != null) {
      map.put(curr, new Node(curr.val, null, null));
      curr = curr.next;
    }

    curr = head;
    while (curr != null) {
      map.get(curr).next = map.get(curr.next);
      map.get(curr).random = map.get(curr.random);
      curr = curr.next;
    }
    return map.get(head);
  }

  class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  }
}



//     public Node copyRandomList(Node head) {
//         if(head == null) {
//             return head;
//         }

//         Node curr = head;
//         // Crearting the clone node and attaching in the front of original node.
//         // Original List --> 1-->2-->3--->4-->Null
//         //               --> 1-->1-->2-->2-->3-->3-->4--->4-->Null
//         while(curr != null) {
//             Node temp = new Node(curr.val);
//             temp.next = curr.next;
//             curr.next = temp;
//             // As we are cloning original node. We need to jum twice for next. First next will be
//             // the cloned one and the second one will be original node.
//             curr = curr.next.next;
//         }

//         // Assign random pointer to clone list.
//         // Reset the pointer.
//         curr = head;
//         while(curr != null) {
//             // Pointing to first cloned node.
//             curr.next.random = curr.random.next;
//             // Point to secod original node
//             curr = curr.next.next;
//         }

//         Node copy = head.next;
//         curr = head;

//         while(curr.next != null) {
//             curr.next = curr.next.next;
//         }
//         return copy;
//     }