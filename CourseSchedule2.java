class CourseSchedule2 {

    public static List<Integer> topologicalSort(List<List<Integer>> adj, int n) {
        int[] indegree = new int[n];
        // Traverse through adjecency list to calculate indegree of vertices
        for (List<Integer> list : adj) {
            for (int node : list) {
                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Traverse through indegree array to add vertices of indegree zero to queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);
            for (int node : adj.get(curr)) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    q.add(node);
                }
            }
        }
        if (result.size() != n) {
            return new ArrayList<>();
        } else {
            return result;
        }

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int j = 0; j < prerequisites.length; j++) {
            adj.get(prerequisites[j][1]).add(prerequisites[j][0]);
        }
        List<Integer> list = topologicalSort(adj, numCourses);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;

    }
}