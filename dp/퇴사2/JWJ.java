package org.woojin.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retire_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
        dp 테이블은 반드시 이전 값만(i-1)가지고 갱신하는 것이 아니라
        다음 값(i+1) 갱신도 가능하다.
         */

        mySolution();
    }


    public static void mySolution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] T = new int[n+2];
        int[] P = new int[n+2];
        int[] dp = new int[n+2];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.valueOf(st.nextToken());
            P[i] = Integer.valueOf(st.nextToken());
        }

        int max = -1;
        //dp[i + T[i]] = max(dp[i + T[i]), max P[i] )
        for(int i=1; i<n+2; i++){
            if(max < dp[i]){
                max = dp[i];
            }
            int next = i + T[i];
            if(next < n+2){
                dp[next] = Math.max(dp[next],  max + P[i]);
            }
        }

        System.out.println(dp[n+1]);
    }
}
