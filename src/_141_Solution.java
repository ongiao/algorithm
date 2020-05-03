/**
 * Created by chenjunxing ON 2020-05-03 17:51.
 */
public class _141_Solution {
//    Given a linked list, determine if it has a cycle in it.
//
//    To represent a cycle in the given linked list, we use an integer pos
//    which represents the position (0-indexed) in the linked list where tail connects to.
//    If pos is -1, then there is no cycle in the linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
