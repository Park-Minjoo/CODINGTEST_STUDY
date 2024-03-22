package org.woojin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Power_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review

         */

        mySolution();
    }

    static int[] parent; //크루스칼 알고리즘 부모 테이블
    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        int a_ = findParent(a);
        int b_ = findParent(b);

        if(a_ < b_){
            parent[b_] = a_;
        } else {
            parent[a_] = b_;
        }
    }

    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.valueOf(st.nextToken());

            //크루스칼 알고리즘 - 부모 테이블 초기화
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int n = Integer.valueOf(st.nextToken());
            if(m == 0 && n == 0){
                break;
            }
            //크루스칼 알고리즘 - 간선 정보 받기
            ArrayList<Node> nodes = new ArrayList<>();

            int sum = 0; //현재 전체 전력값

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());
                int z = Integer.valueOf(st.nextToken());
                nodes.add(new Node(x, y, z));
                sum += z;
            }

            // 크루스칼 알고리즘 - 간선 정렬
            Collections.sort(nodes);

            // 크루스칼 알고리즘 진행
            int result = 0;
            for (int i = 0; i < nodes.size(); i++) {
                int a = nodes.get(i).getA();
                int b = nodes.get(i).getB();

                if (findParent(a) != findParent(b)) {
                    unionParent(a, b);
                    result += nodes.get(i).getWeight();
                }
            }

            System.out.println(sum - result);
        }
    }
}

class Node implements Comparable<Node>{
    private int a;
    private int b;
    private int weight;

    public Node(int a, int b, int weight){
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int getA(){return a;}
    public int getB(){return b;}
    public int getWeight(){return weight;}

    @Override
    public int compareTo(Node other) {
        if(this.weight < other.weight){
            return -1;
        }
        return 1;
    }
}
/*
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
0 0

 */