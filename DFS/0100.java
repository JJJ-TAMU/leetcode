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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return iterative(p, q);
    }

    private static boolean recursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {   return true;    }
        if (p == null || q == null) {   return false;   }
        return (p.val == q.val) && recursive(p.left, q.left) && recursive(p.right, q.right);
    }

    private static boolean iterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) {   return true;    }
        if (p == null || q == null) {   return false;   }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            p = stack.pop();
            q = stack.pop();
            if (p.val != q.val) {   return false;   }
            if (((p.left == null) != (q.left == null)) || ((p.right == null) != (q.right == null))) {   return false;   }
            if (p.left != null) {
                stack.push(p.left);
                stack.push(q.left);
            }
            if (p.right != null) {
                stack.push(p.right);
                stack.push(q.right);
            }
        }
        return true;
    }
}