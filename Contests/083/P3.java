class Solution {
    public int consecutiveNumbersSum(int n) {
        int bound = (int)(Math.sqrt(n * 2 + 0.25) - 0.5);
        int counter = 0;
        for (int k = 1; k <= bound; k++) {
            System.out.println(k);
            if ((n - k * (k + 1) / 2) % k == 0) {
                counter++;
            }
        }
        return counter;
    }
}