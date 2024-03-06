package org.woojin.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.StringTokenizer;

public class Sticker_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review

            dp[i]의 의미는 i번째 상황에서 최적의 해가 아니라 i번째 선택했을 때 최적의 해를 의미?
            -> 해당 문제에서 dp[i][j]는 i번째 줄의 j번째 스티커를 선택했을 때 최대값을 의미 ( 핵심은 (i,j)를 반드시 선택하는 것 )


         */

        //mySolution();
        answerSolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        for(int q=0; q<t; q++){
            int n = Integer.valueOf(br.readLine());

            int[][] s = new int[3][n+2];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                s[1][i] = Integer.valueOf(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                s[2][i] = Integer.valueOf(st.nextToken());
            }
            //입력 끝

            int[][] dp = new int[3][n+2];

            int top = s[1][1] + s[2][2];
            int bottom = s[2][1] + s[2][1];

            if(top > bottom){
                dp[1][1] = s[1][1];
            } else {
                dp[2][1] = s[2][1];
            }

            dp[1][1] = s[1][1];
            dp[2][1] = s[2][1];

            //점화식
            // - 위의 스티커를 뜯는 경우: dp[2][i-1] + s[1][i]
            // -> dp[1][i] = dp[2][i-1] + s[1][i]
            // -> dp[2][i] = d[2][i-1]
            // - 밑의 스티커를 뜯는 경우: dp[1][i-1] + s[2][i]
            // -> dp[2][i] = dp[1][i-1] + s[2][i]
            // -> dp[1][i] = dp[1][i-
            // + 아예 안때는 경우

            int nothing;
            for(int i=2; i<=n; i++) {
                top = dp[1][i-2] + s[2][i-1] + s[1][i] + s[2][i+1];
                bottom = dp[2][i-2] + s[1][i-1] + s[2][i] + s[1][i+1];
                nothing = Math.max(dp[1][i-1], dp[2][i-1]) + Math.max(s[1][i+1], s[2][i+1]);

                if(nothing > Math.max(top, bottom)){
                    dp[1][i] = Math.max(dp[1][i-1], dp[2][i-1]);
                    dp[2][i] = Math.max(dp[1][i-1], dp[2][i-1]);

                    dp[1][i+1] = Math.max(dp[1][i-1], dp[2][i-1]) + s[1][i+1];
                    dp[2][i+1] = Math.max(dp[1][i-1], dp[2][i-1]) + s[2][i+1];

                    i += 1;
                    continue;
                }

                if(top > bottom){
                    dp[1][i] = dp[1][i-2] + s[2][i-1] + s[1][i];
                    dp[2][i] = dp[1][i-2] + s[2][i-1];
                } else {
                    dp[2][i] = dp[2][i-2] + s[1][i-1] + s[2][i];
                    dp[1][i] = dp[2][i-2] + s[1][i-1];
                }
            }

            System.out.println(Math.max(dp[1][n], dp[2][n]));


        }


    }

    public static void answerSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        for(int q=0; q<t; q++) {
            int n = Integer.valueOf(br.readLine());

            int[][] s = new int[3][n + 2];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                s[1][i] = Integer.valueOf(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                s[2][i] = Integer.valueOf(st.nextToken());
            }
            //입력 끝

            int[][] dp = new int[3][n + 2];

            dp[1][1] = s[1][1];
            dp[2][1] = s[2][1];

            for(int i=2; i<=n; i++){
                dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + s[1][i];
                dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + s[2][i];
            }

            System.out.println(Math.max(dp[1][n], dp[2][n]));

        }


    }
}

