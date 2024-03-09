package org.woojin.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Soldier_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
                내림 차순 정렬을 망치는 병사를 열외 시키는 것
                    항상 작은 전투력을 가진 애를 제거 -> ㄴㄴ
                    큰 병사 하나로 여려명이 빠져야 한다면

                이동기준
                15 11 4  2   8  5  4 ->  15 11 8 5 4
                    1. 새로 들어온 병사가 2명 이상 앞으로 가야할 경우 -> 새로 들어온 병사를 친다
                    -> ㄴㄴ 너무 앞 -> 15 11 4 2 오답
         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> soldier = new ArrayList<>();

        for(int i =0; i<n; i++) {
            soldier.add(Integer.valueOf(st.nextToken()));

        }
        //---------입력 끝
        Collections.reverse(soldier);

        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(soldier.get(j) < soldier.get(i)){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxValue = 0;
        for(int i=0; i<n; i++){
            if(maxValue < dp[i]){
                maxValue = dp[i];
            }
        }

        System.out.println(n - maxValue);
    }

}
