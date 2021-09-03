class Solution {
    private static class UF {
        private int[] id;
        private int[] sz;
        public UF(int size) {
            id = new int[size]; sz = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i; sz[i] = 1;
            }
        }
        
        private int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }    
            return i;
        }
        
        public boolean union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj) { return false;   }
            int si = sz[pi], sj = sz[pj];
            if (si < sj) {
                id[pi] = pj; sz[pj] += si;
            } else {
                id[pj] = pi; sz[pi] += sj;
            }
            return true;
        }
    }
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (c1, c2)->Integer.compare(c1[2], c2[2]));
        int cost = 0;
        UF uf = new UF(n);
        for (int[] connection : connections) {
            if (n == 1) {
                break;
            }
            if (uf.union(connection[0] - 1, connection[1] - 1)) {
                cost += connection[2];
                n--;
            }
        }
        return n != 1 ? -1 : cost;
    }
}