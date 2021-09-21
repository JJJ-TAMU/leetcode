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
    public List<Double> averageOfLevels(TreeNode root) {
        return recursive(root);
    }

    private List<Double> recursive(TreeNode root) {
        List<Double> sums = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        recursive(root, 0, sums, sizes);
        for (int i = 0; i < sums.size(); i++) {
            sums.set(i, sums.get(i) / sizes.get(i));
        }
        return sums;
    }

    private static void recursive(TreeNode root, int depth, List<Double> sums, List<Integer> sizes) {
        if (root == null) {     return;     }
        if (depth == sums.size()) {
            sums.add(0.0); sizes.add(0);
        }
        sums.set(depth, sums.get(depth) + root.val);
        sizes.set(depth, sizes.get(depth) + 1);
        recursive(root.left, depth + 1, sums, sizes);
        recursive(root.right, depth + 1, sums, sizes);
    }

    private static List<Double> iterative(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {     return ans;     }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }
}