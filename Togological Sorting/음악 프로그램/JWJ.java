package org.woojin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Music_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review

         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] indegree = new int[n+1]; //위상정렬 진입차수 테이블

        // 위상정렬 그래프 2차원 테이블
        ArrayList<ArrayList<Integer>> graphs = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graphs.add(new ArrayList<>());
        }

        // 입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(st.nextToken());
            int pre = Integer.valueOf(st.nextToken());

            for(int j=1; j<num; j++){
                int now = Integer.valueOf(st.nextToken());

                // 진입차수 및 그래프 테이블 업데이트
                indegree[now] += 1;
                graphs.get(pre).add(now);
                pre = now;
            }
        }

        // 위상정렬 큐 준비
        Queue<Integer> q = new LinkedList<>();

        // 진입차수 0인 노드 큐에 삽입
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now + "\n"); //큐에서 나온 순서가 위상정렬 정답
            count++;

            for(int i=0; i<graphs.get(now).size(); i++){
                int next = graphs.get(now).get(i);
                indegree[next] -= 1;

                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        // 위상정렬 예외처리: 모든 노드가 다 나오기 전에 종료된다면, 사이클이 존재
        // 즉, 정답이 없다는 의미
        if(count == n){
            System.out.println(sb);
        }
        else {
            System.out.println(0);
        }

    }

    public static void answerSolution(){


    }
}
/*
6 3
3 1 4 3
4 6 2 5 4
2 2 3

6 3
3 1 4 3
4 6 2 5 4
2 3 2
 */
