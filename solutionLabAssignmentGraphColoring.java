public class solutionLabAssignmentGraphColoring {
    final int V = 4; // Number of vertices
    int[] color;

    // Check if current color assignment is safe for vertex
    boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c)
                return false;
        }
        return true;
    }

    // Recursive utility function to solve m coloring problem
    boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        if (v == V)
            return true;

        // Try different colors for vertex v
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                if (graphColoringUtil(graph, m, color, v + 1))
                    return true;

                // Backtrack
                color[v] = 0;
            }
        }
        return false;
    }

    // This function solves the m Coloring problem using backtracking
    void graphColoring(int[][] graph, int m) {
        color = new int[V];

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist.");
            return;
        }

        // Print the color assignment
        printSolution(color);
    }

    void printSolution(int[] color) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print("Vertex " + i + " --->  Color " + color[i] + "\n");
    }

    public static void main(String[] args) {
        solutionLabAssignmentGraphColoring gc = new solutionLabAssignmentGraphColoring();

        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int m = 3; // Number of colors
        gc.graphColoring(graph, m);
    }
}
