package org.woojin.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LCA_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            문제 자체가 그냥 LCA를 활용하는 문제

            내 실수:
              1. 트리를 방향 그래프로 연결한 것 (한쪽 방향만 연결함)
              2. 부모 테이블은 makedepth를 진행할때 만들 것( 입력받을때 아님 )

         */

        mySolution();
    }

    static int[] parent;
    static int[] depth;
    static boolean[] checked;
    static ArrayList<ArrayList<Integer>> graph;

    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        //1. LCA에 필요한 자료구조 모으기
        parent = new int[n+1];
        depth = new int[n+1];
        checked = new boolean[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        //2. 그래프(트리) 구조 입력
        StringTokenizer st;
        int a,b;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //3. 깊이 테이블 생성
        makeDepth(1, 0);

        //4. m번의 LCA횟수 입력
        int m = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());

            sb.append(LCA(a, b) + "\n");
        }
        System.out.print(sb);

    }


    public static void makeDepth(int i, int d){
        depth[i] = d;
        checked[i] = true;

        for(int j=0; j<graph.get(i).size(); j++){
            int next = graph.get(i).get(j);
            if(checked[next]){
                continue;
            }
            parent[next] = i;
            makeDepth(next, d+1);
        }
    }


    public static int LCA(int a, int b){
        // 처음에 깊이 맞추기
        while(depth[a] != depth[b]){
            if(depth[a] > depth[b]){
                a = parent[a];
            } else {
                b = parent[b];
            }
        }

        //최소 공통 조상 찾기
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

}
