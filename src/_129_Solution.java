public class _129_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        return preOrderProcess(root, sum);
    }

    public int preOrderProcess(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return preOrderProcess(node.left, sum) + preOrderProcess(node.right, sum);
    }
}
