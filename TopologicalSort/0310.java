class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        // less than 3 nodes, at most one edge, both can be root
        if (n < 3) {
            for (int i = 0; i < n; i++) {   ans.add(i);     }
            return ans;
        }

        int[] degrees = new int[n];
        var graph = buildGraph(n, edges, degrees);

        for (int i = 0; i < n; i++) {
            // if is a leaf
            if (degrees[i] == 1) {  ans.add(i); }
        }

        while (n > 2) {
            n -= ans.size();
            List<Integer> curr = new ArrayList<>();
            for (int leaf : ans) {
                for (int parent : graph[leaf]) {
                    if (--degrees[parent] == 1) {
                        curr.add(parent);
                    }
                }
            }
            ans = curr;
        }
        return ans;
    }

    private static List<Integer>[] buildGraph(int n, int[][] edges, int[] degrees) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            degrees[u]++;
            degrees[v]++;
        }
        return graph;
    }
}