class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<Integer>[] graph = buildGraph(prerequisites, indegrees);

        int[] sequence = new int[numCourses];
        int index = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int prev = queue.poll();
            sequence[index++] = prev;
            for (int next : graph[prev]) {
                if (--indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == numCourses ? sequence : new int[0];
    }

    private static List<Integer>[] buildGraph(int[][] prerequisites, int[] indegrees) {
        List<Integer>[] graph = new List[indegrees.length];
        for (int i = 0; i < indegrees.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int next = prerequisite[0], prev = prerequisite[1];
            indegrees[next]++;
            graph[prev].add(next);
        }
        return graph;
    }
}