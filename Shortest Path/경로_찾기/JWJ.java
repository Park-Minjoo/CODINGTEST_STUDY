package org.woojin.shortpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PathFinding_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            @최단거리 - 플로이드 워셜
            모드 노드에서 다른 모든 노드까지 경로 확인 -> 플로이드 워셜 알고리즘
            https://chocochip125.tistory.com/197#플로이드_워셜_알고리즘

         */

        mySolution();
    }

    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[][] d = new int[n][n];

        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++){
                d[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for(int k=0; k<n; k++){
            for(int a=0; a<n; a++){
                for(int b=0; b<n; b++){
                    //핵심!) a -> k -> b 경로가 존재 한다 == 가중치 합이 2이다
                    if(d[a][k] + d[k][b] == 2){
                        d[a][b] = 1;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(d[i][j] + " ");

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void answerSolution(){


    }
}
