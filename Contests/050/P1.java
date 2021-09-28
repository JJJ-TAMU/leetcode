class Solution {
    public int minOperations(int[] nums) {
        int nOperations = 0;
        int prev = 0;
        for (int num : nums) {
            if (num <= prev) {
                nOperations += ++prev - num;
            } else {
                prev = num;
            }
        }
        return nOperations;
    }
}