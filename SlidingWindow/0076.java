class Solution {
    private static final int N_CHARS = 128;

    public String minWindow(String s, String t) {
        int[] target = countFreqs(t);
        int n = 0;
        for (int freq : target) {
            if (freq != 0) {    n++;    }
        }
        int start = 0;
        int minLen = s.length() + 1;
        int[] actual = new int[N_CHARS];
        int lo = 0;
        for (int hi = 0; hi < s.length(); hi++) {
            int index = s.charAt(hi);
            if (target[index] == 0) {   continue;   }
            if (++actual[index] == target[index]) {
                n--;
            }
            if (n > 0) {    continue;   }
            while (n == 0) {
                index = s.charAt(lo++);
                if (target[index] == 0) {   continue;   }
                if (actual[index]-- == target[index]) {
                    n++;
                }
            }
            int len = hi - lo + 2;
            if (len < minLen) {
                minLen = len;
                start = lo - 1;
            }

        }

        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }

    private static int[] countFreqs(String t) {
        int[] counter = new int[N_CHARS];
        for (char ch : t.toCharArray()) {
            counter[ch]++;
        }
        return counter;
    }
}
