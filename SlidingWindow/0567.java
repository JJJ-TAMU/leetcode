class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';

    public boolean checkInclusion(String s2, String s1) {
        int[] target = countFreqs(s2);
        int n = countChars(target);
        char[] cs = s1.toCharArray();
        int m = s2.length();
        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - BASE;
            if (target[index] == 1) {
                n--;
            } else if (target[index] == 0) {
                n++;
            }
            target[index]--;
            int j = i - m;
            if (j >= 0) {
                index = cs[j] - BASE;
                if (target[index] == -1) {
                    n--;
                } else if (target[index] == 0) {
                    n++;
                }
                target[index]++;
            }
            
            if (i >= m - 1 && n == 0) {
                return true;
            }
        }
        return false;
    }

    private static int countChars(int[] counter) {
        int n = 0;
        for (int freq : counter) {
            if (freq != 0) {
                n++;
            }
        }
        return n;
    }

    private static int[] countFreqs(String s) {
        int[] counter = new int[N_CHARS];
        for (char ch : s.toCharArray()) {
            counter[ch - BASE]++;
        }
        return counter;
    }
}