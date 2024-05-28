package org.woojin.dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MakeOne_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            여러가지 선택지가 있는데, 가장 최적의 것을 골라서 문제가 안풀린다면
            이전에 선택한 최선의 선택을 저장하는 다이나믹 해결법으로 진행
         */

        mySolution();
    }

    static int[] dp;

    public static void mySolution() throws IOException {
        //입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n+1];

        for(int i=2; i<=n; i++){
            //1뺀거
            dp[i] = dp[i-1] + 1;

            //5로 나누기
            if(i % 5 == 0){
                dp[i] = Math.min(dp[i], dp[i/5] + 1);
            }

            //3로 나누기
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }

            //2로 나누기
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }

        System.out.println(dp[n]);

    }

}
