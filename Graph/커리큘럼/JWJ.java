package org.woojin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Curriculum_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
         */
        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[] indegree = new int[n+1];
        ArrayList<ArrayList<Integer>> graphs = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graphs.add(new ArrayList<>());
        }

        int[] time = new int[n+1];
        int[] pre_time = new int[n+1];
        StringTokenizer st;
        int a;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.valueOf(st.nextToken());

            while(true){
                a = Integer.valueOf(st.nextToken());

                if(a == -1){
                    break;
                }
                graphs.get(a).add(i);
                indegree[i] += 1;
            };
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graphs.get(now).size(); i++) {
                int next = graphs.get(now).get(i);

                if(pre_time[next] < time[now]){
                    pre_time[next] = time[now];
                }

                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.offer(next);
                    time[next] += pre_time[next];
                }


            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(time[i] + "\n");
        }
        System.out.println(sb);
    }
}
/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
*/