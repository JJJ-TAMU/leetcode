class LRUCache {
    // Node entry in doubly linked list
    private static class Node {
        private int key;
        private int value;
        private Node prev, next;
        public Node() {}
        public Node(int key, int value) {   this.key = key; this.value = value; }
    }
    // Doubly linked list class
    private static class DLL {
        private Node sentinel;
        public DLL() {  sentinel = new Node(); connect(sentinel, sentinel); }
        // Connects the two nodes 
        private void connect(Node f, Node s) {  f.next = s; s.prev = f; }

        // Removes the given node
        public void remove(Node node) { connect(node.prev, node.next);  }
        // Inserts the given node to the front of the list
        public void addFirst(Node node) {   Node first = sentinel.next; connect(sentinel, node); connect(node, first);}
        // Removes the last node
        public Node removeLast() {
            Node last = sentinel.prev; remove(last);
            return last;
        }
    }

    // map stores key->node mapping for 0(1) access to node
    private Map<Integer, Node> map;
    // DLL stores all nodes
    private DLL dll;
    // capacity of the cache
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DLL();    
    }
    
    // Returns the node with the given key, null if key not present
    private Node getNode(int key) {
        Node node = map.getOrDefault(key, null);
        // if node is not null, update its priority
        if (node != null) {
            dll.remove(node);
            dll.addFirst(node);
        }
        return node;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;   
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {    return; }
        Node node = getNode(key);
        if (node != null) { node.value = value; }
        else {
            // if at its capacity, we need to evict the least recently used key
            if (map.size() == capacity) {
                Node last = dll.removeLast();
                map.remove(last.key);
            }
            node = new Node(key, value);
            map.put(key, node);
            dll.addFirst(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */