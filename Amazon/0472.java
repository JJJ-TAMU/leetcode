class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (w1, w2)->Integer.compare(w1.length(), w2.length()));
        Set<String> previous = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 0 && canForm(word, previous)) {
                ans.add(word);
            }
            previous.add(word);
        }        
        return ans;
    }

    private static boolean canForm(String word, Set<String> words) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int end = 1; end <= n; end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && words.contains(word.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}