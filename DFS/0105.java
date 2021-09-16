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
    private Map<Integer, Integer> position;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // first, build index from value->position in inorder list
        position = buildIndex(inorder);       
        int lo = 0, hi = preorder.length - 1;

        return buildTree(preorder, inorder, lo, lo, hi, hi);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int lp, int li, int hp, int hi) {
        if (lp > hp) {  return null;    }
        TreeNode root = new TreeNode(preorder[lp]);
        int pos = position.get(preorder[lp]);
        int leftSize = pos - li;
        int rightSize = hi - pos;

        TreeNode left  = buildTree(preorder, inorder, lp + 1, li, lp + leftSize, pos - 1);
        TreeNode right = buildTree(preorder, inorder, lp + leftSize + 1, pos + 1, hp, hi);
        root.left  = left;
        root.right = right; 
        return root;
    }

    private static Map<Integer, Integer> buildIndex(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }
} 