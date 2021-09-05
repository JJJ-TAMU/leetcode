class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates) {
            int f = update[0], s = update[1];
            int val = update[2];
            ans[f] += val;
            if (s + 1 < length) {    ans[s + 1] -= val;  }
        }
        for (int i = 1; i < length; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}