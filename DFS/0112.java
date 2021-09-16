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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recursive(root, targetSum);       
    }

    private static boolean iterative(TreeNode node, int targetSum) {
        if (node == null) {     return false;   }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> sums = new ArrayDeque<>();
        nodes.push(node);
        sums.push(0);
        int sum;
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            sum = sums.pop() + node.val;
            if (isLeaf(node) && sum == targetSum) { return true; }
            if (node.left != null) {
                nodes.push(node.left);
                sums.push(sum);
            }
            if (node.right != null) {
                nodes.push(node.right);
                sums.push(sum);
            }
        }
        return false;
    }

    private static boolean recursive(TreeNode node, int targetSum) {
        if (node == null) {     return false;   }
        targetSum -= node.val;
        if (isLeaf(node)) { return targetSum == 0;  }
        return recursive(node.left, targetSum) || recursive(node.right, targetSum);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}