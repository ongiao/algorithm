import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> lists = new ArrayList<Integer>();
            int size = queue.size();

            // TreeNode curNode = queue.pop();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                lists.add(curNode.val);

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            results.add(lists);
        }
        return results;
    }
}
