class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Each -1 form a single group
        // Step 1: find how many unique groups
        m = updateGroups(group, m);

        // Step 2: try to detect group order
        Set<Integer>[] groups = new Set[m];
        int[] globalOrder = setGlobalOrder(groups, beforeItems, group);
        if (globalOrder == null) {   return new int[0];  }

        // Step 3: try to detect order inside each group
        int[] ans = new int[n];
        int index = 0;
        for (int groupId : globalOrder) {
            int[] groupOrder = setGroupOrder(groups[groupId], beforeItems);
            if (groupOrder == null) {   return new int[0];  }
            index = updateTotalOrder(ans, groupOrder, index);
        }
        return ans;
    }

    private static int updateTotalOrder(int[] ans, int[] groupOrder, int index) {
        System.arraycopy(groupOrder, 0, ans, index, groupOrder.length);
        return index + groupOrder.length;
    }

    private static int[] setGroupOrder(Set<Integer> members, List<List<Integer>> beforeItems) {
        int size = members.size();
        int[] ans = new int[size];
        Map<Integer, Integer> memberToId = new HashMap<>();
        int[] idToMember = new int[size];
        int id = 0;
        for (int member : members) {
            memberToId.put(member, id);
            idToMember[id++] = member;
        }
        List<Integer>[] neighbors = new List[size];
        int[] indegrees = new int[size];
        for (int member : members) {
            id = memberToId.get(member);
            var prevItems = beforeItems.get(member);
            for (int prevItem : prevItems) {
                if (members.contains(prevItem)) {
                    int prevId = memberToId.get(prevItem);
                    if (neighbors[prevId] == null) {    neighbors[prevId] = new ArrayList<>();  }
                    neighbors[prevId].add(id);
                    indegrees[id]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            if (indegrees[i] == 0) {    queue.offer(i); }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            id = queue.poll();
            ans[index++] = idToMember[id];
            if (neighbors[id] == null) {    continue;   }
            for (int next : neighbors[id]) {
                if (--indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == size ? ans : null;
    }

    private static int[] setGlobalOrder(Set<Integer>[] groups, List<List<Integer>> beforeItems, int[] group) {
        int m = groups.length;
        Set<Integer>[] groupNeighbors = new Set[m];
        for (int i = 0; i < m; i++) {
            groups[i] = new HashSet<>();
            groupNeighbors[i] = new HashSet<>();
        }
        int[] groupIndegrees = new int[m];
        for (int fIdx = 0; fIdx < group.length; fIdx++) {
            int fGroupId = group[fIdx];
            groups[fGroupId].add(fIdx);
            for (int sIdx : beforeItems.get(fIdx)) {
                int sGroupId = group[sIdx];
                if (fGroupId != sGroupId) {
                    if (groupNeighbors[sGroupId].add(fGroupId)) {
                        groupIndegrees[fGroupId]++;
                    }
                }
            }
        }
        int[] groupOrder = new int[m];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int groupId = 0; groupId < m; groupId++) {
            if (groupIndegrees[groupId] == 0) {
                queue.offer(groupId);
            }
        }
        while (!queue.isEmpty()) {
            int groupId = queue.poll();
            groupOrder[index++] = groupId;
            for (int nextGroupId : groupNeighbors[groupId]) {
                if (-- groupIndegrees[nextGroupId] == 0) {
                    queue.offer(nextGroupId);
                }
            }
        }
        return index == m ? groupOrder : null;
    }

    private static int updateGroups(int[] group, int m) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        return m;
    }
}