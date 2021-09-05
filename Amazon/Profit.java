public class Profit {
	public static int solve(List<Integer> nums, int k) {
		int n = nums.size();
		// Corner case, k == n / 2, the window + opposite covers the whole list
		if (k == n / 2) {
			return sum(nums);
		}
			
		// Step 1: Initialize the first window sum
		int windowSum = 0;
		int oppositeWindowSum = 0;
		for (int i = 0, j = getOppositePos(i); i < k; i++, j++) {
			windowSum += nums.get(i % n);
			oppositeWindowSum += nums.get(j % n);
		}

		// the maximum window sum + opposite sum
		int max = windowSum + oppositeWindowSum;

		// Step 2: sliding the window and update window sum and opposite window sum
		for (int i = 1, j = getOppositePos(i); i < n; i++, j++) {
			windowSum += nums.get((i + k - 1) % n) - nums.get(i - 1);
			oppositeWindowSum += nums.get((j + k - 1) % n) - nums.get((j - 1) % n);
			max = Math.max(max, windowSum + oppositeWindowSum);
		}
		return max;
	}

	private static int sum(List<Integer> nums) {
		int sum = 0;
		for (int num : nums) {	sum += num;	}
		return sum;
	}

	private static int getOppositePos(int i, int n) {
		return i + n / 2;
	}
}