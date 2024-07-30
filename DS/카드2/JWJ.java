package org.woojin.ds;


import java.util.*;
import java.io.*;

public class 카드2{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //입력 끝


        //큐 준비
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            q.offer(i);
        }


        //큐 비우기
        int result = -1;
        int temp;
        while(!q.isEmpty()){
            result = q.poll();
            if(q.isEmpty()){
                break;


            }
            temp = q.poll();

            q.offer(temp);
        }

        //결과 출력
        System.out.print(result);


    }


}