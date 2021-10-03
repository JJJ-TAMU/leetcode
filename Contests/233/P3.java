class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int lo = 1, hi = maxSum;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (validate(n, index, mi, maxSum)) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return hi;
    }
    
    private static boolean validate(int n, int index, int target, int upperBound) {
        int loIdx = Math.max(0, index - target + 1);
        int loMin = target - (index - loIdx);
        int hiIdx = Math.min(index + target - 1, n - 1);
        int hiMin = target - (hiIdx - index);
        long leftSum = sum(loMin, target);
        if (leftSum > upperBound) { return false;   }
        leftSum += sum(hiMin, target - 1);
        if (leftSum > upperBound) { return false;   }
        leftSum += loIdx * 1 + (n - 1 - hiIdx) * 1;
        return leftSum <= upperBound;
    }
    
    private static long sum(int lo, int hi) {
        return (long)(lo + hi) * (hi - lo + 1) / 2;
    }
}