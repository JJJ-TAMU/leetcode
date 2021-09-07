class RandomizedSet {
    // maps value -> position in list
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) { return false;   }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {    return false;   }
        int index = map.get(val);
        swap(list, index, list.size() - 1);
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }

    private static void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i); list.set(i, list.get(j)); list.set(j, tmp);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */