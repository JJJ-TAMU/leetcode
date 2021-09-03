class Solution {
    private static final int DIVISOR = 1_000_000_007;   
    private int order;
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);    
        long profit = 0L;
        int n = inventory.length;
        int bound = n - 1;
        order = orders;
        
        while (order > 0 && inventory[bound] > 0) {
            bound = rank(inventory, bound, inventory[bound]);
            profit += getProfit(inventory, bound, n - 1);
            profit %= DIVISOR;
        }
        return (int)profit;
    }

    private long getProfit(int[] inventory, int lo, int hi) {
        int width = hi - lo + 1;
        int max = inventory[lo];
        int min = lo > 0 ? inventory[lo - 1] + 1 : 1;
        int height = max - min + 1;

        long profit = 0;
        int rows = order / width;
        if (rows >= height) {
            // update order
            order -= rows * width;
            profit += ((rangeSum(min, max) % DIVISOR) * width) % DIVISOR;
            Arrays.fill(inventory, lo, hi + 1, min - 1);
        } else {
            profit += ((rangeSum(max - rows + 1, max) % DIVISOR) * width) % DIVISOR;
            order %= width;
            profit += ((max - rows) * order) % DIVISOR;
            order = 0;
        }

        return profit % DIVISOR;
    }

    private static final long rangeSum(int lo, int hi) {
        return ((long)lo + hi) * (hi - lo + 1) / 2;
    }

    private static final int rank(int[] nums, int hi, int target) {
        int lo = 0;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] < target) {    lo = mi + 1;    }
            else {  hi = mi - 1;    }
        }
        return lo;
    }

}