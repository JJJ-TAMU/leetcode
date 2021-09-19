class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int j = map.getOrDefault(diff, -1);
            if (j != -1) {
                return new int[] {i, j};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}