class Solution {
    private static final int N_CHARS = 26;
    private static final char BASE = 'a';

    private static class Node {
        private boolean isWord;
        private String word;
        private Node[] next;
        public Node() { next = new Node[N_CHARS];   }
    }

    private static class Trie {
        private Node root;
        public Trie() { root = new Node();  }
        public void insert(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - BASE;
                if (node.next[index] == null) { node.next[index] = new Node();  }
                node = node.next[index];
            }
            node.isWord = true;
            node.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();
        for (String word : words) { tree.insert(word);  }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, ans);
            }
        }      
        return ans;
    }

    private static void dfs(char[][] board, int i, int j, Node node, List<String> ans) {
        if (node == null || !valid(board, i, j)) {  return; }
        
    }
}