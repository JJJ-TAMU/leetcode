class Solution {
    private static final int DIVISOR = 60;

    public int numPairsDivisibleBy60(int[] time) {
        int[] counter = new int[DIVISOR];
        for (int t : time) {
            counter[t % DIVISOR]++;
        }
        int nPairs = 0;
        for (int i = 0; i < DIVISOR; i++) {
            if (i == 0 || i == DIVISOR - i) {
                if (counter[i] < 2) continue;
                nPairs += counter[i] * (counter[i] - 1);
            } else {
                nPairs += counter[i] * counter[DIVISOR - i];
            }
        }
        return nPairs / 2;
    }
}