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
    public List<Integer> rightSideView(TreeNode root) {
        return iterative(root);
    }

    private static List<Integer> iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {     return ans;     }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

    private static List<Integer> recursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursive(root, 0, ans);
        return ans;
    }

    private static void recursive(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) { return; }
        if (depth == ans.size()) {  ans.add(0); }
        ans.set(depth, node.val);
        recursive(node.left, depth + 1, ans);
        recursive(node.right, depth + 1, ans);
    }
 }