class Solution {
    private static class UF {
        private int id[];
        private int sz[];
        public UF(int n) {
            id = new int[n]; sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i; sz[i] = 1;
            }
        }

        public boolean union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj) {     return false;       }
            int si = sz[pi], sj = sz[pj];
            if (si < sj) {
                id[pi] = pj;
                sz[pj] += si;
            } else {
                id[pj] = pi;
                sz[pi] += sj;
            }
            return true;
        }

        private int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (l1, l2)->Integer.compare(l1[0], l2[0]));
        UF uf = new UF(n);
        for (int[] log : logs) {
            int i = log[1], j = log[2];
            if (uf.union(i, j)) {
                if (--n == 1) {
                    return log[0];
                }
            }
        }
        return -1;
    }
}