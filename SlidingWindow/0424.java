class Solution {
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int max = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int candidate = maxLen(cs, k, ch);
            max = Math.max(max, candidate);
        }
        return max;
    }

    private static int maxLen(char[] cs, int k, char target) {
        int valid = 0;
        int invalid = 0;
        int lo = 0;
        int max = 0;

        for (int hi = 0; hi < cs.length; hi++) {
            if (cs[hi] == target) {
                valid++;
            } else {
                invalid++;
            }
            while (invalid > k) {
                if (cs[lo++] == target) {
                    valid--;
                } else {
                    invalid--;
                }
            }
            max = Math.max(max, valid + invalid);
        }
        return  max;
    }
}

class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'A';

    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int[] counter = new int[N_CHARS];
        int maxLen = 0;
        int maxFreq = 0;
        int lo = 0;
        for (int hi = 0; hi < cs.length; hi++) {
            int index = cs[hi] - BASE;
            if (++counter[index] > maxFreq) {
                maxFreq = counter[index];
            }
            int rest = hi - lo + 1 - maxFreq;
            if (rest <= k) {
                maxLen = Math.max(maxLen, hi - lo + 1);
            } else {
                index = cs[lo++] - BASE;
                counter[index]--;
            }
        }
        return maxLen;
    }
}