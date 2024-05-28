package org.woojin.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            투포인터 - 슬라이딩 윈도우 - https://chocochip125.tistory.com/155
            특정 범위를 지속해서 탐색을 진행
         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int[] num = new int[n];
        int x = Integer.valueOf(st.nextToken());

        int sum = 0, max;
        int count = 1;

        st = new StringTokenizer(br.readLine());
        //처음에 윈도우 범위만큼 초기화
        for(int i=0; i<x; i++){
            num[i] = Integer.valueOf(st.nextToken());
            sum += num[i];
        }
        max = sum;

        //그 후 윈도우를 이동시키면서 진행
        for(int i=x; i<n; i++){
            num[i] = Integer.valueOf(st.nextToken());
            sum -= num[i-x];
            sum += num[i];
            if(max < sum) {
                max = sum;
                count = 1;
            } else if (max == sum) {
                count += 1;
            }
        }
        if(max == 0){
            System.out.println("SAD");
        } else{
            System.out.println(max + "\n" + count);
        }

    }
}
/*
5 5
1 4 2 5 1
 */