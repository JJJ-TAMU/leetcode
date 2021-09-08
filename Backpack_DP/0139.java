class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        Set<String> words = new HashSet<>(wordList);

        for (int size = 1; size <= n; size++) {
            for (int lo = 0; lo < size; lo++) {
                if (dp[lo] && words.contains(String.valueOf(cs, lo, size - lo))) {
                    dp[size] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

// top down dp