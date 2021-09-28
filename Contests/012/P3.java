class Solution {
    private static class Counter {
        private int nOne;
        private int nZero;

        public Counter(String s) {
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    nOne++;
                }
            }
            nZero = s.length() - nOne;
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        Counter[] cs = new Counter[strs.length];
        for (int i = 0; i < strs.length; i++) {
            cs[i] = new Counter(strs[i]);
        }
        Arrays.sort(cs, (c0, c1)->Integer.compare(c0.nZero, c1.nZero));

        boolean[] used = new boolean[cs.length];
        return backtrack(cs, used, 0, m, n);
    }

    private static int backtrack(Counter[] cs, boolean[] used, int idx, int m, int n) {
        if (idx == cs.length) {
            return 0;
        }
        int size = 0;
        for (int i = idx; i < cs.length; i++) {
            if (cs[i].nZero > m) {
                break;
            }
            if (!used[i] && cs[i].nOne <= n) {
                used[i] = true;
                int curr = 1 + backtrack(cs, used, i + 1, m - cs[i].nZero, n - cs[i].nOne);
                size = Math.max(size, curr);
                used[i] = false;
            }
        }
        return size;
    }
}