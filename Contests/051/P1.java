class Solution {
    public String replaceDigits(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        for (int i = 1; i < n; i += 2) {
            cs[i] = (char)(cs[i - 1] + cs[i] - '0');
        }
        return String.valueOf(cs);
    }
}