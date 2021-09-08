class Solution {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int firstRange = rob(nums, 0, nums.length - 2);
		int secondRange = rob(nums, 1, nums.length - 1);
		return Math.max(firstRange, secondRange);
	}

	private static int rob(int[] nums, int lo, int hi) {
		int rob = 0, notRob = 0;
		for (int i = lo; i <= hi; i++) {
			int currRob = notRob + nums[i];
			notRob = Math.max(notRob, rob);
			rob = currRob;
		}
		return Math.max(rob, notRob);
	}
}