package org.woojin.etc;

import java.io.IOException;
import java.util.Scanner;

public class primeNumber_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            @소수 판별
            소수 판별 알고리즘 2개중에 입력값이 매우 크므로 메모리를 많이 잡아먹는
            에라토스테네스의 알고리즘은 배제
            1번으로 진행
            +0,1 예외처리 진행

            @long 자료형 사용: 입력값이 매우 크므로 long으로 진행
         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            long m = sc.nextLong();

            long j = m;
            while(!isPrimeNum(j)){
                j++;
            }
            sb.append(j + "\n");
        }
        System.out.println(sb);

    }

    public static boolean isPrimeNum(long x){
        if(x <= 1){ //0,1예외 처리
            return false;
        }

        //2부터 x의 제곱근까지만 모든 수를 확인
        for(long i=2; i<=Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
