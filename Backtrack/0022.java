class Solution {
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] cs = new char[n * 2];
        dfs(ans, cs, 0, n, n);
        return ans;       
    }

    private static void dfs(List<String> ans, char[] cs, int index, int left, int right) {
        if (right == 0) {
            ans.add(String.valueOf(cs));
            return;
        }
        if (left > 0) {
            cs[index] = LEFT_PAREN;
            dfs(ans, cs, index + 1, left - 1, right);
        }
        if (right > left) {
            cs[index] = RIGHT_PAREN;
            dfs(ans, cs, index + 1, left, right - 1);
        }
    }
}
