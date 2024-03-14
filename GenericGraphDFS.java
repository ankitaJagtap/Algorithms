import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * GenericGraphDFS
 */
public class GenericGraphDFS {
    public static void genericGraph(HashMap<Integer, ArrayList<Integer>> graph) {
        graph.put(54, new ArrayList<>());
        graph.get(54).add(76);
        graph.get(54).add(45);
        graph.put(76, new ArrayList<>());
        graph.get(76).add(54);
        graph.put(45, new ArrayList<>());
        graph.get(45).add(54);
        graph.get(45).add(32);
        graph.put(32, new ArrayList<>());
        graph.get(32).add(45);

        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Integer>> val : graph.entrySet()) {
            vis.putIfAbsent(val.getKey(), false);
        }

        dfs(graph, vis, 76);

    }

    public static void dfs(HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Boolean> vis, int src) {
        if (!vis.get(src)) {
            System.out.print(src + " ");
            vis.replace(src, true);
            for (Integer node : graph.get(src)) {
                dfs(graph, vis, node);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        genericGraph(graph);
    }
}