import java.util.Scanner;

public class practise3 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int graph[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == -1) {
                    graph[i][j] = INF;
                }
            }
        }
        sc.close();
        floydWarshall(graph, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF  ");
                } else {
                    System.out.print(graph[i][j] + "  ");
                }
            }
            System.out.println();
        }

    }

    public static void floydWarshall(int[][] graph, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[k][j] + graph[i][k];
                    }
                }
            }
        }
    }
}
