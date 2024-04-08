package org.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 타임머신 11657번
public class LeeMoonGi {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     *  최단거리에서 마이너스가 있으면
     *  벨만포드
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[] arr = new long[n + 1]; // 노드의 거리정보를 보여줄 arr
        Arrays.fill(arr, Long.MAX_VALUE); // 무한대 대신

        // 값 입력
        List<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            edges.add(new Edge(start, end, cost));
        }

        arr[1] = 0;
        for(int i = 1 ; i <= n ; i ++) {
            for(Edge edge : edges) {
                if(arr[edge.start] == Long.MAX_VALUE) continue;

                // 버스 도착점까지의 최소거리가 시작점 + 비용보다 크면 갱신
                if(arr[edge.end] > arr[edge.start] + edge.cost) {
                    arr[edge.end] = arr[edge.start] + edge.cost;

                    if(i == n) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        for(int i = 2 ; i <= n ; i ++) {
            if(arr[i] == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(arr[i]);
            }
        }
    }

    public static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

}
