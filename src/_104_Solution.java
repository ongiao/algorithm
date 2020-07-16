public class _104_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // use recursive
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return 1 + Math.max(leftH, rightH);
    }
}
