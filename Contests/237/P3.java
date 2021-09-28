class Solution {
    private static class Task{
        private int index;
        private int enqueTime;
        private int processTime;
        public Task(int i, int e, int p) {
            index = i; enqueTime = e; processTime = p;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] ts = new Task[n];
        for (int i = 0; i < n; i++) {
            int[] task = tasks[i];
            ts[i] = new Task(i, task[0], task[1]);
        }

        Arrays.sort(ts, (t1, t2)->Integer.compare(t1.enqueTime, t2.enqueTime));

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (t1, t2)-> {
                int cmp = Integer.compare(t1.processTime, t2.processTime);
                return cmp != 0 ? cmp : Integer.compare(t1.index, t2.index);
            }
        );

        int time = 0;
        int index = 0;
        int[] ans = new int[n];
        int i = 0;
        while (true) {
            while (index < n && ts[index].enqueTime <= time) {
                pq.offer(ts[index++]);
            }
            if (pq.isEmpty()) {
                if (index == n) {
                    break;
                }
                time = ts[index].enqueTime;
            } else {
                Task task = pq.poll();
                time += task.processTime;
                ans[i++] = task.index;
            }
        }
        return ans;
    }
}