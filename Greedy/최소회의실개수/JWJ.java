package org.woojin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Meeting_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            1. 정렬
            입력된 미팅 순서(인덱스)가 상관x & 미팅 시작과 종료 시간이 중요하므로 정렬 진행

            2. (x,y) 리스트 삽입
            미팅 시작 시간, 종료 시간을 삽입해야하는데, 시작 시간으로 정렬이 필요하므로 클래스 생성 방식으로 진행

            3. 우선순위 큐
            회의실에 미팅을 넣고, 미팅 종료 시간이 끝나면 나와야함
            -> 종료 시간으로 항상 정렬할 필요가 있음
            -> 우선순위 큐 생성 하면, 종료 시간이 가장 작은것을 바로 서칭 가능

            그리디 알고리즘이라기 보단 자료구조 느낌이 강했던 문제
            -> 우선순위 큐에 있는 최소 종료 시간과 현재 미팅 시작 시간 비교
            -> 우선순위 큐의 최대 크기가 최소 회의실 개수
         */

        mySolution();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        ArrayList<Meet> meets = new ArrayList<>();

        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            meets.add(new Meet(
                   Long.valueOf(st.nextToken()),
                   Long.valueOf(st.nextToken())
            ));
        }

        //미팅 시작 순서로 정렬
        Collections.sort(meets);

        //미팅 종료 순서로 우선순위 큐 생성
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int maxSize = 0; //우선순위 큐의 최대 크기가 정답

        for(int i=0; i<n; i++){
            Meet now = meets.get(i);
            if(!pq.isEmpty()){
                long end = pq.peek();
                if(now.getStart() >= end){
                    pq.poll();
                    pq.offer(now.getEnd());
                } else {
                    pq.offer(now.getEnd());
                }
            } else {
                pq.offer(now.getEnd());
            }

            //한 사이클 돌고 미팅방 최대 크기 갱신
            if(maxSize < pq.size()) {
                maxSize = pq.size();
            }
        }

        System.out.println(maxSize);
    }
}

class Meet implements Comparable<Meet>{
    private long start;
    private long end;

    public Meet(long s, long e){
        start = s;
        end = e;
    }

    public long getEnd(){return end;}
    public long getStart(){return start;}

    @Override
    public int compareTo(Meet o) {
        return (int) (this.start - o.start);
    }
}
