class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) { return 0;   }     

        Set<String> used = new HashSet<>();
        Set<String> front = new HashSet<>();
        Set<String> end = new HashSet<>();
        front.add(beginWord);
        end.add(endWord);
        used.add(beginWord);
        used.add(endWord);

        Set<String> tmp;
        int distance = 1;
        while (!(front.isEmpty() || end.isEmpty())) {
            distance++;
            if (front.size() > end.size()) {    tmp = front; front = end; end = tmp;    }
            tmp = new HashSet<>();
            for (String word : front) {
                char[] cs = word.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char old = cs[i];
                    for (char _new = 'a'; _new <= 'z'; _new++) {
                        if (_new == old) continue;
                        cs[i] = _new;
                        String next = String.valueOf(cs);
                        if (!words.contains(next)) continue;
                        if (end.contains(next)) {
                            return distance;
                        }
                        if (used.add(next)) {
                            tmp.add(next);
                        }
                    }
                    cs[i] = old;
                }
            }
            front = tmp;
        }   
        return 0;
    }
}