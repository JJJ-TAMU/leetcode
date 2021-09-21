/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node first = root;
        while (first != null) {
            first = connectNextLevel(first);
        }
        return root;
    }

    private static Node connectNextLevel(Node first) {
        Node prev = null;
        Node currFirst = null;
        while (first != null) {
            if (first.left != null) {
                if (prev != null) {
                    prev.next = first.left;
                }
                prev = first.left;
                if (currFirst == null) {
                    currFirst = prev;
                }
            }
            if (first.right != null) {
                if (prev != null) {
                    prev.next = first.right;
                }
                prev = first.right;
                if (currFirst == null) {
                    currFirst = prev;
                }
            }
            first = first.next;
        }
        return currFirst;
    }
}