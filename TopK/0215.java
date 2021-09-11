class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (pq.size() < k) {    pq.offer(num);  }
            else if (pq.peek() < num) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}



class Solution {
    private static Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, k - 1);
        Arrays.sort(nums, 0, k);
        return nums[0];
    }

    private static void quickSelect(int[] nums, int k) {
        shuffle(nums);
        quickSelect(nums, 0, nums.length - 1, k);
    }

    private static void quickSelect(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {     return;     }
        int mi = lo + (hi - lo) / 2;

        int pivot = nums[lo];
        int lt = lo, gt = hi;
        int i = lo + 1;
        while (i <= gt) {
            int cmp = Integer.compare(nums[i], pivot);
            if (cmp > 0) {  swap(nums, i++, lt++);  }
            else if (cmp == 0) {    i++;    }
            else {  swap(nums, i, gt--);    }
        }
        if (k < lt) {   quickSelect(nums, lo, lt - 1, k);   }
        if (k > gt) {   quickSelect(nums, gt + 1, hi, k);   }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }

    private static void shuffle(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(nums, i, j);
        }
    }
}