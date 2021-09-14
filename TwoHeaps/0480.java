class Tree {
    private Node root;

    private static class Node {
        private int key;
        private int val;
        private int size;
        private int height;
        private Node left, right;
        public Node(int key) { 
            this.key = key; val = 1; size = 1; height = 1;
        }
    }

    public void insert(int key) {   root = insert(root, key);   }
    
    public void delete(int key) {   root = delete(root, key);   }

    public int getKthSmallest(int k) {  return getKthSmallest(root, k); }

    private static Node insert(Node node, int key) {
        if (node == null) { return new Node(key);   }
        int cmp = Integer.compare(key, node.key);
        if (cmp < 0)         {  node.left  = insert(node.left, key);    }
        else if (cmp > 0)    {  node.right = insert(node.right, key);   } 
        else                 {  node.val++;                             }
        updateParams(node);
        return balance(node);
    }

    private static Node delete(Node node, int key) {
        int cmp = Integer.compare(key, node.key);
        if (cmp < 0)        { node.left = delete(node.left, key);   }
        else if (cmp > 0)   { node.right = delete(node.right, key); }
        else {
            if (-- node.val == 0) {
                if (node.left == null || node.right == null) {
                    return node.left == null ? node.right : node.left;
                } else {
                    Node predecessor = min(node.right);
                    predecessor.right = deleteMin(node.right);
                    predecessor.left = node.left;
                    node = predecessor;
                }
            }
        }
        updateParams(node);
        return balance(node);
    }

    private static int getKthSmallest(Node node, int k) {
        int leftSize = size(node.left);
        if (k <= leftSize) {    return getKthSmallest(node.left, k);    }
        k -= leftSize;
        if (k <= node.val) {    return node.key;    }
        k -= node.val;
        return getKthSmallest(node.right, k);
    }

    private static Node min(Node node) {
        while (node.left != null) { node = node.left;   }
        return node;
    }

    private static Node deleteMin(Node node) {
        if (node.left == null) {    return node.right;  }
        node.left = deleteMin(node.left);
        updateParams(node);
        return balance(node);
    }

    // Returns the size of the subtree rooted at the given node
    private static int size(Node node) {    return node == null ? 0 : node.size;    }

    // Returns the height of the subtree rooted at the given node
    private static int height(Node node) {  return node == null ? 0 : node.height;  }

    // Update size and height of the subtree rooted at the given node
    private static void updateParams(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
        node.size = node.val + size(node.left) + size(node.right);
    }

    // Balance the subtree and returns the new root of the subtree
    private static Node balance(Node node) {
        int diff = balanceFactor(node);
        // Case 1: left leanning
        if (diff > 1) {
            // Case 1.1: LR leaning, make it LL leaning
            if (balanceFactor(node.left) < 0) { node.left = rotateLeft(node.left);  }
            // Case 1.2: LL leaning
            node = rotateRight(node);
        } 
        // Case 2: right leaning
        else if (diff < -1) {
            // Case 2.1: RL leaning, make it RR leaning
            if (balanceFactor(node.right) > 0) { node.right = rotateRight(node.right);} 
            // Case 2.2: RR leaning
            node = rotateLeft(node);
        }
        return node;
    }

    // Returns the difference of heights between the left subtree and right subtree
    private static int balanceFactor(Node node) {   return height(node.left) - height(node.right);  }

    // Rotates the given node and makes it become its right child's left child
    private static Node rotateLeft(Node node) {
        Node r = node.right;
        node.right = r.left;
        r.left = node;
        updateParams(node);
        updateParams(r);
        return r;
    }

    // Rotates the given node and makes it become its left child's right child
    private static Node rotateRight(Node node) {
        Node l = node.left;
        node.left = l.right;
        l.right = node;
        updateParams(node);
        updateParams(l);
        return l;
    }

}
class MedianFinder {
    private int k;
    private int[] window;
    private int size;
    private int m;
    private Tree tree;
    public MedianFinder(int k) {
        tree = new Tree();
        this.k = k; window = new int[k]; size = 0; m = (k + 1) / 2;
    }

    public void insert(int val) {
        int old = window[size % k];
        window[size++ % k] = val;
        if (size > k) {
            if (old == val) {   return; }
            tree.delete(old);
        }
        tree.insert(val);
    }

    public double median() {
        double median = tree.getKthSmallest(m);
        if (k % 2 == 0) {
            median = (median + tree.getKthSmallest(m + 1)) / 2;
        }
        return median;
    }
}

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder mf = new MedianFinder(k);

        int n = nums.length;
        double[] medians = new double[n - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int j = i - k + 1;
            mf.insert(nums[i]);
            if (j >= 0) {
                medians[j] = mf.median();
            }
        }
        return medians;
    }
}