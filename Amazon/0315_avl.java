class Solution {
    public List<Integer> countSmaller(int[] nums) {
        AVL tree = new AVL();
        int n = nums.length;
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }
        for (int i = n - 1; i >= 0; i--) {
            int m = tree.getNumSmaller(nums[i]);
            ans.set(i, m);
            tree.insert(nums[i]);
        }
        return ans;
    }
}

private class Node implements Comparable<Node> {
    private int key;        // key of the node
    private int value;      // num occurrence of the key
    private int size;       // size of the subtree rooted at the node
    private int height;     // height of the subtree
    private Node left, right;
    public Node(int key) {
        this.key = key; value = 1; size = 1; heigt = 1;
    }
    @Override
    public int compareTo(Node node) {   return Integer.compare(key, node.key);  }
}

private class AVL {
    // root of the tree
    private Node root;
    /* Constructor  */
    public AVL() {}

    // inserts the given key into the tree
    public void insert(int key) {   root = insert(root, key);   }
    // inserts the given key into the subtree
    private static Node insert(Node node, int key) {
        if (node == null) { return new Node(key);   }
        int cmp = Integer.compare(key, node.key);
        // go to the left subtree
        if (cmp < 0) {  node.left = insert(node.left, key); }
        // go to the right subtreee
        else if (cmp > 0) { node.right = insert(node.right, key);   }
        // current node
        else {
            node.value++;
        }
        updateParams(node);
        return balance(node);
    }

    public int getNumSmaller(int key) {     return getNumSmaller(root, key);    }

    private static int getNumSmaller(Node node, int key) {
        if (node == null) { return 0;   }
        int cmp = Integer.compare(key, node.key);
        if (cmp < 0) {  return getNumSmaller(node.left, key);   }
        else if (cmp > 0) { return getNumSmaller(node.right) + size(node.left) + node.val;  }
        else {  return size(node.left);    }
    }

    // balance the subtree and returns the new root of the subtree
    private static Node balance(Node node) {
        // difference between of the left subtree and right subtree
        int diff = balanceFactor(node);
        // Case 1: left side is heavy, i.e. diff > 1
        if (diff > 1) {
            // Case 1.1: LR leanning, make it LL leaning
            if (isLRLeaning(node.left)) {   node.left = rotateLeft(node.left);  }
            // Case 1.2: LL leanning;
            node = rotateRight(node);
        } else if (diff < -1) {
            // Case 2.1: RL leaning, make it RR leaning
            if (isLRLeaning(node.right)) {  node.right = rotateRight(node.right);   }
            // Case 2.2: RR leaning
            node = rotateLeft(node);
        }
        return node;
    }

    // 
    private static Node rotateLeft(Node node) {
        Node l = node.left;
        node.right = l.left;
        l.left = node;
        updateParams(node);
        updateParams(l);
        return l;
    }

    private static Node rotateRight(Node node) {
        Node r = node.right;
        node.left = r.left;
        r.right = node;
        updateParams(node);
        updateParams(r);
        return r;
    }
    // checks if subtree is LR leaning
    private static boolean isLRLeaning(Node node) { return balanceFactor(node.left) < 0;    }
    // checks if subtree is RL leaning
    private static boolean isRLLeaning(Node node) { return balanceFactor(node.right) > 0;   }
    // returns the difference between of the left subtree and right subtree
    private static int balanceFactor(Node node) {   return height(node.left) - height(node.right);  }

    // update corresponding parameters in the node
    private static void updateParams(Node node) {
        node.size = node.val + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // returns the size of subtree rooted at the given node
    private static int size(Node node) {    return node == null ? 0 : node.size;    }

    // returns the height of the subtree
    private static int height(Node node) {  return node == null ? 0 : node.height;  }
}