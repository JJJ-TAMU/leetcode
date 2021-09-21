class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        char[] origin = new char[removable.length];
        for (int i = 0; i < origin.length; i++) {
            origin[i] = cs[removable[i]];
        }
        
        int lo = 0, hi = removable.length;
        
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (validate(cs, cp, removable, mi)) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
            recover(cs, removable, mi, origin);
        }
        return hi;
    }
    
    private static void recover(char[] cs, int[] removable, int n, char[] origin) {
        for (int i = 0; i < n; i++) {
            cs[removable[i]] = origin[i];
        }
    }
    
    private static boolean validate(char[] cs, char[] cp, int[] removable, int n) {
        for (int i = 0; i < n; i++) {
            cs[removable[i]] = '0';
        }
        int lo = 0;
        for (int i = 0; i < cp.length; i++) {
            lo = update(cs, lo, cp[i]);
            if (lo == cs.length) {
                return false;
            }
            lo++;
        }
        return true;
    }
    
    private static int update(char[] cs, int lo, char target) {
        while (lo < cs.length && cs[lo] != target) {
            lo++;
        }
        return lo;
    }
}