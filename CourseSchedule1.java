class CourseSchedule1 {

    public static boolean topologicalSort(List<List<Integer>> adj, int n) {
        int[] indegree = new int[n];
        for (int i = 0; i < adj.size(); i++) {
            for (Integer j : adj.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);
            for (Integer node : adj.get(curr)) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    q.add(node);
                }
            }
        }
        if (result.size() == n) {
            return true;
        } else {
            return false;
        }

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int j = 0; j < prerequisites.length; j++) {
            adj.get(prerequisites[j][1]).add(prerequisites[j][0]);
        }
        return (topologicalSort(adj, numCourses));
    }
}