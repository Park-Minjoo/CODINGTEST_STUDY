package org.woojin.impl;

import java.io.IOException;
import java.util.Scanner;

public class Snail_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            1. 방향 벡터
                2차원 배열에서 이동 방향이 정해져있다 -> 방향 벡터를 사용해서 풀자
                https://chocochip125.tistory.com/179#방향_벡터

            2. 빠른 출력
                처음에는 단순히 System.out.print로 처리를 하려고 했는데, 시간초과가 발생했다.
                해당 문제처럼 출력을 여러번 할때는 빠른 출력 기술을 사용하자
                https://chocochip125.tistory.com/191

            +) 잡기술
                특정 범위의 수를 반복할 때, 사용하는 기법
                https://chocochip125.tistory.com/192

         */

        mySolution();
    }


    public static void mySolution(){
        //입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int place = sc.nextInt();

        //1. 방향 벡터 사용
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int d_index = 0;

        // 방향 벡터 변화 기준
        int enter = n;
        int count = 0;

        int[][] r = new int[n][n];

        int nx = 0, ny = 0;
        int rx = 0, ry = 0;

        for(int i=n*n; i>=1; i--){

            r[nx][ny] = i;
            count++;

            if( count % enter == 0){
                count = 0;

                // 아래로 진행할때, 위로 진행할때 엔터 기준을 1씩 감소시킬 필요가 있음
                if(d_index == 0){
                    enter -= 1;
                } else if (d_index == 2) {
                    enter -= 1;
                }

                d_index = (d_index + 1) % 4; // 잡기술) 0~3 숫자 반복하게 하는 스킬

            }

            if(i == place){
                rx = nx + 1;
                ry = ny + 1;
            }

            nx += dx[d_index];
            ny += dy[d_index];

        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < n; i++){
            for(int j=0; j<n; j++){
                sb.append(r[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(rx + " " + ry);
        System.out.println(sb);
    }
}
