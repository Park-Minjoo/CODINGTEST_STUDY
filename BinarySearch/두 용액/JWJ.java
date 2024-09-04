package org.woojin.search;

import java.util.*;

public class 두용액 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        long[] liqs = new long[n];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<n; i++){
            liqs[i] = Integer.valueOf(st.nextToken());
        }
        //입력끝

        //정렬
        Arrays.sort(liqs);

        //투포인터 + 이진탐색
        int s = 0, e = n-1, result_s = s, result_e = e;
        long result_min = Long.MAX_VALUE, temp;

        while(s<e) {
            temp = liqs[s] + liqs[e];

            //양수값이 쎈 경우 -> 오른쪽을 감소
            if (temp > 0) {
                if (temp < result_min) {
                    result_min = temp;
                    result_s = s;
                    result_e = e;
                }
                e -= 1;
            }
            //음수값이 쎈 경우 -> 왼쪽을 증가
            else if (temp < 0) {
                if ((temp * -1) < result_min) {
                    result_min = temp * -1;
                    result_s = s;
                    result_e = e;
                }
                s += 1;
            } else {
                result_s = s;
                result_e = e;
                break;
            }

        }

        System.out.println(liqs[result_s] + " " + liqs[result_e]);
    }
}