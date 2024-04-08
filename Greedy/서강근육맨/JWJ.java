package org.woojin.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Muscle_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            1. 정렬
            운동기구 순서(인덱스) 상관이 없음 -> 정렬 진행

            2. 그리디
            2개의 조합중 가장 큰 값을 찾으면 그것이 최적의 해


         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Long> arr = new ArrayList<>();

        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr.add(Long.valueOf(st.nextToken()));
        }

        Collections.sort(arr);

        ArrayList<Long> result = new ArrayList<>();
        if(n%2 == 0){
            for(int i=0; i<n/2; i++){
                result.add(arr.get(i) + arr.get(n-1 - i));
            }
        } else {
            result.add(arr.get(n-1));

            for(int i=0; i<(n-1)/2; i++){
                result.add(arr.get(i) + arr.get(n-2 - i));
            }
        }
        System.out.print(Collections.max(result));

    }

}
/*
5
1 1 2 3 5

5
5 2 4 1 1

6
0 1 2 3 4 6


 */