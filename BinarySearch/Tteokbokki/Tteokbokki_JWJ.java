package org.woojin.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tteokbokki_JWJ {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        long m = Long.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] tteok = new long[n];
        long max = Long.MIN_VALUE;

        for(int i=0; i<n; i++){
            tteok[i] = Integer.valueOf(st.nextToken());

            if (max < tteok[i]) {
                max = tteok[i];
            }

        }

        long start = 0;
        long end = max;
        long mid, sum;

        long result = 0;

        while(start<=end){
            mid = (start + end) / 2;
            sum = 0;
            for(int i=0; i<n; i++){
                long temp = (tteok[i] - mid);
                sum += (temp > 0) ? temp : 0;
            }

            if(sum == m){
                result = mid;
                break;
            } else if (sum > m) {
                result = mid; //딱 떨어지는 부분이 없다면 최대한 많이 짜른게 정답
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
