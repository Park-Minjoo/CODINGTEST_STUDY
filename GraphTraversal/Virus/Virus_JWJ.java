package org.woojin.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            @그래프 탐색
                그냥 문제 자체가 그래프 탐색임
                내 실수: 양방향 그래프에서는 양쪽을 서로 연결해줘야함
                https://chocochip125.tistory.com/180

         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n+1];

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());
            graph[key].add(value);
            graph[value].add(key); //실수) 양방향 그래프
        }


        Queue<Integer> s = new LinkedList<>();
        s.offer(1);
        visited[1] = true;

        int count = 0;

        while(!s.isEmpty()){
            int now = s.poll();

            for(int i=0; i<graph[now].size(); i++){
                int next = graph[now].get(i);
                if(!visited[next]){
                    s.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        System.out.print(count);


    }

}
