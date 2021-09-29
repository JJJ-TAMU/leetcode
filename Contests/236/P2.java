class Solution {
    private static class Node {
        private int label;
        private Node prev, next;

        public Node(int l) {    label = l;  }
    }

    private static class DLL {
        private Node root;
        public DLL() {}

        private static void connect(Node first, Node second) {
            first.next = second; second.prev = first;
        }

        public void addLast(int label) {
            Node node = new Node(label);
            addLast(node);
        }

        public void addLast(Node node) {
            if (root == null) {     root = node;   connect(root, root); }
            else {
                Node last = root.prev;
                connect(last, node); connect(node, root);
            }
        }

        /* Remove the given node, add returns its next */
        public Node remove(Node node) {
            Node next = node.next; connect(node.prev, next);
            return next;
        }

        public static Node travelK(Node node, int k) {
            for (int i = 1; i < k; i++) {
                node = node.next;
            }
            return node;
        }

    }

    public int findTheWinner(int n, int k) {
        DLL dll = new DLL();
        for (int i = 1; i <= n; i++) {
            dll.addLast(i);
        }

        Node node = dll.root;
        for (int i = 1; i < n; i++) {
            node = dll.travelK(node, k);
            node = dll.remove(node);
        }
        return node.label;
    }
}

class Solution {
    private static class CircularArray {
        private int[] nums;
        private int size;
        public CircularArray(int n) {
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            size = n;
        }

        public int getK(int start, int k) {
            start = (start + k - 1) % size;
            System.arraycopy(nums, start + 1, nums, start, size - start - 1);
            size--;
            return start % size;
        }

        public int get(int pos) {
            return nums[pos];
        }
    }

    public int findTheWinner(int n, int k) {
        CircularArray ca = new CircularArray(n);
        int start = 0;
        for (int i = 1; i < n; i++) {
            start = ca.getK(start, k);
        }
        return ca.get(start);
    }
}