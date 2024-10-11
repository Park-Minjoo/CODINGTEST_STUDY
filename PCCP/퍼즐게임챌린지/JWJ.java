import java.util.*;

class Solution {
    //n개의 퍼즐
    // diff: 퍼즐 난이도
    // level: 내 숙련도
    // limit: 전체 제한시간
    // time_cur: 퍼즐 소요 시간 (times)
    // time_prev: 이전 퍼즐 소요 시간
    //diff <= level: +time_cur
    //diff > level: 한번 틀릴때마다 time_cur + time_prev발생
    //(diff-level)  * (time_cur + time_prev) + time_cur
    // limit 시간 내에 해결 할 수 있는 숙련도의 최소값 -> 파라메트릭 서치?
    //level의 범주는 0~diffs의 최대값


    //1. level 이진 탐색 로직
    //2. 퍼즐 시간 계산
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        //1. level 이진 탐색
        int start = 0;
        int end = Arrays.stream(diffs).max().orElse(-1);
        int mid;
        long tmp;
        while(start <= end){
            mid = (start + end) / 2;

            tmp = checkTime(diffs, times, limit, mid);

            //시간이 더 오래걸릴경우(오답) -> 숙련도 증가 필요 -> level 증가
            if(tmp > limit){
                start = mid+1;
                answer = mid;
            }
            //시간이 빨리 걸린 경우(정답) -> 숙련도 감소 필요 -> level 감소
            else{
                end = mid - 1;

            }

        }

        return answer + 1;
    }


    //2.
    // diff: 퍼즐 난이도
    // level: 내 숙련도
    // limit: 전체 제한시간
    // time_cur: 퍼즐 소요 시간 (times)
    // time_prev: 이전 퍼즐 소요 시간
    //diff <= level: +time_cur
    //diff > level: 한번 틀릴때마다 time_cur + time_prev발생
    //(diff-level)  * (time_cur + time_prev)
    public static long checkTime(int[] diffs, int[] times, long limit, int level){
        int s = diffs.length;

        long time = 0;

        //가장 첫번째 퍼즐 예외
        if(diffs[0] <= level){
            time += times[0];
        } else{
            time += (diffs[0] - level) * (times[0]) + times[0];
        }


        for(int i=1; i<s; i++){
            if(diffs[i] <= level){
                time += times[i];
            } else{
                time += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
        }

        return time;

    }
}