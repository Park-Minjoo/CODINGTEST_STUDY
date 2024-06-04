package org.woojin.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Hacking_JWJ {

    static ArrayList<ArrayList<Integer>> graphs;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        //그래프 관계: 노드 관점 양방향 그래프
        graphs = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graphs.add(new ArrayList<Integer>());
        }

//        System.out.println("그래프 관계 생성");

        //간선 입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            graphs.get(b).add(a);
        }

//        System.out.println("간선 입력 완료");

        //그래프 탐색
        count = new int[n+1];
//        for(int i=1; i<=n; i++){
//            visited = new boolean[n+1];
//            Stack<Integer> s = new Stack<>();
//            s.push(i);
//
//            while(!s.isEmpty()){
//                int now = s.pop();
//                visited[now] = true;
//
//                for(int next : graphs.get(now)) {
//                    if (!visited[next]) {
//                        s.push(next);
//                        count[i] += 1;
//                    }
//
//                }
//            }
//        }

//        System.out.println(Arrays.toString(count));

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            // 매 번 방문 초기화
            dfs(i); // 해당 정점을 시작으로 dfs
        }

        //결과 출력
        int max = Arrays.stream(count).max().orElse(1);

        StringBuilder sb = new StringBuilder();
        for(int i : count){
            if(i == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);

    }

    public static void dfs(int n) {

        visited[n] = true; // 방문 처리

        for (int next : graphs.get(n)) {

            if (visited[next])
                continue;
            // 이미 방문한건 패스
            count[next]++; // 방문 횟수 증가
            dfs(next); // 다음 정점 방문

        }

    }
}
