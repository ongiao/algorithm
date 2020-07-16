import java.util.*;

public class _103_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }

        // use a variable to control the direction of traverse
        boolean isFromRTL = false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> lists = new ArrayList<Integer>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                lists.add(curNode.val);

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
            }
            if (isFromRTL) {
                results.add(lists);
            }
            else {
                Collections.reverse(lists);
                results.add(lists);
            }

            isFromRTL = !isFromRTL;
        }
        return results;
    }
}
