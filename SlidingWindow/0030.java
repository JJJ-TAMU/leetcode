class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        Map<String, Integer> target = countFreq(words);
        int singleLen = words[0].length();
        int totalLen = singleLen * words.length;

        for (int i = 0; i <= s.length() - totalLen ; i++) {
            if (match(s, target, i, singleLen, totalLen)) {
                ans.add(i);
            }
        }

        return ans;        
    }

    private static Map<String, Integer> countFreq(String[] words) {
        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            int freq = counter.getOrDefault(word, 0) + 1;
            counter.put(word, freq);
        }
        return counter;
    }

    private static boolean match(String s, Map<String, Integer> target, 
            int i, int singleLen, int totalLen) {
        Map<String, Integer> actual = new HashMap<>();
        for (int freq = 0; freq < totalLen / singleLen; freq++) {
            String candidate = s.substring(i, i + singleLen);
            int targetFreq = target.getOrDefault(candidate, 0);
            int actualFreq = actual.getOrDefault(candidate, 0) + 1;
            if (targetFreq < actualFreq) {
                return false;
            }
            actual.put(candidate, actualFreq);
            i += singleLen;
        }
        return true;
    }
}
