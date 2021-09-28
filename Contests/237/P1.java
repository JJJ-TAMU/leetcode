class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';

    public boolean checkIfPangram(String sentence) {
        boolean[] counter = new boolean[N_CHARS];
        for (char ch : sentence.toCharArray()) {
            counter[ch - BASE] = true;
        }    
        return validate(counter);
    }

    private static boolean validate(boolean[] counter){
        for (boolean flag : counter) {
            if (!flag) {
                return false;
            }
        }
        return true;
    } 
}