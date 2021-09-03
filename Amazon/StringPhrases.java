import java.util.*;

public class StringPhrases {
	private static final int N_CHARS = 128;
	private static final char BASE = 0;
	private static class Node {
		private boolean isWord;
		private Node[] next;
		public Node() {	next = new Node[N_CHARS];	}
	}

	private static class Trie {
		private Node root;
		public Trie() {	root = new Node();	}
		public void insert(String s) {
			Node node = root;
			for (char ch : s.toCharArray()) {
				int index = ch - BASE;
				if (node.next[index] == null) {	node.next[index] = new Node();	}
				node = node.next[index];
			}
			node.isWord = true;
		}

		public List<String> search(String word) {
			Node node = root;
			List<String> ans = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (char ch : word.toCharArray()) {
				int index = ch - BASE;
				if (node.next[index] == null) {
					break;
				}
				node = node.next[index];
				sb.append(ch);
				if (node.isWord) {
					ans.add(sb.toString());
				}
			}
			return ans;
		}
	}

	public static List<String> solve(String[] phrases, String s) {
		Trie tree = new Trie();
		for (String word : phrases) {
			tree.insert(word);
		}
		return tree.search(s);
	}

	public static void main(String[] args) {
		String[] words = {"have", "have a good", "have a good morning", "and evening", "catfish"};
		String s = "have a good morning and evening";
		System.out.println(solve(words, s));
	}
}