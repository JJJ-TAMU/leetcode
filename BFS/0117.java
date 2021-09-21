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
        if (root == null) { return root;    }
        Queue<Node> queue = new ArrayDeque<>();

        Node cache = root;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    if (prev != null) {
                        prev.next = node.left;
                    }
                    prev = node.left;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (prev != null) {
                        prev.next = node.right;
                    }
                    prev = node.right;
                    queue.offer(node.right);
                }
            }
        }
        return cache;
    }

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