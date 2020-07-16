public class _105_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode process(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preStart]) {
                root.left = process(preOrder, preStart + 1, i - inStart + preStart, inOrder, inStart, i - 1);
                root.right = process(preOrder, i - inStart + preStart + 1, preEnd, inOrder, i + 1, inEnd);
            }
        }
        return root;
    }
}
