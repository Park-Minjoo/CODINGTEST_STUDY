import java.util.*;

class Solution {
    //비선점 + 우선순위 큐 + 우선순위동일하면 먼저 호출된애
    public long[] solution(int[][] program) {
        //1. 호출된 순서대로 정렬
        long[] answer = new long[11];
        Arrays.sort(program, (p1, p2) -> p1[1] - p2[1]);

        //모든 프로그램 반복
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            if(p1[0] == p2[0]) return p1[1] - p2[1];
            return p1[0] - p2[0]; });

        long time = 0;
        int p_index = 0;

        while(p_index < program.length || !pq.isEmpty()){
            //2. time에 해당하는 값인 애들 전부 꺼내서 우선순위큐에 삽입
            boolean isFinded = false;

            while(p_index < program.length && program[p_index][1] <= time){
                pq.offer(program[p_index]);
                p_index++;
                isFinded = true;
            }

            //예외: 큐에 있는 프로그램도 다 끝났고 새로운애 안들어왔으면 time값 조정
            if(!isFinded && pq.isEmpty() && p_index < program.length){
                time = program[p_index][1];
            }

            //3. 우선순위에 있는거 꺼내서 time증가 시키기
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                //System.out.printf("%s: %dtime %dindex\n", Arrays.toString(now), time, p_index);

                //대기시간 = 현재 시간 - 들어온시간
                answer[now[0]] += (time - now[1]);
                time += now[2];
            }
        }

        //모든 프로그램 종료 시간
        answer[0] = time;

        return answer;
    }
}