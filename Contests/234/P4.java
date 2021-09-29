class Solution {
    private static final int DIVISOR = 1_000_000_007;
    
    public int maxNiceDivisors(int primeFactors) {
        int n = primeFactors;
        if (n <= 4) {
            return n;
        } else if (n % 3 == 0) {
            return (int)pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int)((4 * pow(3, (n - 4) / 3)) % DIVISOR);
        } else {
            return (int)((2 * pow(3, (n - 2) / 3)) % DIVISOR);
        }
    }
    
    private static long pow(int base, int factor) {
        if (factor == 0) {  return 1;   }
        long half = pow(base, factor / 2) % DIVISOR;
        half = (half * half) % DIVISOR;
        if (factor % 2 == 1) {
            half = (half * base) % DIVISOR;
        }
        return half;
    }
}