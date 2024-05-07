import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 점프
 * 메모리: 14296 KB
 * 시간: 128 ms
 *
 * https://www.acmicpc.net/problem/1890
 */
public class Ksy {

    private static long solution(int n, int[][] board) {
        long[][] dp = new long[n][n];
//        move(n, board, dp, 0, 0);
        move(n, board, dp);

        return dp[n - 1][n - 1];
    }

    private static void move(int n, int[][]board, long[][] dp) {
        dp[0][0] = 1;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int currentPoint = board[x][y];

                if (currentPoint == 0) {
                    return;
                }

                if (x + currentPoint < n) {
                    dp[x + currentPoint][y] += dp[x][y];
                }

                if (y + currentPoint < n) {
                    dp[x][y + currentPoint] += dp[x][y];
                }
            }
        }
    }

    // ----- 시간 초과 -----
    private static void move(int n, int[][] board, long[][] dp, int x, int y) {
        int currentPoint = board[x][y];
        dp[x][y] += 1;

        if (currentPoint == 0) {
            return;
        }

        if (x + currentPoint < n) {
            move(n, board, dp, x + currentPoint, y);
        }

        if (y + currentPoint < n) {
            move(n, board, dp, x, y + currentPoint);
        }
    }

    // ------ 입출력 ------
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(line[j]);
                }
            }

            System.out.println(solution(n, board));
        }
    }
}
