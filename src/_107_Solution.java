import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_Solution {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode cur = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arr = new ArrayList<Integer>();

            while (size > 0) {
                cur = queue.poll();
                arr.add(cur.val);
                size--;

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            res.add(0, arr);
        }

        // Collections.reverse(res);
        return res;
    }
}
