class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(nums.length);
        
        fillList(curr, nums);
        
        backtrack(ans, curr, 0);
        
        return ans;
    }
    
    private static void backtrack(List<List<Integer>> ans, List<Integer> curr, int idx) {
        if (idx == curr.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = idx; i < curr.size(); i++) {
            if (used.add(curr.get(i))) {
                swap(curr, i, idx);
                backtrack(ans, curr, idx + 1);
                swap(curr, i, idx);
            }
        }
    }
    
    private static void swap(List<Integer> curr, int i, int j) {
        int tmp = curr.get(i); curr.set(i, curr.get(j)); curr.set(j, tmp);
    }
    
    private static void fillList(List<Integer> list, int[] nums) {
        for (int num : nums) {  list.add(num);  }
    }
}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        count(counter, nums);
        backtrack(counter, nums, 0, ans);
        return ans;
    }

    private static void backtrack(Map<Integer, Integer> counter, int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(convertToList(nums));
            return;
        }
        for (var entry : counter.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value != 0) {
                nums[index] = key;
                counter.put(key, value - 1);
                backtrack(counter, nums, index + 1,  ans);
                counter.put(key, value);
            }
        }
    }

    private static List<Integer> convertToList(int[] nums) {
        List<Integer> ans = new ArrayList<>(nums.length);
        for (int num : nums) {  ans.add(num);   }
        return ans;
    }

    private static void count(Map<Integer, Integer> counter, int[] nums) {
        for (int num : nums) {
            int freq = counter.getOrDefault(num, 0) + 1;
            counter.put(num, freq);
        }
    }
}