package dongbinna.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 금광
public class LeeMoonGi {


    public static void main(String[] args) throws IOException {
        mySolution();
    }


    /**
     *  이전 줄 3가지 방향 중 가장 큰거 선택
     *  마지막 줄에서 가장 큰 값이 정답
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 금광 높이 n
            int m = Integer.parseInt(st.nextToken()); // 금광 너비 m
            int[][] dp = new int[n][m];
            int[][] arr = new int[n][m];
            int result = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken()); // 금광 2차원 배열
                }
            }

            // 첫번째 줄 입력
            for (int j = 0; j < n; j++) {
                dp[j][0] = arr[j][0];
            }

            for (int j = 1; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    // 처음 즐
                    if (k == 0) {
                        dp[k][j] = Math.max(dp[k][j - 1], dp[k + 1][j - 1]) + arr[k][j];
                        continue;
                    }

                    // 마지막 줄
                    if (k == n - 1) {
                        dp[k][j] = Math.max(dp[k - 1][j - 1], dp[k][j - 1]) + arr[k][j];
                        continue;
                    }

                    dp[k][j] = Math.max(dp[k - 1][j - 1], Math.max(dp[k][j - 1], dp[k + 1][j - 1]) + arr[k][j]);
                }
            }

            // dp테이블 맨 마지막줄 중에 가장 큰값이 정답
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[j][m - 1]);
            }

            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }



}