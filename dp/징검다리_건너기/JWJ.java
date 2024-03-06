package org.woojin.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StoneBridge_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
                @dp
                    이전 선택들이 누적되서 진행 + 그리디 기법으로 최적해 불가능 -> dp

                @dp - 예외상황
                    dp 테이블은 기본적으로 이전 선택이 가장 최적의 해라는 것을 전제로 진행을 하는데
                    특별한 예외 상황으로 이전 선택이 최적의 해를 보장하지 못하는 경우
                    ex) 전체 선택중에 단 한번만 선택을 할 수 있는 경우

                    **해결책**: 아래 2상황에 대한 dp 테이블을 각각 생성
                        - 예외 상황이 발생한 경우
                        - 예외 상황이 발생하지 않은 경우
         */

        //mySolution();
        answerSolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[] small = new int[n];
        int[] big = new int[n];

        StringTokenizer st;

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());

            small[i] = Integer.valueOf(st.nextToken());
            big[i] = Integer.valueOf(st.nextToken());
        }

        int k = Integer.valueOf(br.readLine());
        //입력 끝

        int[] dp = new int[n+1];
        int[] dp2 = new int[n+1];

        dp[2] = small[1];
        if(n>2) {
            dp[3] = Math.min(dp[2] + small[2], big[1]);
        }

        int used_index = -1;
        int max_gap = 0;

        //dp[i] = min( dp[i-2] + small[i-1], dp[i-2] + big[i-2])
        // 가장 큰 점프: dp[i-3] + k
        // 가장 큰 차이를 낼 수 있는 곳을 탐색하고 해당 부분 이후부터 다시 dp 테이블을 생성하는 전략 -> 왜 안되징
        for(int i=4; i<=n; i++){
            int min = Math.min(dp[i-1] + small[i-1], dp[i-2] + big[i-2]);

            //가장 큰 차이를 낼 수 있는 위치(인덱스) 저장
            if(min > dp[i-3] + k){
                int gap = min - (dp[i-3] + k);
                if(max_gap < gap){
                    max_gap = gap;
                    used_index = i;
                }
            }
            dp[i] = min;
        }

        //가장 큰 점프를 할 수 있는 곳이 있다면 해당 부분을 다시 초기화
        if(used_index != -1){
            dp[used_index] = dp[used_index-3] + k;

            if(used_index + 1 <= n){
                dp[used_index + 1] = dp[used_index] + small[used_index];
            }

            for(int i=used_index + 2; i<=n; i++){
                int min = Math.min(dp[i-1] + small[i-1], dp[i-2] + big[i-2]);
                dp[i] = min;
            }
        }

        System.out.println(dp[n]);

    }

    public static void answerSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[] small = new int[n];
        int[] big = new int[n];

        StringTokenizer st;

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());

            small[i] = Integer.valueOf(st.nextToken());
            big[i] = Integer.valueOf(st.nextToken());
        }

        int k = Integer.valueOf(br.readLine());
        //입력 끝

        int[] dp = new int[n+1]; // 가장 큰 점프를 사용하지 않은 경우
        int[] dp2 = new int[n+1]; // 사용한 경우

        if(n>1) {
            dp[2] = small[1];
            dp2[2] = dp[2];
        }
        if(n>2) {
            dp[3] = Math.min(dp[2] + small[2], big[1]);
            dp2[3] = dp[3];
        }

        for(int i=4; i<=n; i++){
            dp[i] = Math.min(dp[i-1] + small[i-1], dp[i-2] + big[i-2]);
            dp2[i] = Math.min(dp[i-3] + k, Math.min(dp2[i-1] + small[i-1], dp2[i-2] + big[i-2]));
        }

        System.out.println(Math.min(dp[n], dp2[n]));

    }
}
