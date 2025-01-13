import java.util.LinkedList;

public class solutionLabAssignment1 {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list
    // Constructor
    @SuppressWarnings("unchecked")
    
    public solutionLabAssignment1(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        // Initialize each list in the array
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge to the solutionLabAssignment1 (undirected solutionLabAssignment1)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Remove this line for a directed solutionLabAssignment1
    }

    // Print the adjacency list
    public void printsolutionLabAssignment1() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a solutionLabAssignment1 with 5 vertices
        solutionLabAssignment1 solutionLabAssignment1 = new solutionLabAssignment1(5);

        // Add edges
        solutionLabAssignment1.addEdge(0, 1);
        solutionLabAssignment1.addEdge(0, 4);
        solutionLabAssignment1.addEdge(1, 2);
        solutionLabAssignment1.addEdge(1, 3);
        solutionLabAssignment1.addEdge(1, 4);
        solutionLabAssignment1.addEdge(2, 3);
        solutionLabAssignment1.addEdge(3, 4);

        // Print adjacency list
        solutionLabAssignment1.printsolutionLabAssignment1();
    }
}
