import java.util.*;

class Graph {
    private int V;
    private List<List<Node>> adj;

    static class Node implements Comparable<Node> {
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Node(dest, weight));
        adj.get(dest).add(new Node(src, weight)); // For undirected graph
    }

    public void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        printSolution(dist);
    }

    private void printSolution(int[] dist) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }
}

public class solutionLabAssignmentDijkstras {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 2, 3);

        graph.dijkstra(0);
    }
}
