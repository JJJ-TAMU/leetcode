public class Solution {
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;

		// len[i] represents the length of the LIS ends at index i
		int[] len = new int[n];
		// cnt[i] represents the number of LIS ends at index i
		int[] cnt = new int[n];

		// iterate over all indexes, to find len[i], cnt[i] for each index i
		for (int i = 0; i < n; i++) {
			// initialization
			cnt[i] = 1;
			int max = 1; // max len of LIS ends at index i
			for (int j = 0; j < i; j++) {
				// only if nums[i] > nums[j], j is useful
				if (nums[i] > nums[j]) {
					if (len[j] + 1 > max) {
						max = len[j] + 1;
						cnt[i] = cnt[j];
					} else if (len[j] + 1 == max) {
						cnt[i] += cnt[j];
					}
				}
			}
			len[i] = max;
		}

		int maxLen = max(len);
		return getNumbersEqual(len, cnt, maxLen);
	}


	private static final int max(int[] nums) {
		int max = nums[0];
		for (int num : nums) {	max = Math.max(max, num);	}
		return max;
	} 

	private static final int getNumbersEqual(int[] len, int[] cnt, int target) {
		int total = 0;
		for (int i = 0; i < len.length; i++) {
			total += len[i] == target ? cnt[i] : 0;
		}		
		return total;
	}
}