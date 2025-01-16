import java.util.LinkedList;

public class solutionLabAssignment1 {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    @SuppressWarnings("unchecked")
    
    public solutionLabAssignment1(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); 
    }
    public void printsolutionLabAssignment1() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer neighbor : adjacencyList[i]) {
                System.out.print(neighbor + "->");
            }
            System.out.print("NULL");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solutionLabAssignment1 solutionLabAssignment1 = new solutionLabAssignment1(5);
        solutionLabAssignment1.addEdge(0, 1);
        solutionLabAssignment1.addEdge(0, 4);
        solutionLabAssignment1.addEdge(1, 2);
        solutionLabAssignment1.addEdge(1, 3);
        solutionLabAssignment1.addEdge(1, 4);
        solutionLabAssignment1.addEdge(2, 3);
        solutionLabAssignment1.addEdge(3, 4);
        solutionLabAssignment1.printsolutionLabAssignment1();
    }
}
