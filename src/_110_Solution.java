public class _110_Solution {
//    Given a binary tree, determine if it is height-balanced.
//
//            For this problem, a height-balanced binary tree is defined as:
//
//    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

//    Example 1:
//    Given the following tree [3,9,20,null,null,15,7]:
//
//            3
//           / \
//          9  20
//            /  \
//          15   7
//    Return true.
//
//    Example 2:
//    Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//            1
//           / \
//          2   2
//         / \
//        3   3
//       / \
//      4   4

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ReturnData {
        int height;
        boolean isB;

        public ReturnData(int height, boolean isB) {
            this.height = height;
            this.isB = isB;
        }
    }
    public boolean isBalanced(TreeNode root) {
        ReturnData res = process(root);
        return res.isB;
    }

    public ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, true);
        }
        ReturnData leftData = process(root.left);
        if (!leftData.isB) {
            return new ReturnData(0, false);
        }
        ReturnData rightData = process(root.right);
        if (!rightData.isB) {
            return new ReturnData(0, false);
        }
        if (Math.abs(leftData.height - rightData.height) > 1) {
            return new ReturnData(0, false);
        }
        return new ReturnData(1 + Math.max(leftData.height, rightData.height), true);
    }
}
