class Solution {
    private static Map<Integer, char[]> DIAL_TABLE = Map.of(
        2, new char[] {'a', 'b', 'c'},
        3, new char[] {'d', 'e', 'f'},
        4, new char[] {'g', 'h', 'i'},
        5, new char[] {'j', 'k', 'l'},
        6, new char[] {'m', 'n', 'o'},
        7, new char[] {'p', 'q', 'r', 's'},
        8, new char[] {'t', 'u', 'v'},
        9, new char[] {'w', 'x', 'y', 'z'}
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {   return new ArrayList<>();     }
        return bfs(digits);
    }

    private static List<String> bfs(String digits) {
       char[] cs = digits.toCharArray();
       List<String> ans = new ArrayList<>();
       ans.add("");
       for (char ch : cs) {
           List<String> tmp = new ArrayList<>();
           for (String s : ans) {
               for (char letter : DIAL_TABLE.get(ch - '0')) {
                   tmp.add(s + letter);
               }
           }
           ans = tmp;
       }
       return ans;
    }

    private static List<String> dfs(String digits) {
        char[] cs = digits.toCharArray();
        List<String> ans = new ArrayList<>();
        char[] phoneNumber = new char[cs.length];
        dfs(ans, phoneNumber, cs, 0);
        return ans;
    }

    private static void dfs(List<String> ans, char[] number, char[] cs, int index) {
        if (index == cs.length) {
            ans.add(String.valueOf(number));
            return;
        }
        int digit = cs[index] - '0';
        for (char letter : DIAL_TABLE.get(digit)) {
            number[index] = letter;
            dfs(ans, number, cs, index + 1);
        }
    }
}
