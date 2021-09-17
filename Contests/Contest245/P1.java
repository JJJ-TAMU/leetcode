class Solution {
    // Idea: count frequency of each character, and check if can even distribute characters to all strings
    
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';

    public boolean makeEqual(String[] words) {
        int[] counter = new int[N_CHARS];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                counter[ch - BASE]++;
            }
        }
        return validate(counter, words.length);
    }

    private static boolean validate(int[] counter, int k) {
        for (int freq : counter) {
            if (freq % k != 0) {    return false;   }
        }
        return true;
    }
}