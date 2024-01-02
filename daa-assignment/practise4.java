public class practise4 {
    static final int V = 9;

    int minDistance(int[] dist, Boolean[] setsep) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < V; i++) {
            if (!setsep[i] && min >= dist[i]) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        Boolean[] setsep = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            setsep[i] = false;
        }
        dist[src] = 0;
        for (int i = 0; i < V; i++) {
            int u = minDistance(dist, setsep);
            setsep[u] = true;
            for (int j = 0; j < V; j++) {
                if (!setsep[j] && dist[u] != Integer.MAX_VALUE && graph[u][j] != 0 && dist[j] > dist[u] + graph[u][j]) {
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + "   " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 18, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        practise4 n = new practise4();
        n.dijkstra(graph, 0);
    }
}
