package org.woojin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Jewelry_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review
            1. 그리디 알고리즘
                가장 최고의 가치를 가진 보석을 선택하면 최적의 해가 나옴

            2. 정렬
                입력받는 순서에 상관이 없음 -> 정렬

            3. 우선순위 큐
               주어진 선택지에서 항상 가장 큰 값을 선택해야함 -> 우선순위 큐 이용
         */

        mySolution();
    }

    static ArrayList<Long> bag;

    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        ArrayList<Jewelry> j = new ArrayList<>();

        //1. 보석 정보 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long m = Long.valueOf(st.nextToken());
            long v = Long.valueOf(st.nextToken());
            j.add(new Jewelry(m, v));
        }
        Collections.sort(j);

        //2. 가방 최대 무게 입력
        bag = new ArrayList<>();
        for(int i=0; i<k; i++){
            bag.add(Long.valueOf(br.readLine()));
        }
        Collections.sort(bag);

        //3. 가방에서 가장
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        int j_index = 0;

        for(int i=0; i<k; i++){

            while(j_index < n){
                long weight = j.get(j_index).getWeight();
                long value = j.get(j_index).getValue();

                if(weight > bag.get(i)) {
                    break;
                }
                pq.add(value);
                j_index++;
            }

            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }

        System.out.println(result);

    }


}

class Jewelry implements Comparable<Jewelry> {
    private long weight;
    private long value;

    public Jewelry(long w, long v){
        this.value = v;
        this.weight = w;
    }

    public long getWeight() { return weight; }
    public long getValue() { return value; }

    @Override
    public int compareTo(Jewelry o) {
        if(this.weight == o.weight){
            return (int) (o.value - this.value);
        }
        return (int) (this.weight - o.weight);
    }
}
