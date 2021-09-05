class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (e1, e2)->Integer.compare(e1[0], e2[0]));

        int counter = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int time = events[0][0];
        while (i < events.length || !pq.isEmpty()) {
            while (i < events.length && events[i][0] <= time) {
                pq.offer(events[i][1]);
                i++;
            }
            while (!pq.isEmpty() && pq.peek() < time) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                time++;
                counter++;
            } else {
                if (i < events.length) {
                    time = events[i][0];
                }
            }
        }
        return counter;
    }
}