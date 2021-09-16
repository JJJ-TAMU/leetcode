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
    public TreeNode invertTree(TreeNode root) {
        return recursive(root);
    }

    private static TreeNode recursive(TreeNode node) {
        if (node == null) { return node;    }
        TreeNode left = node.left;
        node.left  = recursive(node.right);
        node.right = recursive(left);
        return node;
    }

    private static TreeNode iterative(TreeNode node) {
        if (node == null) { return node;    }
        TreeNode cache = node;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.push(node);
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left  != null) {    nodes.push(node.left);  }
            if (node.right != null) {    nodes.push(node.right); }
        }
        return cache;
    }
}