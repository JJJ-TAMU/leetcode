class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            int j = i - k + 1;
            while (!deque.isEmpty() && deque.getFirst() < j) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (j >= 0) {
                ans[j] = nums[deque.getFirst()];
            }
        }        
        return ans;
    }
}