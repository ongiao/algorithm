public class _110_Solution {
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
