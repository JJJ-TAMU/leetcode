class Solution {
    private int[] minRank;
    private int rank;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        minRank = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] graph = buildGraph(connections, n);  
        for (int i = 0; i < n; i++) {
            if (minRank[i] == 0) {
                dfs(graph, ans, i, -1);
            }
        }  
        return ans;
    }

    private  void dfs(List<Integer>[] graph, List<List<Integer>> ans, int u, int p) {
        minRank[u] = ++rank;
        int currRank = rank;
        for (int v : graph[u]) {
            if (v == p) continue;
            if (minRank[v] == 0) dfs(graph, ans, v, u);
            if (minRank[v] > minRank[u]) {
                ans.add(List.of(u, v));
            } else {
                currRank = Math.min(currRank, minRank[v]);
            }
        }
        minRank[u] = currRank;
    }

    private static List<Integer>[] buildGraph(List<List<Integer>> connections, int n) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {   graph[i] = new ArrayList<>();   }
        for (var connection : connections) {
            int u = connection.get(0), v = connection.get(1);
            graph[u].add(v); graph[v].add(u);
        }
        return graph;
    }
}