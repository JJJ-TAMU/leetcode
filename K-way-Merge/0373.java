class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (i1, i2)->Integer.compare(i1[2], i2[2])
            );
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] {i, 0, nums1[i] + nums2[0]});
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) { break;  }
            int[] coor = pq.poll();
            ans.add(List.of(nums1[coor[0]], nums2[coor[1]]));
            if (++coor[1] < nums2.length) {
                coor[2] += nums2[coor[1]] - nums2[coor[1] - 1];
                pq.offer(coor);
            }
        }

        return ans;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        boolean[][] used = new boolean[Math.min(k + 1, m)][Math.min(k + 1, n)];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (i1, i2)->Integer.compare(
                nums1[i1[0]] + nums2[i1[1]],
                nums1[i2[0]] + nums2[i2[1]]
                ));
        pq.offer(new int[]{0, 0});
        used[0][0] = true;
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            int[] coor = pq.poll();
            int x = coor[0], y = coor[1];
            ans.add(List.of(nums1[x], nums2[y]));
            if (x + 1 < m && !used[x + 1][y]) {
                pq.offer(new int[] { x + 1, y});
                used[x + 1][y] = true;
            }
            if (y + 1 < n && !used[x][y + 1]) {
                pq.offer(new int[] { x, y + 1});
                used[x][y + 1] = true;
            }
        
        return ans;
    }
}