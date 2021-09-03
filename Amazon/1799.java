class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int bitMap = (1 << n) - 1;
        int[] cache = new int[bitMap + 1];

        return dfs(cache, bitMap, 1, nums);
    }

    /**
     * @param  cache  cache historical results
     * @param  bitMap bit map
     * @param  index  ith operations (1-indexed)
     * @param  nums   values to choose
     * @return        max score starting at indexth operation with current bitmap
     */
    private static int dfs(int[] cache, int bitMap, int index, int[] nums) {
        if (bitMap == 0 || cache[bitMap] != 0) {    return cache[bitMap];   }

        int max = 0;
        // iterate over all possible pairs, flip their bits, calculate the score
        for (int f = 0; f < nums.length; f++) {
            if (!isSet(bitMap, f)) continue;
            bitMap = unSet(bitMap, f);
            for (int s = f + 1; s < nums.length; s++) {
                if (!isSet(bitMap, s)) continue;
                bitMap = unSet(bitMap, s);
                max = Math.max(max, 
                    index * gcd(nums[f], nums[s]) + dfs(cache, bitMap, index + 1, nums)
                    );
                bitMap = set(bitMap, s);
            }
            bitMap = set(bitMap, f);

        }
        cache[bitMap] = max;
        return max;
    }

    // Check if ith bit is set
    private static boolean isSet(int num, int i) {
        return ((num >> i) & 1) == 1;
    }

    // Unset the ith bit
    private static int unSet(int num, int i) {
        return num & (~ (1 << i));
    }

    // Set the ith bit
    private static int set(int num, int i) {
        return num | (1 << i);
    }

    // gcd of two values
    private static int gcd(int m, int n) {
        while (n != 0) {
            int a = m % n;
            m = n;
            n = a;
        }
        return m;
    }
}