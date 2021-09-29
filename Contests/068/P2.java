class Solution {
    private static final char BASE = 'a';
    private static final int N_CHARS = 26;
    private static final String INVALID_ANSWER = "";

    public String reorganizeString(String s) {
        char[] cs = s.toCharArray();
        int[] counter = countChars(cs); 
        return reorganize(cs, counter);
    }

    private static int[] countChars(char[] cs) {
        int[] counter = new int[N_CHARS];
        for (char ch : cs) {
            counter[ch - BASE]++;
        }
        return counter;
    }

    private static boolean validate(int n, int m) {
        return (n + 1) / 2 >= m;
    }

    private static String reorganize(char[] cs, int[] counter) {
        int n = cs.length;
        int maxOccur = 0;
        char maxChar = BASE;
        for (int i = 0; i < N_CHARS; i++) {
            if (counter[i] > maxOccur) {
                maxOccur = counter[i];
                maxChar = (char)(i + BASE);
            }
        }   

        if (!validate(n, maxOccur)) {
            return INVALID_ANSWER;
        }

        counter[maxChar - BASE] = 0;
        int index = 0;
        for (int i = 0; i < maxOccur; i++) {
            cs[index] = maxChar;
            index += 2;
        }
        for (int i = 0; i < N_CHARS; i++) {
            char ch = (char)(BASE + i);
            for (int j = 0; j < counter[i]; j++) {
                if (index >= n) {
                    index = 1;
                }
                cs[index] = ch;
                index += 2;
            }
        }
        return String.valueOf(cs);
    }
}