import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjunxing ON 2020-05-03 16:51.
 */
public class _138_Solution {
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
