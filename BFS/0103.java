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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) { return ans; }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        boolean front = true;
        while (!deque.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = deque.size();

            if (front) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    currLevel.add(node.val);
                    if (node.left  != null) {   deque.addLast(node.left);   }
                    if (node.right != null) {   deque.addLast(node.right);  }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeLast();
                    currLevel.add(node.val);
                    if (node.right != null) {   deque.addFirst(node.right); }
                    if (node.left  != null) {   deque.addFirst(node.left);  }
                }
            }

            front = !front;
            ans.add(currLevel);
        }
        return ans;
    }
}