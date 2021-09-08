class Solution {
    public int rob(int[] nums) {
        int rob = 0, notRob = 0;
        for (int num : nums) {
            int currRob = notRob + num;
            notRob = Math.max(rob, notRob);
            rob = currRob;
        }
        return Math.max(rob, notRob);
    }
}