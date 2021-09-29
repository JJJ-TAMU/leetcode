class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';

    private static class UF {
        private int[] id;
        private int[] sz;
        private int nGroups;

        public UF(int size) {
            id = new int[size]; sz = new int[size]; nGroups = size;
            for (int i = 0; i < size; i++) {
                id[i] = i; sz[i] = 1;
            }
        }

        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj) { return; }
            nGroups--;
            int si = sz[pi], sj = sz[pj];
            if (si < sj) {
                id[pi] = pj; sz[pj] += si;
            } else {
                id[pj] = pi; sz[pi] += sj;
            }
        }

        private int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public void flatten() {
            for (int i = 0; i < id.length; i++) {
                id[i] = find(i);
            }
        }
    }

    private void unionPairs(UF uf, List<List<Integer>> pairs) {
        for (var pair : pairs) {
            int i = pair.get(0), j = pair.get(1);
            uf.union(i, j);
        }
        uf.flatten();
    }

    private Map<Integer, List<Integer>> groupdIndexes(UF uf) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < uf.id.length; i++) {
            int pi = uf.find(i);
            if (!groups.containsKey(pi)) {
                groups.put(pi, new ArrayList<>());
            }
            groups.get(pi).add(i);
        }
        return groups;
    }


    private void fillGroup(List<Integer> group, int[] counter, char[] cs) {
        Arrays.fill(counter, 0);
        for (int id : group) {
            counter[cs[id] - BASE]++;
        }

        int idIdx = 0;
        for (int i = 0; i < N_CHARS; i++) {
            char ch = (char)(i + BASE);
            for (int j = 0; j < counter[i]; j++) {
                cs[group.get(idIdx++)] = ch;
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        // Initialize uf class
        UF uf = new UF(n);
        unionPairs(uf, pairs);

        // Group indexes
        Map<Integer, List<Integer>> groups = groupdIndexes(uf);

        int[] counter = new int[N_CHARS];
        for (var group : groups.values()) {
            fillGroup(group, counter, cs);
        }
        return String.valueOf(cs);
    }
}