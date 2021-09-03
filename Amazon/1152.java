class Solution {
    private static final class Visit implements Comparable<Visit> {
        private String user;
        private int time;
        private String web;
        public Visit(String user, int time, String web) {
            this.user = user; this.time = time; this.web = web;
        }
        @Override
        public int compareTo(Visit v) {
            int cmp = user.compareTo(v.user);
            return cmp == 0 ? Integer.compare(time, v.time) : cmp;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Visit[] visits = new Visit[n];
        for (int i = 0; i < n; i++) {   visits[i] = new Visit(username[i], timestamp[i], website[i]);    };
        Arrays.sort(visits);

        Map<String, Integer> allPatterns = new HashMap<>();
        int lo = 0;
        while (lo < n) {
            int hi = getGroupEnd(visits, lo);
            Set<String> patterns = countGroup(visits, lo, hi);
            merge(allPatterns, patterns);
            lo = hi + 1;
        }
        String pattern = getMostVisit(allPatterns);
        String[] webs = pattern.split("-");
        return Arrays.asList(webs);
    }

    // Given the start index of the group, returns the end index of the group
    private static final int getGroupEnd(Visit[] visits, int lo) {
        int hi = lo + 1;
        while (hi < visits.length && visits[lo].user.equals(visits[hi].user)) {
            hi++;
        }
        return hi - 1;
    }

    // Returns a map which counts the frequency of each visit pattern
    private static final Set<String> countGroup(Visit[] visits, int lo, int hi) {
        Set<String> patterns = new HashSet<>();
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                for (int k = j + 1; k <= hi; k++) {
                    String pattern = visits[i].web + "-" + visits[j].web + "-" + visits[k].web;
                    patterns.add(pattern);
                }
            }
        }
        return patterns;
    }

    // Merges the patterns found by this user and all patterns
    private static final void merge(Map<String, Integer> map, Set<String> set) {
        for (String pattern : set) {
            int value = map.getOrDefault(pattern, 0) + 1;
            map.put(pattern, value);
        }
    }

    // Get the key with largest value
    private static final String getMostVisit(Map<String, Integer> map) {
        String best = "";
        int max = 0;
        for (var entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > max || (value == max && key.compareTo(best) < 0)) {
                best = key;
                max = value;
            }
        }
        return best;
    }
}