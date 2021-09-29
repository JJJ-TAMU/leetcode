class Solution {
    public int numDifferentIntegers(String word) {
        char[] cs = word.toCharArray();
        int lo = 0;
        Set<String> ints = new HashSet<>();
        while (lo < cs.length) {
            while (lo < cs.length && !Character.isDigit(cs[lo])) {
                lo++;
            }
            if (lo == cs.length) {
                break;
            }
            int hi = lo + 1;
            while (hi < cs.length && Character.isDigit(cs[hi])) {
                hi++;
            }
            while (lo < hi - 1 && cs[lo] == '0') {
                lo++;
            }
            ints.add(String.valueOf(cs, lo, hi - lo));
            lo = hi;
        }
        return ints.size();
    }
}