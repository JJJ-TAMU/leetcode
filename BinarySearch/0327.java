class Tree {
    private static class Node {
        private long key;
        private long val;
        private long size;
        private long height;
        private Node left, right;
        public Node(long key) {
            this.key = key; val = 1; size = 1; height = 1;
        }
    }
    private Node root;

    public Tree() {}

    public void insert(long key) {   root = insert(root, key);   }
    private static Node insert(Node node, long key) {
        if (node == null) { return new Node(key);   }
        long cmp = Long.compare(key, node.key);
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
        long diff = balanceFactor(node);
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

    private static Node rotateRight(Node node) {
        Node l = node.left;
        node.left = l.right;
        l.right = node;
        updateParams(node);
        updateParams(l);
        return l;
    }
    private static long balanceFactor(Node node) {   return height(node.left) - height(node.right);  } 

    private static long size(Node node) {    return node == null ? 0 : node.size;    }
    private static long height(Node node) {  return node == null ? 0 : node.height;  }

    public long rank(long key) {
        return rank(root, key);
    }

    private static long rank(Node node, long key) {
        if (node == null) { return 0;   }
        long cmp = Long.compare(key, node.key);
        if (cmp < 0) {  return rank(node.left, key);    }
        else if (cmp > 0) { return size(node.left) + node.val + rank(node.right, key);  }
        else {  return size(node.left);   }
    }
}

class Solution {
    private Tree tree;
    public int countRangeSum(int[] nums, int lower, int upper) {
        tree = new Tree();
        tree.insert(0);
        long prefixSum = 0;
        int counter = 0;
        for (long num : nums) {
            prefixSum += num;
            long lo = prefixSum - upper;
            long hi = prefixSum - lower;
            long r1 = tree.rank(lo);
            long r2 = tree.rank(hi + 1);
            counter += r2 - r1;
            tree.insert(prefixSum);
        }
        return counter;
    }
}