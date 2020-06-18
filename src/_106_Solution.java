public class _106_Solution {
//    Given inorder and postorder traversal of a tree, construct the binary tree.
//
//            Note:
//    You may assume that duplicates do not exist in the tree.
//
//            For example, given
//
//    inorder = [9,3,15,20,7]
//    postorder = [9,15,7,20,3]
//    Return the following binary tree:
//
//            3
//           / \
//          9  20
//            /  \
//           15   7
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
