import java.util.Scanner;

public class practise5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] chess = new int[n][n];
        sc.close();
        KnightTour(chess, r, c, 0);

    }

    public static void KnightTour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        } else if (move == chess.length * chess.length - 1) {
            chess[r][c] = move;
            displayBoard(chess);
            System.exit(0);
        }
        chess[r][c] = move;
        KnightTour(chess, r - 2, c + 1, move + 1);
        KnightTour(chess, r - 1, c + 2, move + 1);
        KnightTour(chess, r + 1, c + 2, move + 1);
        KnightTour(chess, r + 2, c + 1, move + 1);
        KnightTour(chess, r + 2, c - 1, move + 1);
        KnightTour(chess, r + 1, c - 2, move + 1);
        KnightTour(chess, r - 1, c - 2, move + 1);
        KnightTour(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess + " ");
            }
            System.out.println();
        }
    }
}
