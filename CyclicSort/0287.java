class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int fast = findMeetPoint(nums);
        int slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    private static int findMeetPoint(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        return slow;
    }
}