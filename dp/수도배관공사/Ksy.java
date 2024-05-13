import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 수도배관공사
 * 메모리: 14772 KB
 * 시간: 180 ms
 * 문제 링크: https://www.acmicpc.net/problem/2073
 *
 * 점화식이 안 떠올라서 다른 사람 풀이 참고
 * 참고 링크1: https://kwoncorin.tistory.com/83
 * 참고 링크2: https://sookr5416.tistory.com/290
 */

public class Ksy {

    static class Pipe {

        private final int length;
        private final int capacity;

        Pipe(int length, int capacity) {
            this.length = length;
            this.capacity = capacity;
        }
    }

    private static int solution(int d, int p, Pipe[] pipes) {
        int[] dp = new int[d + 1];
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < p; i++) {
            Pipe pipe = pipes[i];

            for (int j = d; j >= pipe.length; j--) {
                dp[j] = Math.max(dp[j], Math.min(pipe.capacity, dp[j - pipe.length]));
            }
        }

        return dp[d];
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int d = Integer.parseInt(tokenizer.nextToken());
            int p = Integer.parseInt(tokenizer.nextToken());
            Pipe[] pipes = new Pipe[p];

            for (int i = 0; i < p; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int length = Integer.parseInt(tokenizer.nextToken());
                int capacity = Integer.parseInt(tokenizer.nextToken());

                pipes[i] = new Pipe(length, capacity);
            }

            System.out.println(solution(d, p, pipes));
        }
    }
}
