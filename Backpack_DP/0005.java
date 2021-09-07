class Solution {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] coor = manache(cs);
        return String.valueOf(cs, coor[0], coor[1]);
    }

    private static int[] manache(char[] cs) {
        int n = cs.length;
        int maxLen = 0;
        int start = 0;

        int[] odd = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(r - i + 1, odd[l + r - i]);
            while (i - k >= 0 && i + k < n && cs[i - k] == cs[i + k]) {
                k++;
            }
            if (i + k - 1 > r) {
                r = i + k - 1;
                l = i - k + 1;
            }
            if (maxLen < 2 * k - 1) {
                maxLen = 2 * k - 1;
                start = i - k + 1;
            }
        }

        int[] even = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(r - i + 1, even[l + r - i + 1]);
            while (i - k - 1 >= 0 && i + k < n && cs[i - k - 1] == cs[i + k]) {
                k++;
            }
            if (i + k - 1 > r) {
                r = i + k - 1;
                l = i - k;
            }
            if (maxLen < 2 * k) {
                maxLen = 2 * k;
                start = i - k;
            }
        }
        return new int[] { start, maxLen};
    }
}