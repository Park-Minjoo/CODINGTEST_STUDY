import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제: 상자넣기
 * 메모리: 14384 KB
 * 시간: 152 ms
 *
 * https://www.acmicpc.net/problem/1965
 */

public class Ksy {

    // ----- 최장 증가 부분 수열 -----
    private static int solution(int n, int[] boxes) {
        int maxCount = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxCount = Math.max(maxCount, dp[i]);
        }

        return maxCount;
    }

    // ---- stack 사용 풀이 틀림 ----
    private static int solution2(int n, int[] boxes) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int box : boxes) {
            while (!stack.isEmpty() && box <= stack.peekLast()) {
                stack.pollLast();
            }
            result = Math.max(stack.size() + 1, result);
            stack.add(box);
        }

        return result;
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] boxes = new int[n];

            for (int i = 0; i < n; i++) {
                boxes[i] = Integer.parseInt(tokenizer.nextToken());
            }

            System.out.println(solution(n, boxes));
        }
    }
}
