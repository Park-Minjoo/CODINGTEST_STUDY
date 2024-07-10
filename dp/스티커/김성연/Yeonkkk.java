import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yeonkkk {

    private static int solution(int n, int[][] stickers) {
        int[][] dp = new int[2][n];

        dp[0][0] = stickers[0][0];
        dp[1][0] = stickers[1][0];

        if (1 < n) {
            dp[0][1] = stickers[0][1] + stickers[1][0];
            dp[1][1] = stickers[1][1] + stickers[0][0];
        }

        for (int i = 2; i < n; i++) {
            // 1층
            dp[0][i] = stickers[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);

            // 2층
            dp[1][i] = stickers[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
        }

        return Math.max(dp[0][n-1], dp[1][n-1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int t = Integer.parseInt(reader.readLine());

            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(reader.readLine());
                int[][] stickers = new int[2][n];

                for (int j = 0; j < 2; j++) {
                    String[] line = reader.readLine().split(" ");

                    for (int k = 0; k < n; k++) {
                        stickers[j][k] = Integer.parseInt(line[k]);
                    }
                }

                System.out.println(solution(n, stickers));
            }
        }
    }
}
