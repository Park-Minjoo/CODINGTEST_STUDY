import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 징검다리 건너기 21317번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     * ***오답
     *
     * dp[x][] : x는 슈퍼점프를 한 횟수
     *
     * dp[0][i]
     *              1. dp[0][i-1] + small[i]
     *              2. dp[0][i-2] + big[i]
     *
     * dp[1][i]
     *              1. dp[1][i-1] + small[i]
     *              2. dp[1][i-2] + big[i]
     *              3. dp[0][i-3] + supperJump
     *
     *
     * 이중에 가장 작은 값이 정답
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) - 1;

        int[] smallJump = new int[Math.max(4, n + 1)]; // OutOfIndex 방지
        int[] bigJump = new int[Math.max(4, n + 1)];
        int[][] dp = new int[2][Math.max(4, n + 1)]; // dp[x][] x-> 슈퍼점프 횟수

        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split(" ");
            smallJump[i] = Integer.parseInt(split[0]);
            bigJump[i] = Integer.parseInt(split[1]);
        }

        int k = Integer.parseInt(br.readLine());

        for (int[] row : dp) {
            Arrays.fill(row, 50000);
        }

        dp[0][0] = 0;
        dp[0][1] = smallJump[1];
        dp[0][2] = Math.min(dp[0][1] + smallJump[2], dp[0][0] + bigJump[2]);

        for (int i = 3; i <= n; i++) {
            dp[0][i] = Math.min(dp[0][i - 1] + smallJump[i], dp[0][i - 2] + bigJump[i]);
            dp[0][i] = Math.min(dp[1][i - 1] + smallJump[i],
                    Math.min(dp[1][i - 2] + bigJump[i],
                            dp[0][i - 3] + k));
        }

        System.out.println(Math.min(dp[0][n], dp[1][n]));
    }
}

/**
 */