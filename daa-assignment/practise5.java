import java.util.Scanner;

public class practise5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] graph = new int[n][n];
        sc.close();
        printKnightTour(graph, r, c, 0);
    }

    public static void printKnightTour(int[][] graph, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= graph.length || c >= graph.length || graph[r][c] > 0) {
            return;
        } else if (move == graph.length * graph.length - 1) {
            graph[r][c] = move;
            displayBoard(graph);
            System.exit(0);
        }
        graph[r][c] = move;
        printKnightTour(graph, r - 2, c + 1, move + 1);
        printKnightTour(graph, r - 1, c + 2, move + 1);
        printKnightTour(graph, r + 1, c + 2, move + 1);
        printKnightTour(graph, r + 2, c + 1, move + 1);
        printKnightTour(graph, r + 2, c - 1, move + 1);
        printKnightTour(graph, r + 1, c - 2, move + 1);
        printKnightTour(graph, r - 1, c - 2, move + 1);
        printKnightTour(graph, r - 2, c - 1, move + 1);
        graph[r][c] = 0;
    }

    public static void displayBoard(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + "  ");
            }
            System.out.println();
        }
    }
}