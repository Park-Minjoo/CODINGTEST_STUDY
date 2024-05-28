package org.woojin.dp;
import java.io.*;
import java.util.StringTokenizer;


public class Lotto_JWJ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());

        int n, m;
        long result=0;
        long [][] dp = new long [11][4001];

        for(int j=1; j<=4000; j++){
            dp[1][j] = 1;
        }

        for(int j=2; j<=10; j++){
            for(int k=1; k<=4000;k++){
                if(dp[j-1][k]!=0){
                    for(int q =k*2; q<=4000; q++){
                        dp[j][q] += dp[j-1][k];
                    }
                }
            }
        }

        StringTokenizer st;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.valueOf(st.nextToken());
            m = Integer.valueOf(st.nextToken());
            result=0;
            for(int k=1; k<=m; k++){
                result+=dp[n][k];
            }
            System.out.println(result);
        }
    }
}