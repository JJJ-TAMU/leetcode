class Trie {
    private static final int BRANCHES = 26;
    private static final char OFFSET = 'a';

    private static class Node {
        private boolean isWord;
        private Node[] next;
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */