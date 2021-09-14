class Solution {
    private static class Project {
        private int capital;
        private int profit;
        public Project(int c, int p) {  capital = c; profit = p;    }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> unSelectedProjects = new PriorityQueue<>(
            (p1, p2)->Integer.compare(p1.capital, p2.capital)
        );

        PriorityQueue<Project> selectableProjects = new PriorityQueue<>(
            (p1, p2)->Integer.compare(p2.profit, p1.profit)
        );

        int n = profits.length;
        for (int i = 0; i < n; i++) {
            unSelectedProjects.offer(new Project(capital[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!unSelectedProjects.isEmpty() && unSelectedProjects.peek().capital <= w) {
                selectableProjects.offer(unSelectedProjects.poll());
            }
            if (selectableProjects.isEmpty()) { break;  }
            w += selectableProjects.poll().profit;
        }
        return w;

    }
}