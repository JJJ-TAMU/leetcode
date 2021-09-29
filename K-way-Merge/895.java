class FreqStack {
    private Map<Integer, Integer> counter;
    private List<Deque<Integer>> list;

    public FreqStack() {
        counter = new HashMap<>();
        list = new ArrayList<>();    
    }
    
    public void push(int val) {
        int freq = counter.getOrDefault(val, 0) + 1;
        counter.put(val, freq);
        if (freq > list.size()) {
            list.add(new ArrayDeque<>());
        }
        list.get(freq - 1).push(val);
    }
    
    public int pop() {
        int freq = list.size();
        Deque<Integer> stack = list.get(--freq);
        int ans = stack.pop();
        if (freq == 0) {    counter.remove(ans);    }
        else {  counter.put(ans, freq);  }
        if (stack.isEmpty()) {
            list.remove(freq);
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */