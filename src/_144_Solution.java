import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenjunxing ON 2020-07-13 16:48.
 */
public class _144_Solution {
//    Given a binary tree, return the preorder traversal of its nodes' values.
//
//    Example:
//
//    Input: [1,null,2,3]
//            1
//             \
//             2
//            /
//           3
//
//    Output: [1,2,3]
//    Follow up: Recursive solution is trivial, could you do it iteratively?

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // non-recursive method
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return list;
    }
}
