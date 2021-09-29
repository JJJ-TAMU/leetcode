class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2)->
            Integer.compare(c1[1], c2[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int time = 0;
        int counter = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                counter++;
                pq.offer(course[0]);
            } else {
                if (!pq.isEmpty() && pq.peek() > course[0]) {
                    time -= pq.poll() - course[0];
                    pq.offer(course[0]);
                }
            }
        }
        return counter;

    }
}