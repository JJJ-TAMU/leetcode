class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';

    public int numKLenSubstrNoRepeats(String s, int k) {
        int ans = 0;
        char[] cs = s.toCharArray();
        int[] counter = new int[N_CHARS];
        int n = 0;
        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - BASE;
            if (counter[index]++ == 0) {
                n++;
            }
            if (i < k - 1) continue;
            int j = i - k;
            if (j >= 0) {
                index = cs[j] - BASE;
                if (--counter[index] == 0) {
                    n--;
                }
            }
            if (n == k) {
                ans++;
            }
        }
        return ans;
    }
}