class Solution {
    private static Map<String, Integer> map = Map.of(
        "type", 0,
        "color", 1,
        "name", 2
    );

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter = 0;
        for (var item : items) {
            if (matchRule(item, ruleKey, ruleValue)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean matchRule(List<String> item, String ruleKey, String ruleValue) {
        int index = map.get(ruleKey);
        return ruleValue.equals(item.get(index));
    }
}