class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] cs = s.toCharArray();

        backtrack(ans, cs, 0);
        return ans;        
    }

    private static void backtrack(List<String> ans, char[] cs, int index) {
        if (index == cs.length) {
            ans.add(String.valueOf(cs));
            return;
        }
        cs[index] = Character.toLowerCase(cs[index]);
        backtrack(ans, cs, index + 1);
        if (Character.isLetter(cs[index])) {
            cs[index] = Character.toUpperCase(cs[index]);
            backtrack(ans, cs, index + 1);
        }
    }
}