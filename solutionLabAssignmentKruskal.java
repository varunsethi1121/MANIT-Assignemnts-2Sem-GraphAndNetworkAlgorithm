import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight; // Sorting by weight
    }
}

class DisjointSet {
    int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]); // Path compression
        }
        return parent[v];
    }

    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 != root2) {
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }
}

public class solutionLabAssignmentKruskal  {
    public static void kruskalMST(List<Edge> edges, int vertices) {
        Collections.sort(edges); // Step 1: Sort edges by weight
        DisjointSet ds = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();
        
        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) { // Step 2: Check for cycles
                mst.add(edge);
                ds.union(edge.src, edge.dest);
            }
            if (mst.size() == vertices - 1) break; // Stop if MST is complete
        }

        // Print MST
        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices
        List<Edge> edges = new ArrayList<>();

        // Adding edges to the graph (src, dest, weight)
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(2, 3, 5));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 4, 7));
        edges.add(new Edge(3, 5, 6));
        edges.add(new Edge(4, 5, 8));

        // Run Kruskal's Algorithm
        kruskalMST(edges, vertices);
    }
}

