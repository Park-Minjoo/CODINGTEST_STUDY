package org.woojin.search;

import java.util.*;

public class 나무자르기2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.valueOf(st.nextToken());
        long m = Long.valueOf(st.nextToken());

        int[] trees = new int[n];

        st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<n; i++){
            trees[i] = Integer.valueOf(st.nextToken());
        }
        //입력완

        long temp;
        //mid = H를 의미
        long start = 0, end = 1000000000, mid;

        long result = -1;

        while (start <= end){
            temp = 0;
            mid = (start + end) / 2;

            for(int t : trees){
                long now = t - mid;
                if(now > 0) temp += now;
            }

            if(temp >=  m){
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(result);


    }
}
