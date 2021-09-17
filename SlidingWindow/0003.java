class Solution {
    private static final int N_CHARS = 256;

    public int lengthOfLongestSubstring(String s) {
        // tracks the last index of the given character in the string
        int[] lastIdx = new int[N_CHARS];
        Arrays.fill(lastIdx, -1);

        char[] cs = s.toCharArray();
        int maxLen = 0;
        int lo = -1;
        for (int hi = 0; hi < cs.length; hi++) {
            int index = cs[hi];
            if (lastIdx[index] > lo) {
                lo = lastIdx[index];
            }
            lastIdx[index] = hi;
            maxLen = Math.max(maxLen, hi - lo);
        }
        return maxLen;        
    }
}
