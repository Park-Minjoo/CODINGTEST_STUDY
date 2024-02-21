package org.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 바이러스 2606번
public class LeeMoonGi {
    public static void main(String[] args) throws IOException {
        mySolution();
    }


    /**
     *  bfs, dfs 사용해서 탐색하면서 카운트
     */
    public static Queue<Integer> que = new LinkedList<>();;
    public static boolean[] visited = new boolean[101];
    public static  List<List<Integer>> graph = new ArrayList<>();
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine()); // 컴퓨터
        int relation = Integer.parseInt(br.readLine()); // 컴퓨터 관계 수
        int result = 0;

        // 2차원 배열 초기화
        for (int i = 0; i < computer + 2; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 컴퓨터 관계 입력 받기
        for (int i = 0; i < relation; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b); // 2차원 배열에 추가
        }

        visited[0] = true; // 0 인덱스 제외

        // 1은 미리 넣기
        que.add(1);
        visited[1] = true;

        while(!que.isEmpty()){
            int index = que.peek();
            visited[index] = true;
            List<Integer> connectComputers = graph.get(index);

            for (Integer c : connectComputers) {
                // 방문한적 있으면 무시
                if (visited[c])
                    continue;
                // que 넣기
                que.offer(c);
            }

            que.poll();
            result++;
        }

        System.out.println(result -1);
    }



}