class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = findMinDiff(arr);
        return collectDiff(arr, minDiff);
    }

    private static int findMinDiff(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    private static List<List<Integer>> collectDiff(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == target) {
                ans.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }
}