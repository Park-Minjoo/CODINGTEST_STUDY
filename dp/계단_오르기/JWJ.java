package org.woojin.dp;

import java.io.IOException;
import java.util.Scanner;

public class Stairs_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
                이전 선택지가 계속해서 누적되는 상태 + 그리디로 해결 불가능 -> dp 알고리즘
                https://chocochip125.tistory.com/196
         */

        //mySolution();
        answerSolution();
    }


    public static void mySolution() throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stairs = new int[n+1];

        for(int i=1; i<=n; i++){
            stairs[i] = sc.nextInt();
        }
        //입력 끝

        long[] dp = new long[n+1];
        dp[1] = stairs[1];
        int count = 0;

        for(int i=2; i<=n; i++){
            count++;

            //연속 3계단의 경우
            // - i를 포함시키지 않을 경우 + 마지막 계단의 경우 예외처리
            //- 그이전(i-2)에서 오는 경우
            if(count >= 3){
                if(i == n){
                    dp[i] = stairs[i] + dp[i-2];
                }
                else{
                    dp[i] = Math.max(stairs[i] + dp[i-2], dp[i-1]);
                }
                count = 0;
            }
            //연속 3계단이 아닌 경우
            //- 이전 (i-1)에서 오는 경우
            //- 그이전(i-2)에서 오는 경우
            else {
                //동일하다면 2칸 뛰어넘는게 이득
                if (dp[i - 1] > dp[i - 2]) {
                    dp[i] = stairs[i] + dp[i - 1];
                    count++;
                } else {
                    dp[i] = stairs[i] + dp[i - 2];
                    count = 0;
                }
            }
        }

        System.out.println(dp[n]);
    }

    public static void answerSolution(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stairs = new int[n+1];

        for(int i=1; i<=n; i++){
            stairs[i] = sc.nextInt();
        }
        //입력 끝

        long[] dp = new long[n+1];
        dp[1] = stairs[1];
        if(n >= 2) { //예외처리) n값이 2미만인 경우
            dp[2] = stairs[1] + stairs[2];
        }

        //점화식
        // - dp[i-2] + stairs[i] => 그이전 계단에서 오는 경우
        // - dp[i-3] + stairs[i-1] + stairs[i-2] => 이전 계단에서 오는 경우
        // ㄴ 이전 계단에서 왔다면 반드시 그이전은 i-3가 되야함
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}
