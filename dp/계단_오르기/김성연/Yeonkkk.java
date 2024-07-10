import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yeonkkk {

    private static int solution(int n, int[] stairs) {
        int[] dp = new int[n];

        dp[0] = stairs[0];
        if (1 < n) {
            dp[1] = stairs[0] + stairs[1];
        }

        if (2 < n) {
            dp[2] = stairs[2] + Math.max(stairs[0], stairs[1]);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = stairs[i] + Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            int[] stairs = new int[n];

            for (int i = 0; i < n; i++) {
                stairs[i] = Integer.parseInt(reader.readLine());
            }

            System.out.println(solution(n, stairs));
        }
    }
}
