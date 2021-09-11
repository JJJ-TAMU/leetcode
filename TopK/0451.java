// counting sort
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        countFreq(cs, map);
        heapSort(cs, map);
        return String.valueOf(cs);
    }

    // heap sort
    private static void heapSort(char[] cs, Map<Character, Integer> map) {
    	PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2)->Integer.compare(
    		map.get(c2), map.get(c1)));
    	for (var key : map.keySet()) {
    		pq.offer(key);
    	}
    	
    	int index = 0;
    	while (!pq.isEmpty()) {
    		char ch = pq.poll();
    		for (int i = 0; i < map.get(ch); i++) {
    			cs[index++] = ch;
    		}
    	}
    }

    // quick sort
    private static void quickSort(char[] cs, Map<Character, Integer> map) {
    	Character[] keys = new Character[map.size()];
    	int index = 0;
    	for (var key : map.keySet()) {	keys[index++] = key;	}
    	Arrays.sort(keys, (k1, k2)->Integer.compare(map.get(k2), map.get(k1)));
    	index = 0;
    	for (char ch : keys) {
    		int freq = map.get(ch);
    		for (int i = 0; i < freq; i++) {
    			cs[index++] = ch;
    		}
    	}
    }

	// counting sort
    private static void countingSort(char[] cs, Map<Character, Integer> map) {
    	int maxFreq = getMapFreq(map);
    	List<Character>[] buckets = new List[maxFreq + 1];
    	for (int i = 1; i <= maxFreq; i++) {	buckets[i] = new ArrayList<>();		}
    	for (var entry : map.entrySet()) {
    		char key = entry.getKey();
            int value = entry.getValue();
    		buckets[value].add(key);
    	}
    	int index = 0;
    	for (int i = maxFreq; i > 0; i--) {
    		if (buckets[i] != null) {
    			for (char ch : buckets[i]) {
    				for (int j = 0; j < i; j++) {
    					cs[index++] = ch;
    				}
    			}
    		}
    	}
    }

    private static void countFreq(char[] cs, Map<Character, Integer> map) {
    	for (char ch : cs) {
    		int freq = map.getOrDefault(ch, 0) + 1;
    		map.put(ch, freq);
    	}
    }

    private static int getMapFreq(Map<Character, Integer> map) {
    	int max = 0;
    	for (int freq : map.values()) {		max = Math.max(max, freq);	}
    	return max;
    }
}