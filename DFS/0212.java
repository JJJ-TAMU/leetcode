class Trie {
    private static final int BRANCHES = 26;
    private static final char OFFSET = 'a';

    private static class Node {
        private boolean isWord;
        private Node[] next;
        private boolean used;
        public Node() { next = new Node[BRANCHES];  }
    }

    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - OFFSET;
            if (node.next[index] == null) { node.next[index] = new Node();  }
            node = node.next[index];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = getNode(root, word);
        return node != null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = getNode(root, prefix);
        return node != null;    
    }

    // returns the node starts with the given string
    private static Node getNode(Node node, String s) {
        for (char ch : s.toCharArray()) {
            int index = ch - OFFSET;
            if (node.next[index] == null) { return null;    }
            node = node.next[index];
        }
        return node;
    }
}
class Solution {
    private static final final char MARK = '#';
    private Trie tree;

    public List<String> findWords(char[][] board, String[] words) {
        tree = new Trie();
        for (String word : words) {
            tree.insert(word);
        }    
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(ans, board, new StringBuilder(), i, j, tree.root);
            }
        }
        return ans;
    }

    private static void dfs(List<String> ans, char[][] board, StringBuilder sb, int i, int j, Node node) {
        
    }

    private static boolean validate(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}