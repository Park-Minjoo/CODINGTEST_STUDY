import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 평범한 배낭
 * 메모리: 53852 KB
 * 시간: 188 ms
 *
 * https://www.acmicpc.net/problem/12865
 */


public class Ksy {

    static class Item {

        private final int weight;
        private final int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    private static int solution(int n, int k, Item[] items) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i < n + 1; i++) {
            Item item = items[i-1];

            for (int j = 1; j < k + 1; j++) {
                if (j < item.weight) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j - item.weight] + item.value, dp[i-1][j]);
            }
        }

        return dp[n][k];
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            Item[] items = new Item[n];

            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int weight = Integer.parseInt(tokenizer.nextToken());
                int value = Integer.parseInt(tokenizer.nextToken());

                items[i] = new Item(weight, value);
            }

            System.out.println(solution(n, k, items));
        }
    }
}
