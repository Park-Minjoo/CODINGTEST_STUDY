package org.woojin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class City_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review

         */

        mySolution();
    }

    static int[] parent;

    public static void mySolution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.valueOf(st.nextToken());
        int e = Integer.valueOf(st.nextToken());

        parent = new int[v+1];
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        ArrayList<Edge> graphs = new ArrayList<>();

        int a,b,w;
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            w = Integer.valueOf(st.nextToken());

            graphs.add(new Edge(a,b,w));
        }

        //입력 끝

        Collections.sort(graphs);


        int sum = 0;
        int max = -1;
        for(int i=0; i<graphs.size(); i++){
            a = graphs.get(i).getA();
            b = graphs.get(i).getB();
            w = graphs.get(i).getWeight();

            if(findParent(a) != findParent(b)){
                sum += w;
                if(max < w) { max = w; }
                unionParent(a,b);
            }
        }

        System.out.print(sum - max);
    }

    public static int findParent(int x){
        if(parent[x] == x){ return x; }
        else { return parent[x] = findParent(parent[x]); }
    }

    public static void unionParent(int a, int b){
        int a_ = findParent(a);
        int b_ = findParent(b);

        if(a_ < b_){
            parent[b_] = a_;
        } else{
            parent[a_] = b_;
        }
    }
}

class Edge implements Comparable<Edge>{
    private int a;
    private int b;
    private int weight;

    public Edge(int a, int b, int weight){
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public int compareTo(Edge other){
        if(this.weight < other.weight){
            return -1;
        }
        return 1;
    }
}

/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4

 */