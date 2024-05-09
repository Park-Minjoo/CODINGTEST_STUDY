import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제: 로또
 * 메모리: 65504 KB
 * 시간: 276 ms
 *
 * https://www.acmicpc.net/problem/2758
 */

public class Ksy {

    static boolean[] isVisited;
    static int answer = 0;

    // ----- dp 풀이 -----
    // 점화식이 생각이 안나서 다른 사람 풀이 참고
    // 참고 링크: https://kwoncorin.tistory.com/82
    private static long solution(int n, int m) {
        long[][] dp = new long[n + 1][m + 1]; //n 번째에 m 이하의 수가 올 수 있는 경우의 수
        Arrays.fill(dp[0], 1); // 초기화

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // A. 1부터 j-1까지의 숫자 중에서 선택하는 경우
                // B. X번째 수를 j로 선택하는 경우
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j / 2];
            }
        }

        return dp[n][m];
    }

    // ----- dfs 풀이 (시간 초과) -----
    private static int solution2(int n, int m) {
        isVisited = new boolean[m + 1];

        for (int i = 1; i <= m; i++) {
            isVisited[i] = true;
            dfs(n, m, i, 1);
            isVisited[i] = false;
        }

        return answer;
    }

    private static void dfs(int n, int m, int current, int count) {
        if (count == n) {
            answer++;
            return;
        }

        for (int i = current; i <= m; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(n, m, i * 2, count + 1);
                isVisited[i] = false;
            }
        }
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());

            for (int i = 0; i < t; i++) {
                String[] lottoInfo = reader.readLine().split(" ");
                int n = Integer.parseInt(lottoInfo[0]);
                int m = Integer.parseInt(lottoInfo[1]);

                System.out.println(solution(n, m));
            }
        }
    }
}
