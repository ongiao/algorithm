public class _109_Solution {
//    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the
    // two subtrees of every node never differ by more than 1.
//
//    Example:
//
//    Given the sorted linked list: [-10,-3,0,5,9],
//
//    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//            0
//           / \
//        -3   9
//        /   /
//      -10  5

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return process(head,null);
    }

    public TreeNode process(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = process(head, slow);
        root.right = process(slow.next, tail);
        return root;
    }
}
