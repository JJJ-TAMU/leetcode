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
        return iterative(root, p, q);
    }

    private static TreeNode recursive(TreeNode root, TreeNode p, TreeNode q) {
        // Case 1: one is root
        if (root == p || root == q) {   return root;    }
        // Case 2: both left
        if (root.val > p.val && root.val > q.val) { return recursive(root.left, p, q);}
        // Case 3: both right
        if (root.val < p.val && root.val < q.val) { return recursive(root.right, p, q);}
        // Case 4: one left one right
        return root;
    }

    private static TreeNode iterative(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root == p || root == q) {   return root;    }
            else if (root.val > p.val && root.val > q.val) { root = root.left; }
            else if (root.val < p.val && root.val < q.val) { root = root.right;  }
            else {return root;}
        }
    }
}