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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {     return ans;     }

        List<Integer> candidate = new ArrayList<>();

        backtrack(ans, candidate, root, targetSum);

        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> candidate, TreeNode root, int sum) {
        candidate.add(root.val);
        sum -= root.val;
        if (isLeaf(root)) {
            if (sum == 0) {
                ans.add(new ArrayList<>(candidate));
            }
            candidate.remove(candidate.size() - 1);
            return;
        }
        if (root.left != null) {
            backtrack(ans, candidate, root.left, sum);
        }
        if (root.right != null) {
            backtrack(ans, candidate, root.right, sum);
        }
        candidate.remove(candidate.size() - 1);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}