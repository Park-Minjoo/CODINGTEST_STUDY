package org.woojin.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Check_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            구간합을 도대체 왜 사용하지...?
         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int q = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        //3~n+2번 학생
        boolean[] isSleep = new boolean[n+3];
        boolean[] isCheck = new boolean[n+3];

        //k명의 조는 학생 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k;i++){
            int s = Integer.valueOf(st.nextToken());
            isSleep[s] = true;
        }

        //q명의 학생 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<q; i++){
            int s = Integer.valueOf(st.nextToken());

            if(isSleep[s]){
                continue;
            }

            int j=s;
            int count = 2;
            while(j<=n+2){
                if(!isSleep[j]){
                    isCheck[j] = true;
                }
                j = s * count;
                count++;
            }
        }

        //s~e범위 내에 출석을 하지 못한 학생 결과 출력 - m번 반복
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<m; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int result = 0;
            for (int i = s; i <= e; i++) {
                if (!isCheck[i]) {
                    result++;
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
