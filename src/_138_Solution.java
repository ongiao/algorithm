import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjunxing ON 2020-05-03 16:51.
 */
public class _138_Solution {
//    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//    Return a deep copy of the list.
//
//    The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//    val: an integer representing Node.val
//    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> mapping = new HashMap<Node, Node>();
        Node cur = head;

        while (cur != null) {
            mapping.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            mapping.get(cur).next = mapping.get(cur.next);
            mapping.get(cur).random = mapping.get(cur.random);
            cur = cur.next;
        }

        return mapping.get(head);
    }
}
