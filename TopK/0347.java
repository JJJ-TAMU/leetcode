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

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            int freq = counter.getOrDefault(num, 0) + 1;
            counter.put(num, freq);
        }
        int maxfreqs = maxfreqs(counter);
        List<Integer>[] buckets = new List[maxfreqs + 1];
        for (int i = 1; i <= maxfreqs; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (var entry : counter.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            buckets[value].add(key);
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = maxfreqs; i > 0; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < Math.min(k, buckets[i].size()); j++) {
                    ans[index++] = buckets[i].get(j);
                }
                k -= Math.min(k, buckets[i].size());
                if (k == 0) {   break;  }
            }
        }
        return ans;
    }

    private static int maxfreqs(Map<Integer, Integer> counter) {
        int max = 0;
        for (int freq : counter.values()) {
            max = Math.max(freq, max);
        }
        return max;
    }
}