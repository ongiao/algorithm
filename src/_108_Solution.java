public class _108_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        if (num.length < 2) {
            return new TreeNode(num[0]);
        }
        return process(num, 0, num.length - 1);
    }

    public TreeNode process(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int k = end - start + 1;
        int mid;
        if (k % 2 == 0) {
            mid = start + (end - start) / 2 + 1;
        } else {
            mid = start + (end - start) / 2;
        }
        TreeNode root = new TreeNode(num[mid]);
        root.left = process(num, start, mid - 1);
        root.right = process(num, mid + 1, end);
        return root;
    }
}
