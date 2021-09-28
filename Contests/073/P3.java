class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';
    private int[] indexes = new int[N_CHARS];
    
    public String customSortString(String order, String s) {
        int value = 1;
        for (char ch : order.toCharArray()) {
            indexes[ch - BASE] = value++;
        }
        char[] ans = s.toCharArray();
        quicksort(ans, 0, ans.length - 1);
        return String.valueOf(ans);
    }

    private void quicksort(char[] cs, int lo, int hi) {
        if (lo >= hi) { return; }
        int pivot = indexes[cs[lo] - BASE];
        int lt = lo, gt = hi;
        int i = lo + 1;
        while (i <= gt) {
            int cmp = Integer.compare(indexes[cs[i] - BASE], pivot);
            if (cmp < 0) {  swap(cs, i++, lt++);    }
            else if (cmp > 0) { swap(cs, i, gt--);  }
            else {  i++;    }
        }
        quicksort(cs, lo, lt - 1);
        quicksort(cs, gt + 1, hi);
    }

    private static void swap(char[] cs, int i, int j) {
        char tmp = cs[i]; cs[i] = cs[j]; cs[j] = tmp;
    }
}