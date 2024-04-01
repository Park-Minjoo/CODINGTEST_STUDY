package org.woojin.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BIT_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            구간합(누적합 배열) + 값의 업데이트 발생 -> BIT 활용
         */

        mySolution();
    }

    static int n;
    static long[] arr;
    static long[] tree;

    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        long m = Long.valueOf(st.nextToken());
        long k = Long.valueOf(st.nextToken());

        //1. BIT 트리 형성
        arr = new long[n+1];
        tree = new long[n+1];

        long a;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            arr[i] =  a;
            treeUpdate(i, a);
        }

        //2.
        int b;
        long c;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine());

            a = Long.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            c = Long.valueOf(st.nextToken());

            //값 변경
            if(a==1){
                treeUpdate(b, c - arr[b]);
                arr[b] = c;
            }
            else { //구간합 도출
                sb.append(getScopeSum(b, (int) c) + "\n");
            }

        }
        System.out.println(sb);

    }

    public static void treeUpdate(int i, long dif){
        while(i<=n){
            tree[i] += dif;
            i += (i & -i);
        }
    }

    public static long getSum(int i){
        long result = 0;
        while(i > 0){
            result += tree[i];
            i -= (i & -i);
        }

        return result;
    }

    public static long getScopeSum(int s, int e){
        return getSum(e) - getSum(s - 1);
    }

}
