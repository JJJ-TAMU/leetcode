class Solution {
    private static class Node {
        private Node[] next;
        private List<String> suggestions;
        public Node() {
            next = new Node[26];
            suggestions = new ArrayList<>();
        }
    }

    private static class Trie {
        private Node root;
        public Trie() { root = new Node();  }

        public void insert(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                int index = ch -'a';
                if (node.next[index] == null) { node.next[index] = new Node();  }
                node = node.next[index];
                if (node.suggestions.size() < 3) {
                    node.suggestions.add(word);
                }
            }
        }

    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        Trie tree = new Trie();
        for (String product : products) {
            tree.insert(product);
        }

        List<List<String>> ans = new ArrayList<>();
        Node node = tree.root;
        for (int i = 0; i < searchWord.length(); i++) {
            int index  = searchWord.charAt(i) - 'a';
            if (node.next[index] == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    ans.add(new ArrayList<>());
                }
                return ans;
            } else {
                node = node.next[index];
                ans.add(node.suggestions);
            }
        }
        return ans;
    }
}