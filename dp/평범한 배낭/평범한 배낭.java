import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품 수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[][] dp = new int[N + 1][K + 1];  // dp[아이템][무게수]

        int[] w = new int[N + 1];
        int[] v = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j]; // 이전 무게를 일단 가져온다
                if (j - w[i] >= 0) {  // 현재 무게 - 지금 아이템 무게 > 0
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]); // 이전 현재 무게를 뺀 이전 배낭
                }
            }
        }

        System.out.println(dp[N][K]);

    }

/*
4 7
6 13
4 8
3 6
5 12

 */
}
