package org.woojin.ds;

import java.util.*;

public class Stack_JWJ {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력
        int n = sc.nextInt();

        int[] s = new int[n];
        for(int i=0; i<n; i++){
            s[i] = sc.nextInt();
        }
        //입력 완료

        //스택 처리
        Stack<Integer> st = new Stack<>();

        int now = 0;
        st.push(1);
        StringBuilder sb = new StringBuilder();
        sb.append("+\n");

        for(int i=2; i<=n; i++){

            if(now >= s.length ){
                break;
            }

            int value = s[now];

            if(st.isEmpty()){
                if(i <= s[now]){
                    st.push(i);
                    sb.append("+\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
            else if(st.peek() == value){
                st.pop();
                sb.append("-\n");
                i--;
                now++;
            }
            else if(st.peek() < value){
                st.push(i);
                sb.append("+\n");
            }
            else if(st.peek() > value){
                st.pop();
                sb.append("-\n");
                i--;
            }
        }

        //끝까지 다 넣었는데 수열이 안만들어진 경우
        while(now < s.length){
            if(st.isEmpty()){
                System.out.println("NO");
                return;
            }

            int v = st.pop();
            sb.append("-\n");

            if(v == s[now]){
                now++;
            }
        }

        System.out.println(sb);

    }
}