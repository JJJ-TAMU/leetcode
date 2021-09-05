class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int f = booking[0] - 1, s = booking[1] - 1;
            int val = booking[2];
            ans[f] += val;
            if (s + 1 < n) ans[s + 1] -= val;
        }       
        int prev = 0;
        for (int i = 0; i < n; i++) {
            ans[i] += prev;
            prev = ans[i];
        }
        return ans;
    }
}