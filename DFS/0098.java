/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return iterative(root);
    }

    private static boolean iterative(TreeNode root) {
        if (root == null) {     return true;    }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer lo = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (lo != null && root.val <= lo) {     return false;   }
            lo = root.val;
            root = root.right;
        }
        return true;
    }

    private static boolean recursive(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer lo, Integer hi) {
        if (node == null) {     return true;    }
        int val = node.val;
        if ((lo != null && val <= lo) || (hi != null && val >= hi)) {   return false;   }
        return validate(node.left, lo, val) && validate(node.right, val, hi);
    }
}