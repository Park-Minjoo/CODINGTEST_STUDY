package org.woojin.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
         */

//        mySolution();
        answerSolution();
    }


    public static void answerSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            int top = Integer.valueOf(st.nextToken());

            while(!stack.isEmpty()){
                int[] nextTop = stack.peek();
                if(nextTop[1] >= top){
                    sb.append(nextTop[0] + " ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            }

            stack.push(new int[] {i, top});
        }
        System.out.print(sb);
    }


    public static void mySolution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] top = new long[n+1];
        for(int i=1; i<=n; i++){
            top[i] = Long.valueOf(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("0 ");

        for(int i=2; i<=n; i++){
            int j=i-1;
            for(; j>=1; j--){
                if(top[i] < top[j]){
                    sb.append(j + " ");
                    break;
                }
            }

            if(j==0){
                sb.append("0 ");
            }
        }

        System.out.println(sb);

    }





}
