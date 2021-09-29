class Solution {
    public int arraySign(int[] nums) {
        // Initialize sign as positive
        boolean sign = true;

        // Iterate over the array
        for (int num : nums) {
            // if there is a zero, then the sign should be zero
            if (num == 0) {     return 0;   }
            else if (num < 0) {     sign = !sign;   }
        }
        return sign ? 1 : -1;
    }
}