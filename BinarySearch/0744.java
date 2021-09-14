class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int rank = rank(letters, ++target);
        return letters[rank % letters.length];
    }

    private static int rank(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] < target) {     lo = mi + 1;    }
            else {  hi = mi - 1;    }
        }
        return lo;
    }
}