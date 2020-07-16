public class _101_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root, root);
    }

    public boolean process(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        }
        return node1.val == node2.val && process(node1.left, node2.right) && process(node1.right, node2.left);
    }
}
