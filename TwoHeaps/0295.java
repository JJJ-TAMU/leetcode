class MedianFinder {
    // Min heap for larger part
    private PriorityQueue<Integer> upper;
    // Max heap for lower part
    private PriorityQueue<Integer> lower;

    /** initialize your data structure here. */
    public MedianFinder() {
        upper = new PriorityQueue<>();
        lower = new PriorityQueue<>(Collections.reverseOrder());    
    }
    
    public void addNum(int num) {
        // lower has higher priority than upper when new elements come
        if (lower.size() == 0) {    lower.offer(num);   }
        else if (lower.size() > upper.size()) {
            if (num >= lower.peek()) {  upper.offer(num);   }
            else {
                upper.offer(lower.poll());
                lower.offer(num);
            }
        } else {
            if (num <= upper.peek()) {  lower.offer(num);   }
            else {
                lower.offer(upper.poll());
                upper.offer(num);
            }
        }
    }
    
    public double findMedian() {
        double median = lower.peek();
        if ((lower.size() + upper.size()) % 2 == 0) {
            median = (median + upper.peek()) / 2;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class Tree {
    private static class Node {
        private int key;
        private int val;
        private int size;
        private int height;
        public Node left, right;
        public Node(int key) {
            this.key = key; val = 1; size = 1; height = 1;
        }
    }

    private Node root;
    public Tree() {}

    public int size() { return size(root);  }

    public void insert(int key) {   root = insert(root, key);   }
    private static Node insert(Node node, int key) {
        if (node == null) { return new Node(key);   }
        int cmp = Integer.compare(key, node.key);
        if (cmp < 0)        {   node.left  = insert(node.left, key);     }
        else if (cmp > 0)   {   node.right = insert(node.right, key);    }
        else                {   node.val++;                              }
        updateParams(node);
        return balance(node);
    }

    private static int size(Node node)  {   return node == null ? 0 : node.size;    }
    private static int height(Node node){   return node == null ? 0 : node.height;  }

    private static void updateParams(Node node) {
        node.size = node.val + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private static int balanceFactor(Node node) {   return height(node.left) - height(node.right);  }

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

    private static Node balance(Node node) {
        int diff = balanceFactor(node);
        // Case 1: Left leaning
        if (diff > 1) {
            // Case 1.1: LR leaning, make it LL leaning
            if (balanceFactor(node.left) < 0) { node.left = rotateLeft(node.left);}
            // Case 1.2: LL leaning
            node = rotateRight(node);
        } 
        // Case 2: Right leaning
        else if (diff < -1) {
            // Case 2.1: RL leaning, make it RR leaning
            if (balanceFactor(node.right) > 0) {    node.right = rotateRight(node.right);}
            // Case 2.2: RR leaning
            node = rotateLeft(node);
        }
        return node;
    }

    public int getKthSmallest(int k) {
        return getKthSmallest(root, k);
    }

    private static int getKthSmallest(Node node, int k) {
        int leftSize = size(node.left);
        if (k <= leftSize) {    return getKthSmallest(node.left, k);    }
        k -= leftSize;
        if (k <= node.val) {    return node.key;    }
        k -= node.val;
        return getKthSmallest(node.right, k);
    }

}

class MedianFinder {
    private Tree tree;
    /** initialize your data structure here. */
    public MedianFinder() {
        tree = new Tree();
    }
    
    public void addNum(int num) {
        tree.insert(num);
    }
    
    public double findMedian() {
        int size = tree.size();
        int k = (size + 1) / 2;
        double median = tree.getKthSmallest(k);
        if (size % 2 == 0) {
            median = (median + tree.getKthSmallest(k + 1)) / 2;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */