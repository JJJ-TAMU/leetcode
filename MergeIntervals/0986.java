class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i], second = secondList[j];
            if (first[1] < second[0]) {
                i++;
            } else if (second[1] < first[0]) {
                j++;
            } else {
                int[] newInterval = new int[] {
                    Math.max(first[0], second[0]),
                    Math.min(first[1], second[1])
                };
                ans.add(newInterval);
                if (first[1] > second[1]) {
                    j++;
                } else if (first[1] < second[1]) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
        }       
        return ans.toArray(new int[ans.size()][]);
    }
}