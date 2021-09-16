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
    public int maxDepth(TreeNode root) {
        return recursive(root);
    }

    private static int recursive(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(recursive(root.left), recursive(root.right));
    }

    private static int iterative(TreeNode root) {
        if (root == null) {     return 0;   }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> ints = new ArrayDeque<>();
        nodes.push(root);
        ints.push(1);
        int max = 1;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int height = ints.pop();
            max = Math.max(max, height);
            if (node.left != null) {
                nodes.push(node.left);
                ints.push(height + 1);
            }
            if (node.right != null) {
                nodes.push(node.right);
                ints.push(height + 1);
            }
        }
        return max;
    }
}