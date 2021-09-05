import java.util.*;

public class Range {
	public static void solve(List<Integer> badNumbers, int lo, int hi) {
		int[] indexes = partition(badNumbers, lo, hi);
		Collections.sort(badNumbers.subList(indexes[0], indexes[1] + 1));
		int max = 0;
		int prev = lo;
		for (int i = indexes[0]; i <= indexes[1]; i++) {
			int curr = badNumbers.get(i);
			max = Math.max(max, curr - prev);
			prev = curr + 1;
		}
		max = Math.max(max, hi - prev + 1);
		System.out.println(max);
	}

	private static int[] partition(List<Integer> badNumbers, int lowerBound, int upperBound) {
		int lt = 0, gt = badNumbers.size() - 1;
		int i = 0;
		while (i <= gt) {
			int value = badNumbers.get(i);
			if (value < lowerBound) 	 {	swap(badNumbers, lt++, i++);	}
			else if (value > upperBound) {	swap(badNumbers, gt--, i);		}
			else {	i++;	}
		}
		return new int[] {lt, gt};
	}

	private static void swap(List<Integer> nums, int i, int j) {
		int tmp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, tmp);
	}

	public static void main(String[] args) {
		int[] ans = {20, 10, 5, 50, 3, -10};
		List<Integer> nums = new ArrayList<>();
		for (int num : ans) {
			nums.add(num);
		}
		int lo = 1;
		int hi = 15;
		solve(nums, lo, hi);
	}
}