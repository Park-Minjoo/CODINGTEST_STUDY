package org.woojin.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ant_JWJ {

    public static void main(String[] args) throws IOException {
        /*
            문제 review

         */

        mySolution();
    }


    public static void mySolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[n];

        dp[0] = Integer.valueOf(st.nextToken());
        int food= Integer.valueOf(st.nextToken());
        dp[1] = (food > dp[0]) ? food: dp[0];

        for(int i=2; i<n; i++){
            food = Integer.valueOf(st.nextToken());

            if(dp[i-1] > dp[i-2] + food){
                dp[i] = dp[i-1];
            } else{
                dp[i] = dp[i-2] + food;
            }
        }

        System.out.println(dp[n-1]);
    }
}
