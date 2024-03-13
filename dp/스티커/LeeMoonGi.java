import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커 9465번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     * dp[0][] 위쪽 스티커 선택됨
     * dp[1][] 아래쪽 스티커 선택됨
     *
     * 위쪽이 선택된 경우 2가지 방법
     *      대각선 오른쪽이 선택된 경우
     *      대간선 오른쪽 오른쪽이 선택된 경우
     *      이 두값중 큰값
     *
     * 아래쪽도 마찬가지
     *
     * dp[1][n] dp[0][n] 둘중 큰값이 정답
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        int result = 0;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // n
            int[][] arr = new int[2][Math.max(n + 1, 4)]; // out of index 방지
            int[][] dp = new int[2][Math.max(n + 1, 4)];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 1; i < n + 1; i++) {
                arr[0][i] = Integer.parseInt(st1.nextToken());
                arr[1][i] = Integer.parseInt(st2.nextToken());
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i-2]) + arr[1][i];
            }

            result = Math.max(dp[0][n], dp[1][n]);
            sb.append(result + "\n");
        }
        System.out.println(sb.toString());
    }
}

/**
 */