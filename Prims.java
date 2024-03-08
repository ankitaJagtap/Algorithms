import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Prims
 */
public class Prims {

    static class Edge {
        int node;
        int dist;
        int wt;

        public Edge(int n, int d, int w) {
            this.node = n;
            this.dist = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 50));

    }

    /**
     * Pair
     */
    static class Pair implements Comparable<Pair> {
        int Vertex;
        int cost;

        public Pair(int v, int c) {
            this.Vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));
        int mstCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (!vis[curr.Vertex]) {
                vis[curr.Vertex] = true;
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.Vertex].size(); i++) {
                    Edge e = graph[curr.Vertex].get(i);
                    if (!vis[e.dist]) {
                        pq.add(new Pair(e.dist, e.wt));
                    }

                }

            }
        }
        System.out.println("Minimum cost is =" + mstCost);

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[4];
        createGraph(graph);
        primsAlgo(graph, V);

    }
}