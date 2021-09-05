public class LinkedListMax {
	public static int solve(int[] arr, int k) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		int max = sum;
		for (int i = 1, j = i + k - 1; i < n; i++, j++) {
			sum += arr[j % n] - arr[i - 1];
			max = Math.max(sum, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {7, 2, 3, 4, 5, 6};
		System.out.println(solve(arr, 3));
	}
}