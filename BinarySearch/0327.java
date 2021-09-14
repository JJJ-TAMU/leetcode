class Node {
    private int key;
    private int val;
    private int size;
    private int height;
    private Node left, right;
    public Node(int key) {
        this.key = key; val = 1; size = 1; height = 1;
    }
}

class Tree {
    private Node root;

    public Tree() {}

    public void insert(int key) {   root = insert(root, key);   }
    private static Node insert(Node node, int key) {
        if (node == null) { return new Node(key);   }
        int cmp = Integer.compare(key, node.key);
        if (cmp < 0) {  node.left = insert(node.left, key); }
        else if (cmp > 0) { node.right = insert(node.right, key);   }
        else {  node.val++; }
        updateParams(node);
        return balance(node);
    }

    private static void updateParams(Node node) {
        node.size = node.val + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private static Node balance(Node node) {
        int diff = balanceFactor(node);
        // Case 1: left leaning
        if (diff > 1) {
            // Case 1.1 left right leaning
            if (balanceFactor(node.left) < 0) { node.left = rotateLeft(node.left);  }
            // Case 1.2 left left leaning
            node = rotateRight(node);
        } else if (diff < -1) {
            if (balanceFactor(node.right) > 0) {    node.right = rotateRight(node.right);   }
            node = rotateLeft(node);
        }
        return node;
    }

    private static Node rotateLeft(Node node) {
        Node r = node.right;
        node.right = r.left;
        r.left = node;
        updateParams(node);
        updateParams(r);
        return r;
    }

    private static int balanceFactor(Node node) {   return height(node.left) - height(node.right);  } 

    private static int size(Node node) {    return node == null ? 0 : node.size;    }
    private static int height(Node node) {  return node == null ? 0 : node.height;  }

    public int rank(int key) {}
}

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        
    }
}