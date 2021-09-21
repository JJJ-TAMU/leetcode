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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int depth = depth(root);
        List<List<Integer>> ans = new ArrayList<>(depth + 1);
        if (root == null) { return ans; }
        for (int i = 0; i < depth + 1; i++) {
            ans.add(new ArrayList<>());
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curr.add(node.val);
                if (node.left != null) {queue.offer(node.left);}
                if (node.right != null) {queue.offer(node.right);}
            }
            ans.set(depth, curr);
            depth--;
        }
        return ans;
    }

    private static int depth(TreeNode root) {
        if (root == null) {     return -1;      }
        return 1 + Math.max(root.left, root.right);
    }

    private static int depth(TreeNode root) {
        if (root == null) { return -1;}
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();

        nodes.push(root);
        depths.push(0);

        int max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int depth = depths.pop();
            max = Math.max(max, depth);
            if (node.left != null) {
                nodes.push(node.left);
                depths.push(depth + 1);
            }
            if (node.right != null) {
                nodes.push(node.right);
                depths.push(depth + 1);
            }
        }
        return max;
    }
}