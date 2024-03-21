import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * TopologicalSort
 */
public class TopologicalSort {

    public static void dfs(int v, boolean[] vis, List<List<Integer>> adj, Stack<Integer> stk) {
        vis[v] = true;
        for (int i : adj.get(v)) {
            if (!vis[i]) {
                dfs(i, vis, adj, stk);
            }

        }
        stk.push(v);
    }

    public static void topologicalSort(List<List<Integer>> adj, int n) {
        Stack<Integer> stk = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, stk);
            }
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 4;

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adjList.get(i.get(0)).add(i.get(1));
        }

        topologicalSort(adjList, V);

    }
}