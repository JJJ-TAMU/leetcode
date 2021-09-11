class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            int freq = counter.getOrDefault(num, 0) + 1;
            counter.put(num, freq);
        }

        int[] keys = new int[counter.size()];
        int index = 0;
        for (var key : counter.keySet()) {
            keys[index++] = key;
        }
        quickSelect(keys, 0, index - 1, k - 1, counter);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {   ans[i] = keys[i];   }
        return ans;
    }

    private static void quickSelect(int[] keys, int lo, int hi, int k, Map<Integer, Integer> counter) {
        if (lo >= hi) {     return;     }
        int pivot = counter.get(keys[lo]);
        int lt = lo, gt = hi;
        int i = lo + 1;
        while (i <= gt) {
            int cmp = Integer.compare(counter.get(keys[i]), pivot);
            if (cmp > 0) {      swap(keys, i++, lt++);  }
            else if (cmp == 0) {    i++;    }
            else {  swap(keys, i, gt--);    }
        }
        if (k < lt) {   quickSelect(keys, lo, lt - 1, k, counter);  }
        if (k > gt) {   quickSelect(keys, gt + 1, hi, k, counter);  }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }
}