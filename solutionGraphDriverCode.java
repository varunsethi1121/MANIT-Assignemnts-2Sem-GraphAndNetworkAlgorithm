import java.util.ArrayList;
public class solutionGraphDriverCode {
    static class Edge {
        int source;
        int weight;
        int destination;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }

    public static void main(String args[]) {
        int verticesCount = 7;
        ArrayList<Edge>[] sampleGraph = new ArrayList[verticesCount]; // NULL VALUE AT EVERY INDEX
        for (int i = 0; i < verticesCount; i++) {
            sampleGraph[i] = new ArrayList<>();
        }
        sampleGraph[0].add(new Edge(0, 1, 1));
        sampleGraph[1].add(new Edge(1, 0, 1));
        sampleGraph[1].add(new Edge(1, 3, 1));
        sampleGraph[2].add(new Edge(2, 0, 1));
        sampleGraph[2].add(new Edge(2, 4, 1));
        sampleGraph[3].add(new Edge(3, 1, 1));
        sampleGraph[3].add(new Edge(3, 4, 1));
        sampleGraph[3].add(new Edge(3, 5, 1));
        sampleGraph[4].add(new Edge(4, 2, 1));
        sampleGraph[4].add(new Edge(4, 3, 1));
        sampleGraph[4].add(new Edge(4, 5, 1));
        sampleGraph[5].add(new Edge(5, 4, 1));
        sampleGraph[5].add(new Edge(5, 5, 1));
        sampleGraph[6].add(new Edge(6, 5, 1));

        for(int i=0;i<sampleGraph[2].size();i++){
            Edge e = sampleGraph[2].get(i);
            System.out.print(e.destination + " ");
        }
    }
}
