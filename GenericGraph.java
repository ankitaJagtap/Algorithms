import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.RowFilter.Entry;

/**
 * GenericGraph
 */
public class GenericGraph {

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

        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Integer>> val : graph.entrySet()) {
            vis.putIfAbsent(val.getKey(), false);
        }

        q.add(76);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!vis.get(curr)) {
                System.out.print(curr + " ");
                vis.replace(curr, true);
                for (Integer node : graph.get(curr)) {
                    q.add(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        genericGraph(graph);
    }
}