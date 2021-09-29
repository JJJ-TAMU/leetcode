class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = new int[] {-100000, 100000};
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (i1, i2) -> Integer.compare(i1[2], i2[2])
        );

        int size = nums.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int value = nums.get(i).get(0);
            pq.offer(new int[]{ i, 0, value});
            max = Math.max(max, value);
        }

        while (pq.size() == size) {
            int[] coor = pq.poll();
            int value = coor[2];
            int range = max - value;
            if (range < ans[1] - ans[0]) {
                ans[0] = value; ans[1] = max;
            }
            coor[1]++;
            if (coor[1] == nums.get(coor[0]).size()) {
                continue;
            }
            value = nums.get(coor[0]).get(coor[1]);
            coor[2] = value;
            pq.offer(coor);
            max = Math.max(max, value);
        }
        return ans;
    }
}