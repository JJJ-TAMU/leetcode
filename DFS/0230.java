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
    public int kthSmallest(TreeNode root, int k) {
        return iterative(root, k);
    }

    private static int recursive(TreeNode node, int k) {
        int[] visited = {k};
        return recursive(node, visited);
    }

    private static int recursive(TreeNode node, int[] k) {
        if (node == null) { return 0;   }
        int left = recursive(node.left, k);
        if (k[0] == 0) {   return left;    }
        if (--k[0] == 0) {  return node.val;    }
        return recursive(node.right, k);
    }

    private static int iterative(TreeNode node, int k) {
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.push(node);
        while (true) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            node = nodes.pop();
            if (--k == 0) { return node.val;    }
            node = node.right;
        }
    }
}