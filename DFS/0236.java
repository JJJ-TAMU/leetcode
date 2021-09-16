/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursive(root, p, q);
    }

    private static TreeNode recursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {   return root;    }
        TreeNode left = recursive(root.left, p, q);
        TreeNode right = recursive(root.right, p, q);
        if (left != null && right != null) {    return root;    }
        return left == null ? right : left;
    }

    private static TreeNode iterative(TreeNode root, TreeNode p, TreeNode q) {
        
    }
}