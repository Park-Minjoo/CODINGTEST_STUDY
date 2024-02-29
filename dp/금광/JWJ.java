package org.woojin.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Gold_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            @1. 다이나믹 알고리즘
                현재 주어진 상황에서 최선의 상태만 고르면 답이 나오는가? -> x
                -> 이전 상태가 누적해서 진행하므로 이전 선택을 저장하는 다이나믹 알고리즘으로 진행

            @2. 방향벡터
                이차원 배열에서 진행방향이 정해져 있으므로 방향벡터 사용
                https://chocochip125.tistory.com/179#방향_벡터
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        for(int i=0; i<t; i++) {
            mySolution();
        }
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[][] gold = new int[n][m];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                gold[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        //------------입력 끝

        //1. dp 테이블 사용
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){ //dp 테이블 초기화
            dp[i][0] = gold[i][0];
        }

        //2. 방향 벡터
        //위, 중앙, 아래
        int[] dx = {-1, 0, 1};
        int nx;

        for(int j=1; j<m; j++){
            for(int i=0; i<n; i++){

                // 점화식: dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1])
                ArrayList<Integer> temp = new ArrayList<>();
                for(int k=0; k<3; k++){
                    nx = i + dx[k];
                    if(nx >= 0 && nx < n){
                       temp.add(dp[nx][j-1] + gold[i][j]);
                    }
                }

                //3. 배열 최대값 찾기
                dp[i][j] = Collections.max(temp);
            }
        }

        //3. 배열 최대값 찾기
        //dp의 마지막 배열에서 가장 큰 값이 정답
        int result = dp[0][m-1];
        for(int i=1; i<n; i++){
            if(dp[i][m-1] > result){
                result = dp[i][m-1];
            }
        }
        System.out.println(result);

//        //디버기용
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                sb.append(dp[i][j] + " ");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb);

    }
}

/*
입력
1
3 4
1 3 3 2 2 1 4 1 0 6 4 7

 */
