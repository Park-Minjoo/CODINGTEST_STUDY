package org.woojin.sort;
import java.util.*;

public class 카드정렬하기{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.offer(Long.valueOf(sc.nextLine()));
        }
        //입력끝

        //연산
        long result = 0;
        while (pq.size() > 1){
            long a = pq.poll();
            long b = pq.poll();

            result += (a + b);

            pq.offer(a+b);

        }
        System.out.println(result);


    }

}