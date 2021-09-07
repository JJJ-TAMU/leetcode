class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites, indegrees);

        // Add all zero-indegrees courses into the queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
        	if (indegrees[i] == 0) {
        		queue.offer(i);
        	}
        }

        int finished = 0;

        while (!queue.isEmpty()) {
        	int prev = queue.poll();
        	finished++;
        	for (int next : graph[prev]) {
        		if (--indegrees[next] == 0) {
        			queue.offer(next);
        		}
        	}
        }

        return finished == numCourses;
    }

    private static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites, int[] indegrees) {
    	List<Integer>[] graph = new List[numCourses];
    	for (int i = 0; i < numCourses; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	for (int[] prerequisite : prerequisites) {
    		int next = prerequisite[0], prev = prerequisite[1];
    		graph[prev].add(next);
    		indegrees[next]++;
    	}
    	return graph;
    }
}