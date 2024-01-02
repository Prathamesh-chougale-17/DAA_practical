import java.util.*;

public class assignment5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] chess = new int[n][n];
        sc.close();
        printknightsTour(chess, r, c, 0);
    }

    public static void printknightsTour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        } else if (move == chess.length * chess.length - 1) {
            chess[r][c] = move;
            displayBoard(chess);
            // chess[r][c] = 0;
            System.exit(0);
        }
        if (move < chess.length * chess.length - 1) {
            chess[r][c] = move;
            printknightsTour(chess, r - 2, c + 1, move + 1);
            printknightsTour(chess, r - 1, c + 2, move + 1);
            printknightsTour(chess, r + 1, c + 2, move + 1);
            printknightsTour(chess, r + 2, c + 1, move + 1);
            printknightsTour(chess, r + 2, c - 1, move + 1);
            printknightsTour(chess, r + 1, c - 2, move + 1);
            printknightsTour(chess, r - 1, c - 2, move + 1);
            printknightsTour(chess, r - 2, c - 1, move + 1);
            chess[r][c] = 0;
        }
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}