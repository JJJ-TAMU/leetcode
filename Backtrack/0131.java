class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] table = formTable(s);
        List<List<String>> ans = new ArrayList<>();

        backtrack(ans, new ArrayList<>(), table, s, 0);
        return ans;
    }

    private static void backtrack(List<List<String>> ans, List<String> curr, 
        boolean[][] dp, String s, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int end = index + 1; end <= s.length(); end++) {
            if (dp[index][end - 1]) {
                curr.add(s.substring(index, end));
                backtrack(ans, curr, dp, s, end);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] table = formTable(s);
        List<List<String>>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());

        for (int size = 1; size <= n; size++) {
            dp[size] = new ArrayList<>();
            for (int lo = 0; lo < size; lo++) {
                if (table[lo][size - 1]) {
                    for (List<String> l : dp[lo]) {
                        List<String> curr = new ArrayList<>(l);
                        curr.add(s.substring(lo, size));
                        dp[size].add(curr);
                    }
                }
            }
        }
        return dp[n];
    }

    private static boolean[][] formTable(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {   dp[i][i] = true;    }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        for (int size = 3; size <= n; size++) {
            for (int lo = 0, hi = lo + size - 1; hi < n; lo++, hi++) {
                if (s.charAt(lo) == s.charAt(hi) && dp[lo + 1][hi - 1]) {
                    dp[lo][hi] = true;
                }
            }
        }
        return dp;
    }
}