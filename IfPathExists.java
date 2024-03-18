class Solution {
    boolean flag = false;

    public void dfs(Map<Integer, ArrayList<Integer>> map, boolean[] vis, int start, int end) {
        if (vis[start] || flag)
            return;
        vis[start] = true;
        for (int node : map.get(start)) {
            if (node == end) {
                flag = true;
            }
            if (!vis[node]) {
                dfs(map, vis, node, end);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i][0], new ArrayList<>());
            map.put(edges[i][1], new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(map, visited, source, destination);
        return flag;
    }
}
