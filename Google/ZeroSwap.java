/**
 * Given two lists which both consist of values from 0 to n - 1
 * you should make the first list the same as the second one by only swaping 0 with other elements
 */
import java.util.*;

public class ZeroSwap {
	private static Random rand = new Random();

	public static void solve(int[] first, int[] second) {
		// try to make each position
		// Step 1: find the position of zero
		int idx = getZeroPos(first);
		int n = first.length;

		for (int i = 0; i < n; i++) {
			while (first[i] != 0 && first[i] != second[i]) {
				
			}
		}
	}

	private static int getZeroPos(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				return i;
			}
		}
		return -1; // useless
	}

	public static void shuffle(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			swap(arr, i, j);
		}
	}

	public static int[] generateArr(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		shuffle(arr);
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
	}

	private static void isEqual(int[] first, int[] second) {
		int n = first.length;
		for (int i = 0; i < n; i++) {
			if (first[i] != second[i]) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}

	public static void main(String[] args) {
		int n = 10;
		int[] first = generateArr(n);
		int[] second = generateArr(n);
		solve(first, second);
		isEqual(first, second);
	}
}