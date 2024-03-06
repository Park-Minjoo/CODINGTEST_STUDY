package org.woojin.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CutTree {
    public static void main(String[] args) throws IOException {
        /*
        문제 review
            @이진 탐색
            특정 범위에서 특정 조건을 만족하는 값 찾기 -> 파라메트릭 서치 -> 이진탐색 적용
            https://chocochip125.tistory.com/193

            @자료형 문제
            정수 범위가 크다면 int가 아닌 long을 사용하자!
         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.valueOf(st.nextToken());
        long m = Long.valueOf(st.nextToken());

        ArrayList<Long> trees = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trees.add(Long.valueOf(st.nextToken()));
        }
        //입력 끝

        long start = 0;
        long end = Collections.max(trees);
        long mid, sum;
        long result = -1;

        while(start <= end){
            sum = 0;
            mid = (start + end) / 2;

            for(int k=0; k<n; k++){
                if( trees.get(k) - mid > 0){
                    sum += trees.get(k) - mid;
                }
            }

            if(sum >= m){
                result = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
