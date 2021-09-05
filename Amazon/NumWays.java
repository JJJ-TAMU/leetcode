import java.util.*;

public class NumWays {
	public static void solve(String s) {
		char[] cs = s.toCharArray();
		Set<String> set = new HashSet<>();
		dfs(cs, 0, set);
		System.out.println(set.size());
	}

	private static void dfs(char[] cs, int idx, Set<String> set) {
		if (idx == cs.length) {	
			
			for (int i = 0; i < cs.length - 1; i++) {
				char first = cs[i], second = cs[i + 1];
				if ((first == 'a' && second == 'e') || (first == 'e' && second == 'a')) {
					return;
				}
			}

			set.add(String.valueOf(cs));	
			return;
		}
		for (int i = idx; i < cs.length; i++) {
			swap(cs, i, idx);
			dfs(cs, idx + 1, set);
			swap(cs, i, idx);
		}
	}

	private static void swap(char[] cs, int i, int j) {
		char tmp = cs[i]; cs[i] = cs[j]; cs[j] = tmp;
	}

	public static void main(String[] args) {
		String s = "afffsce";
		solve(s);
	}
}