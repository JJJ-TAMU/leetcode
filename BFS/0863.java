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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        // Corner case: root is null
        if (root == null) {     return ans;     }

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        annotateParents(parents, root);

        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        visited.add(target);

        while (k-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode parent = parents.get(node);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
                if (left != null && visited.add(left)) {
                    queue.offer(left);
                }
                if (right != null && visited.add(right)) {
                    queue.offer(right);
                }
            }
        }
        for (TreeNode node : queue) {
            ans.add(node.val);
        }
        return ans;
    }

    private static void annotateParents(Map<TreeNode, TreeNode> parents, TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        parents.put(root, null);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (parent.left != null) {
                parents.put(parent.left, parent);
                queue.offer(parent.left);
            }
            if (parent.right != null) {
                parents.put(parent.right, parent);
                queue.offer(parent.right);
            }
        }
    }
}