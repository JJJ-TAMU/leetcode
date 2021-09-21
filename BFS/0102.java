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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return recursive(root);
    }

    private static List<List<Integer>> recursive(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        preorder(root, 0, ans);
        return  ans;
    }

    private static void preorder(TreeNode node, int depth, List<List<Integer>> ans) {
        if (node == null) { return; }
        if (depth == ans.size()) {
            List<Integer> curr = new ArrayList<>();
        }
        ans.get(depth).add(node.val);
        preorder(node.left, depth + 1, ans);
        preorder(node.right, depth + 1, ans);
    } 
    private static List<List<Integer>> iterative(TreeNode root) {
        // Initialize return list
        List<List<Integer>> ans = new ArrayList<>();

        // Boundary check: if root is null
        if (root == null) {     return ans;     }

        // Initialize queue
        Queue<TreeNode> queue = new ArrayDeque<>();

        // Put root into queue
        queue.offer(root);

        // Traverse each level
        while (!queue.isEmpty()) {
            List<Integer> currVals = new ArrayList<>();
            int size = queue.size();

            // Update current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currVals.add(node.val);
                if (node.left  != null) {    queue.offer(node.left);     }
                if (node.right != null) {    queue.offer(node.right);    }
            }

            // Add current level into ans
            ans.add(currVals);
        }
        return ans;
    }
}