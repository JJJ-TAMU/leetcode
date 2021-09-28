class MKAverage {
    private static class Tree {
        private static class Node {
            private int key;
            private int val;
            private int sum;
            private int size;
            private int height;
            private Node left, right;
            public Node(int key) {
                this.key = key; val = 1; sum = key; size = 1; height = 1;
            }
        }
        /* Root of the tree */
        private Node root;

        /* Constructor of the class */
        public Tree() {}

        /* Inserts a key into the tree */
        public void insert(int key) {   root = insert(root, key);   }

        /* Deletes a key from the tree */
        public void delete(int key) {   root = delete(root, key);   }

        /* Inserts a key into the subtree rooted at the given node */
        private static Node insert(Node node, int key) {
            if (node == null) {     return new Node(key);       }
            int cmp = Integer.compare(key, node.key);
            if (cmp < 0)        {  node.left  = insert(node.left, key);     }
            else if (cmp > 0)   {  node.right = insert(node.right, key);    }
            else                {  node.val++;                              }
            updateParams(node);
            return node;
        }

        /* Deletes a key from the subtree rooted at the given node */ 
        private static Node delete(Node node, int key) {
            if (node == null) {     return null;    }
            int cmp = Integer.compare(key, node.key);
            if (cmp < 0) {  node.left = delete(node.left, key); }
            else if (cmp > 0) { node.right = delete(node.right, key);   }
            else {
                node.val--;
            }
            updateParams(node);
            return node;
        }

        /* Returns the sum of all keys in the tree */
        public int sum() {  return sum(root);   }

        /* Returns the size of the tree */
        public int size() { return size(root);  }

        /* Returns the sum of the smallest k keys int the tree */
        public int getKthSmallestSum(int k) {  return getKthSmallestSum(root, k); }

        /* Returns the sum of the largest k keys int the tree */
        public int getKthLargestSum(int k) {  return getKthLargestSum(root, k); }

        /* Returns the sum of the smallest k keys in the subtree */
        private static int getKthSmallestSum(Node node, int k) {
            int lSize = size(node.left);
            if (k <= lSize) {   return getKthSmallestSum(node.left, k);    }
            k -= lSize;
            int sum = sum(node.left);
            if (k <= node.val) {
                return sum + k * node.key;
            }
            k -= node.val;
            sum += node.val * node.key;
            return sum + getKthSmallestSum(node.right, k);
        }

        /* Returns the sum of the largest k keys in the subtree */
        private static int getKthLargestSum(Node node, int k) {
            int rSize = size(node.right);
            if (k <= rSize) {   return getKthLargestSum(node.right, k);    }
            k -= rSize;
            int sum = sum(node.right);
            if (k <= node.val) {
                return sum + k * node.key;
            }
            k -= node.val;
            sum += node.val * node.key;
            return sum + getKthLargestSum(node.left, k);
        }

        /* Update the paramters of the subtree rooted at the given node */
        private static void updateParams(Node node) {
            node.sum = node.key * node.val + sum(node.left) + sum(node.right);
            node.size = node.val + size(node.left) + size(node.right);  
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }

        /* Returns the sum of all nodes in the subtree */
        private static int sum(Node node) { return node == null ? 0 : node.sum; }

        /* Returns the number of keys in the subtree */
        private static int size(Node node) { return node == null ? 0 : node.size;   }
        /* Returns the height of the subtree rooted at the given node */
        private static int height(Node node) {  return node == null ? 0 : node.height;  }


    }

    private Tree tree;
    private int m;
    private int k;
    private int[] window;
    private int size;
    private int total;

    public MKAverage(int m, int k) {
        tree = new Tree();
        this.m = m;
        this.k = k;
        total = m - 2 * k;
        window = new int[m];
    }
    
    public void addElement(int num) {
        int old = window[size % m];
        window[size++ % m] = num;
        if (size > m) {
            if (old == num) {   return; }
            tree.delete(old);
        }
        tree.insert(num);
    }
    
    public int calculateMKAverage() {
        if (size < m) { return -1;  }
        int sum = tree.sum();
        int rest = tree.getKthSmallestSum(k) + tree.getKthLargestSum(k);
        return (sum - rest) / total;
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */