package org.woojin.ds;

import java.util.*;
import java.io.*;

public class 회전하는큐{
    static ArrayList<Integer> adjusts = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        //원소 개수(n), 뽑으려는 수 개수(m)
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        //뽑으려는 수
        int[] target = new int[m];
        st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<m; i++){
            target[i] = Integer.valueOf(st.nextToken());
        }
        //입력 종료

        //덱큐 준비
        Deque<Integer> dq = new LinkedList<>();

        for(int i=1; i<=n; i++){
            dq.offerLast(i);
        }

        //연산 진행
        int count=0;
        for(int t : target){
            int half = n / 2;
            int diff = t - dq.peekFirst();
            int adj = checkDiffBetween(t, dq.peekFirst());
            diff = (diff > 0) ? diff - adj:  diff + adj;

            if (diff > 0) {
                if(diff <= half){
                    count += diff;
                    for(int i=0; i<diff; i++){
                        dq.offerLast(dq.pollFirst());
                    }
                } else {
                    diff = n - diff;
                    count += diff;
                    for(int i=0; i<diff; i++){
                        dq.offerFirst(dq.pollLast());
                    }
                }
            } else if (diff < 0){
                diff = (diff) * -1;
                if(diff <= half){
                    count += diff;
                    for(int i=0; i<diff; i++){
                        dq.offerFirst(dq.pollLast());
                    }
                } else {
                    diff = n - diff;
                    count += diff;
                    for(int i=0; i<diff; i++){
                        dq.offerLast(dq.pollFirst());
                    }
                }
            }
            adjusts.add(dq.pollFirst());
            n--;
        }
        System.out.print(count);


    }
    public static int checkDiffBetween(int s, int e){
        if(s > e){
            int temp = s;
            s = e;
            e = temp;
        }
        int count = 0;

        for(int v : adjusts){
            if(v > s && v < e){
                count++;
            }
        }

        return count;

    }


}