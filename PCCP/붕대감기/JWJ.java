import java.util.*;
class Solution {
    //[t,x,y]
    //t초동안 붕대를 감으면 1초마다 x
    //t초 모두 성공하면 y추가
    //단, 최대체력(health)까지만
    //공격을 받으면 스킬 시전 시간 끊김 + 체력 닳음
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;

        //반복문 끝나는 조건 = 마지막 공격 시간
        int finish = attacks[attacks.length-1][0];

        int index = 0; //공격 배열 탐색
        int count = 0; //누적 회복 시간

        for(int i=1; i<=finish; i++){

            //공격 타임인 경우
            if(attacks[index][0] == i){
                answer -= attacks[index][1];
                count = 0;
                index++;

                //현재 체력이 없는 경우
                if(answer <= 0){
                    answer = -1;
                    break;
                }
            } else{
                count++;
                answer += bandage[1];

                //누적 회복 시간이 다 찬 경우
                if(count == bandage[0]){
                    count = 0;
                    answer += bandage[2];
                }

                //최대 체력을 넘은 경우 조정
                if(answer > health){
                    answer = health;
                }
            }

        }

        return answer;
    }
}