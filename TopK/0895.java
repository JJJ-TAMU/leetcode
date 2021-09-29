class FreqStack {
    // maps key -> frequency
    private Map<Integer, Integer> map;
    // every entry contains the values which have the same frequency = pos + 1
    private List<Deque<Integer>> list;

    public FreqStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        if (freq > list.size()) {
            list.add(new ArrayDeque<>());
        }
        list.get(freq - 1).push(val);
    }
    
    public int pop() {
        int maxFreq = list.size();
        var maxStack = list.get(maxFreq - 1);
        int val = maxStack.pop();
        if (maxStack.isEmpty()) {   list.remove(maxFreq - 1);   }
        
        if (--maxFreq == 0) {
            map.remove(val);
        } else {
            map.put(val, maxFreq);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */