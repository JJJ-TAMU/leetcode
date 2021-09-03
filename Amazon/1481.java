class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        var counter = countFreqs(arr);
        int maxFreqs = findMax(counter);
        int[] buckets = new int[maxFreqs + 1];
        for (var value : counter.values()) {
            buckets[value]++;
        }
        int nUniqueNums = counter.size();
        for (int i = 1; i <= maxFreqs; i++) {
            int atMost = Math.min(k / i, buckets[i]);
            k -= atMost * i;
            nUniqueNums -= atMost;
            if (k == 0) {   break;  }
        }
        return nUniqueNums;
    }

    private static int findMax(Map<Integer, Integer> map) {
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        return max;
    }

    private static Map<Integer, Integer> countFreqs(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : arr) {
            int value = counter.getOrDefault(num, 0) + 1;
            counter.put(num, value);
        }
        return counter;
    }
}