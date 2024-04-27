import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 포도주 시식
 * 메모리: 14960 KB
 * 시간: 148 ms
 *
 * https://www.acmicpc.net/problem/2156
 */

public class Ksy {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] wines = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                wines[i] = Integer.parseInt(reader.readLine());
            }

            System.out.println(solution(n, wines));
        }
    }

    private static int solution(int n, int[] wines) {
        if (n == 1) {
            return wines[1];
        }

        int[] dp = new int[n + 1];
        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1], // 현재의 와인을 마실 필요 없음
                    Math.max(wines[i] + dp[i - 2], wines[i] + wines[i - 1] + dp[i - 3])
            );
        }

        return dp[n];
    }
}
