public class _108_Solution {
//    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
//    the two subtrees of every node never differ by more than 1.
//
//    Example:
//
//    Given the sorted array: [-10,-3,0,5,9],
//
//    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//            0
//           / \
//         -3   9
//         /   /
//       -10  5

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        if (num.length < 2) {
            return new TreeNode(num[0]);
        }
        return process(num, 0, num.length - 1);
    }

    public TreeNode process(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int k = end - start + 1;
        int mid;
        if (k % 2 == 0) {
            mid = start + (end - start) / 2 + 1;
        } else {
            mid = start + (end - start) / 2;
        }
        TreeNode root = new TreeNode(num[mid]);
        root.left = process(num, start, mid - 1);
        root.right = process(num, mid + 1, end);
        return root;
    }
}
