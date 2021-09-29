class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, n, n);
        return ans;        
    }

    private static void dfs(List<String> ans, StringBuilder sb, int left, int right) {
        if (right == 0) {
            ans.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            dfs(ans, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            dfs(ans, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}