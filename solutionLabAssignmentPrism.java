import java.util.Arrays;

public class solutionLabAssignmentPrism {
    private static final int INF = Integer.MAX_VALUE;
        public static void primMST(int[][] graph) {
            int V = graph.length;
            int[] parent = new int[V]; // Stores MST
            int[] key = new int[V];    // Used to pick minimum weight edge
            boolean[] mstSet = new boolean[V]; // To track vertices included in MST
    
            Arrays.fill(key, INF);
            key[0] = 0; 
            parent[0] = -1; // Root of MST
    
            for (int count = 0; count < V - 1; count++) {
                int u = minKeyVertex(key, mstSet, V);
                mstSet[u] = true;
    
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                        parent[v] = u;
                        key[v] = graph[u][v];
                    }
                }
            }
    
            printMST(parent, graph);
        }
    
        private static int minKeyVertex(int[] key, boolean[] mstSet, int V) {
            int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
    public static void main(String args[]){
        int[][] graph = {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        primMST(graph);
    }
}
