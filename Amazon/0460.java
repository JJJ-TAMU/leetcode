class LFUCache {

    /* Idea: 
        1. for fast lookup, we need a map to store key->value info
        2. every time we visit a key, we need to update its priority (i.e. frequency)
            so, probably we need another map to maintain frequecy->nodes info
    */
   
    private static class Node {
        private int key;
        private int value;
        private int freq;
        private Node prev, next;
        public Node() {}
        public Node(int key, int value) {   this.key = key; this.value = value; freq = 1;   }
    }   

    private static class DLL {
        private Node sentinel;
        public DLL() {  sentinel = new Node(); connect(sentinel, sentinel); }
        private static void connect(Node f, Node s) {   f.next = s; s.prev = f; }

        public void remove(Node node) { connect(node.prev, node.next);  }
        public void addFirst(Node node) {   
            Node f = sentinel.next; connect(sentinel, node); connect(node, f);
        }
        public Node removeLast() {  Node last = sentinel.prev;  remove(last);   return last;    }
        public boolean isEmpty() {  return sentinel.next == sentinel;   }

    }

    private Map<Integer, Node> nodeMap;
    private Map<Integer, DLL> dllMap;
    private int capacity;
    private int minKey;

    public LFUCache(int capacity) {
        this.capacity = capacity; nodeMap = new HashMap<>(); dllMap = new HashMap<>(); minKey = 0;
    }
    
    private Node getNode(int key) {
        Node node = nodeMap.getOrDefault(key, null);
        if (node != null) {
            int freq = node.freq++;
            DLL dll = dllMap.get(freq);
            dll.remove(node);
            if (dll.isEmpty()) {
                dllMap.remove(freq);
                if (minKey == freq) {
                    minKey++;
                }
            }
            dllMap.putIfAbsent(node.freq, new DLL());
            dllMap.get(node.freq).addFirst(node);
        }
        return node;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {    return;     }
        Node node = getNode(key);
        if (node != null) { node.value = value; }
        else {
            node = new Node(key, value);
            // check if cache is at its capacity
            if (capacity == nodeMap.size()) {
                // evict the least recently used one
                evict();
            }
            minKey = 1;
            dllMap.putIfAbsent(minKey, new DLL());
            dllMap.get(minKey).addFirst(node);
            nodeMap.put(key, node);
        }
    }

    private void evict() {
        DLL dll = dllMap.get(minKey);
        Node last = dll.removeLast();
        if (dll.isEmpty()) {
            dllMap.remove(last.freq);
        }
        nodeMap.remove(last.key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */