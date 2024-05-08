package org.woojin.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jump_JWJ {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[][] game = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                game[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] != 0){
                    int m = game[i][j];

                    if(m == 0){
                        continue;
                    }

                    if(j+m < n){
                        dp[i][j+m] += dp[i][j];
                    }
                    if(i+m < n){
                        dp[i+m][j] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1]);

    }

}
