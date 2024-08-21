package org.woojin.dp;

import java.util.*;
import java.util.stream.Collectors;

public class 함께블록쌓기 {
    static int MOD = 10007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int h = Integer.valueOf(st.nextToken());

        List<List<Integer>> blocks = new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Integer> tmp = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            blocks.add(tmp);
        }
        //입력끝

        int dp[][] = new int[n+1][h+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        //dp[i][j] = dp[i-1][j] + dp[i-1][j - i선택값]
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=h; j++){
                dp[i][j] = dp[i-1][j]; // i번째 학생의 블록 사용x
                dp[i][j] %= MOD;

                for(int b : blocks.get(i-1)){ //i번째 학생의 b블록을 사용
                    if(j-b >= 0) {
                        dp[i][j] += dp[i-1][j-b];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        System.out.println(dp[n][h]);


    }
}
