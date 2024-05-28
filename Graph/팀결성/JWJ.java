package org.woojin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Team_JWJ {
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

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        int k, a, b;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            k = Integer.valueOf(st.nextToken());

            if(k==0){
                a = Integer.valueOf(st.nextToken());
                b = Integer.valueOf(st.nextToken());
                unionParent(a,b);
            } else{
                a = Integer.valueOf(st.nextToken());
                b = Integer.valueOf(st.nextToken());

                if(parent[a] == parent[b]){
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }

            }
        }
        System.out.print(sb);
    }

    public static int findParent(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            return parent[x] = findParent(parent[x]);
        }
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
/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
