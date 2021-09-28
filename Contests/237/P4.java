class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int first = getXORSum(arr1);
        int second = getXORSum(arr2);
        return first & second;
    }

    private static int getXORSum(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}