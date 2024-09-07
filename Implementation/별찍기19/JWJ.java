package org.woojin.impl;

import java.util.*;

public class Star_JWJ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //1 예외처리
        if(n==1){
            System.out.println("*");
            return;
        }

        //가로: 5, 5+4, 5+4+4 -> 5 + 4*(n-1)
        //세로: '' -> 5 + 4*(n-1)
        int max_length = 5 + 4*(n-2);
        int half = max_length / 2;

        boolean[][] checked = new boolean[max_length][max_length];
        int depth = 0;


        // 투포인터로 접근 + 대칭인점을 활용하여 반만 처리
        for(int i=0; i<=half; i++){
            int max_count1 = 0 + depth;
            int max_count2 = 1 + depth;
            int now_count = 0, j = 0;
            int s = 0;
            int e = max_length - 1;

            if(i%2 == 0){
                while(s<e){
                    if(j%2 == 1 && ( now_count != max_count1 )){
                        now_count++;
                    }
                    else {
                        checked[i][s] = true;
                        checked[i][e] = true;
                    }
                    j++;
                    s++;
                    e--;
                }

                checked[i][half] = true;
            }
            else{
                while(s<e){
                    if(j%2 == 0){
                        checked[i][s] = true;
                        checked[i][e] = true;
                        now_count++;

                        if(now_count == max_count2){
                            break;
                        }
                    }
                    j++;
                    s++;
                    e--;
                }
                depth++;
            }
        }

        //출력 부분
        StringBuilder sb = new StringBuilder();
        checked[half][half] = true;

        //위쪽 부분 출력
        for(int i=0; i<half; i++){
            for(int j=0; j<max_length; j++){
                if(checked[i][j]){
                    sb.append("*");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        //아래쪽 부분 출력(대칭 활용)
        for(int i=half; i>=0; i--){
            for(int j=0; j<max_length; j++){
                if(checked[i][j]){
                    sb.append("*");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
