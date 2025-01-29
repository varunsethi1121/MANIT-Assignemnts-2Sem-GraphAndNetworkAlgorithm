import java.util.*;
public class solutionLabAssignment2 {
    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void bellmanFord(List<Edge> edges, int vertices, int source) {
        // Initialize distances from the source to all vertices as infinite
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.destination; 
                int weight = edge.weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        // Print the distances
        printSolution(distance, source);
    }

    public void printSolution(int[] distance, int source) {
        System.out.println("Vertex\tDistance from Source " + source);
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t" + (distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]));
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        List<Edge> edges = new ArrayList<>();

        // Add edges (source, destination, weight)
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        solutionLabAssignment2 bellmanFord = new solutionLabAssignment2();
        bellmanFord.bellmanFord(edges, vertices, 0); // Source vertex is 0
    }
}
