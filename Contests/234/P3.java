class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> mapper = new HashMap<>();
        for (var know : knowledge) {
            String key = know.get(0), value = know.get(1);
            mapper.put(key, value);
        }
        StringBuilder sb = new StringBuilder();
        int lo = 0;
        while (lo < s.length()) {
            int hi = lo;
            while (hi < s.length() && s.charAt(hi) != '(') {
                hi++;
            }
            sb.append(s.substring(lo, hi));
            lo = hi;
            if (lo == s.length()) {
                break;
            }
            hi = lo++ + 2;
            while (hi < s.length() && s.charAt(hi) != ')') {
                hi++;
            }
            String key = s.substring(lo, hi);
            String value = mapper.getOrDefault(key, "?");
            sb.append(value);
            lo = hi + 1;
        }
        return sb.toString();
    }
}