import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenjunxing ON 2020-07-13 17:01.
 */
public class _145_Solution {
    // non-recursive methood
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
            stack2.push(cur);

            if (cur.left != null) {
                stack1.push(cur.left);
            }

            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }

        return list;
    }
}
