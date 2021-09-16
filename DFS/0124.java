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
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];       
    }

    private static int maxPathSum(TreeNode node, int[] max) {
        if (node == null) {     return 0;   }
        int left = maxPathSum(node.left, max);
        int right = maxPathSum(node.right, max);
        int sum = left + right + node.val;
        max[0] = Math.max(max[0], sum);
        return Math.max(0, node.val + Math.max(left, right));
    }
}