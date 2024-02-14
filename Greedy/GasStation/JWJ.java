package org.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JWJ {
    /*
      @1그리디 알고리즘
         현재 도시보다 작은 가격의 도시가 나오기 전까지 주유를 진행하면 최소 비용이 발생
         예외 없음
         https://chocochip125.tistory.com/178

      @2구간합
         도시 사이의 거리합을 계산할 때 구간합 배열을 활용
         https://chocochip125.tistory.com/146

     @3투 포인터
         현재 도시와 다음 도시를 비교하기 위해서 2개의 포인터를 활용
         https://chocochip125.tistory.com/153
    */

    public static void main(String[] args) throws IOException {

        // #입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        long[] km = new long[n];
        long[] s = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++){
            km[i] = km[i-1] + Long.valueOf(st.nextToken()); //@2 구간합
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            s[i] = Long.valueOf(st.nextToken());
        }
        // #입력

        long cost = 0;

        int i=0, j=1; //@3 투포인터

        while(j < n){
            //@1 그리디
            if(s[i] <= s[j]){
                j++;
            }
            else{
                cost += s[i] * ( km[j] - km[i] ); //@2 구간합
                i = j;
                j++;
            }
        }

        //예외처리) 마지막 도시까지 최소 비용 도시가 안나왔을 경우
        if(j == n){
            cost += s[i] * ( km[j-1] - km[i] );
        }

        System.out.println(cost);
    }

}
