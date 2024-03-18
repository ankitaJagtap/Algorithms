import java.util.ArrayList;

/**
 * DetectCycle
 */
public class DetectCycle {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        // graph[4].add(new Edge(4, 1));

    }

    public static boolean detectCycle(ArrayList<Edge> graph[], boolean[] vis, int init, boolean flag) {
        if (graph.length == 0) {
            return false;
        }
        if (!vis[init]) {
            vis[init] = true;
            for (int i = 0; i < graph[init].size(); i++) {
                Edge e = graph[init].get(i);
                if (detectCycle(graph, vis, e.dest, flag)) {
                    return true;
                }
            }
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean flag = false;
        int n = 5;
        ArrayList<Edge> graph[] = new ArrayList[n];
        boolean[] vis = new boolean[n];
        createGraph(graph);
        System.out.println(detectCycle(graph, vis, 0, flag));
    }
}