public class Solution {
    private static class Node {
        private int key;
        private int index;
        private int count;
        public Node(int key, int index) {   this.key = key; this.index = index; this.count = 0;   }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Node[] nodes = new Node[n];
        Node[] aux = new Node[n];
        for (int i = 0; i < n; i++) {   nodes[i] = new Node(nums[i], i);    }
        mergeSort(nodes, aux, 0, n - 1);
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {   ans.add(0); }
        for (Node node : nodes) {
            ans.set(node.index, node.count);
        }    
        return ans;
    }

    private static void mergeSort(Node[] nodes, Node[] aux, int lo, int hi) {
        if (lo >= hi) { return; }
        int mi = lo + (hi - lo) / 2;
        mergeSort(nodes, aux, lo, mi);
        mergeSort(nodes, aux, mi + 1, hi);
        merge(nodes, aux, lo, mi, hi);
    }

    private static void merge(Node[] nodes, Node[] aux, int lo, int mi, int hi) {
        System.arraycopy(nodes, lo, aux, lo, hi - lo + 1);
        int l = lo, r = mi + 1;
        for (int i = lo; i <= hi; i++){
            if (l > mi) {   nodes[i] = aux[r++];    }
            else if (r > hi) {
                nodes[i] = aux[l++]; nodes[i].count += r - mi - 1;
            } else if (less(aux[r], aux[l])) {
                nodes[i] = aux[r++];
            } else {
                nodes[i] = aux[l++]; nodes[i].count += r - mi - 1;
            }
        }
    }

    private static boolean less(Node n1, Node n2) { return Integer.compare(n1.key, n2.key) < 0; }
}