class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';
    
    public String reorganizeString(String s) {
        int[] counter = new int[N_CHARS];
        char[] cs = s.toCharArray();
        // Step 1: count frequency of each character in s
        for (char ch : cs) {
            counter[ch - BASE]++;    
        }
        
        // Step 2: get max count of the character;
        int max = 0; char maxChar = BASE;
        for (int i = 0; i < N_CHARS; i++) {
            if (counter[i] > max) { max = counter[i];   maxChar = (char)(i + BASE); }
        }
        
        // Step 3: fill the char array
        if (max > (cs.length + 1) / 2) {
            return "";
        }
        int index = 0;
        // Step 3, fill the max char
        counter[maxChar - BASE] = 0;
        for (int i = 0; i < max; i++) {
            cs[index] = maxChar;
            index += 2;
        }
        // Step 4, fill the others
        for (int i = 0; i < N_CHARS; i++) {
            if (counter[i] != 0) {
                char ch = (char)(i + BASE);
                for (int j = 0; j < counter[i]; j++) {
                    if (index >= cs.length) {
                        index = 1;
                    }
                    cs[index] = ch;
                    index += 2;
                }
                counter[i] = 0;
            }
        }
        return String.valueOf(cs);
        
    }
}