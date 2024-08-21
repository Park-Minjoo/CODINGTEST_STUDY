import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, H;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[N+1][H+1];

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=H; j++) {
                dp[i][j] = dp[i-1][j];
            }
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                dp[i][n] += 1;
                for (int j=0; j<=H; j++) {
                    if (n > j) continue;
                    dp[i][j] = (dp[i][j] + dp[i-1][j-n]) % 10007;
                }
            }
        }
        System.out.println(dp[N][H]);
    }
}
