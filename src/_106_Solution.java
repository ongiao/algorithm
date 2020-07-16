public class _106_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return process(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode process(int[] inOrder, int startIn, int endIn, int[] postorder, int startPost, int endPost) {
        if (startIn > endIn || startPost > endPost) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[endPost]);
        for (int i = startIn; i <= endIn; i++) {
            if (inOrder[i] == postorder[endPost]) {
                root.left = process(inOrder, startIn, i - 1, postorder, startPost, startPost + i - startIn - 1);
                root.right = process(inOrder, i + 1, endIn, postorder, i - startIn + startPost, endPost - 1);
            }
        }
        return root;
    }
}
