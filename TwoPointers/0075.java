class Solution {
    public void sortColors(int[] nums) {
        // all elements to the left  of lt are 0
        // all elements to the right of gt are 2
        int lt = 0, gt = nums.length - 1;
        // all elements inside [lt, lo) are 1
        int lo = 0;

        while (lo <= gt) {
            if (nums[lo] == 0) {
                swap(nums, lt++, lo++);
            } else if (nums[lo] == 1) {
                lo++;
            } else {
                swap(nums, gt--, lo);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }
}