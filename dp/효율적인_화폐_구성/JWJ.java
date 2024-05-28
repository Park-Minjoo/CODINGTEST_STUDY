package org.woojin.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MakeMoney_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review

         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        //입력
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] money = new int[n];

        for(int i=0; i<n; i++){
            money[i] = sc.nextInt();
        }

        int[] dp = new int[m+1];

        for(int i=1; i<=m; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<n; j++){

                int prev = i - money[j];
                if(prev >= 0) {
                   if(dp[prev] >= 0){
                       temp.add(dp[prev] + 1);
                       continue;
                   }
                }
                temp.add(Integer.MAX_VALUE);
            }

            int min = Collections.min(temp);

            if(min == Integer.MAX_VALUE){
                dp[i] = -1;
            } else{
                dp[i] = min;
            }
        }

        System.out.println(dp[m]);

    }

}
