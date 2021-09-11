class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int rank = rank(arr, x);
        int l = rank - 1, r = rank;
        for (int i = 0; i < k; i++) {
            if (l < 0) {    r++;    }
            else if (r >= arr.length) {     l--;    }
            else if (x - arr[l] <= arr[r] - x) {    l--;    }
            else {  r++;    }
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = l + 1; i < r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    // Returns number of elements in arr which are strictly smaller than x
    private static final int rank(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] < target) {     lo = mi + 1;    }
            else {      hi = mi - 1;    }
        }
        return lo;
    }
}