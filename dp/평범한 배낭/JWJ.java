package org.woojin.dp;

import java.util.*;

public class 배낭문제 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int[] ws = new int[n+1];
        int[] vs = new int[n+1];

        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(sc.nextLine());

            ws[i]= Integer.valueOf(st.nextToken());
            vs[i] = Integer.valueOf(st.nextToken());

        }
        //입력끝


        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(ws[i] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-ws[i]] + vs[i]);
                }
            }
        }

        System.out.print(dp[n][k]);




    }
}
