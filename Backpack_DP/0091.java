class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        char[] cs = s.toCharArray();
        int first = 1, second = 1;
        for (int i = 1; i < cs.length; i++) {
            int third = cs[i] == '0' ? 0 : second;
            int val = (cs[i - 1] - '0') * 10 + cs[i] - '0';
            if (val >= 10 && val <= 26) {
                third += first;
            }
            first = second;
            second = third;
        }
        return second;
    }
}