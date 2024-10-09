package org.woojin.simulation;

import java.util.*;

public class 컨베이어벨트위의로봇 {

    static int n,k,fail;
    static LinkedList<Belt> belts = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(sc.nextLine());

        for(int i =0; i<2*n; i++){
            belts.offer(new Belt(i, Integer.valueOf(st.nextToken())));
        }
        //입력끝

        int count = 0;

        fail = 0;

        while(fail < k){
            count++;

            //1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            moveBelt();

            //2. 벨트 회전 방향으로 로봇 이동
            moveRobot();

            //3. 로봇 올리기
            createRobot();
        }

        System.out.println(count);
    }

    //1. 벨트 이동
    public static void moveBelt(){
        Belt now = belts.get(2*n-1);
        belts.add(0,now);

        belts.get(n-1).robot = false;
    }

    //2. 로봇 이동
    public static void moveRobot(){
        //0~n-1 벨트 탐색 (역순 탐색)
        for(int i=n-1; i>0; i--){
            Belt next = belts.get(i);
            Belt now = belts.get(i-1);

            //다음칸으로 이동이 가능한 경우
            if(!next.robot && now.robot && next.count > 0){
                next.robot = true;
                now.robot = false;
                next.count--;

                if(next.count == 0){
                    fail++;
                }
            }
        }

        belts.get(n-1).robot = false;
    }

    //3. 로봇 생성
    public static void createRobot(){
        Belt first = belts.get(0);

        if(first.count > 0){
            first.robot = true;
            first.count--;

            if(first.count == 0){
                fail++;
            }
        }

    }

    static class Belt{
        int index;
        int count;
        boolean robot;

        public Belt(int i, int c){
            index = i;
            count = c;
            robot = false;
        }

        public String toString(){
            return "(" + count + ", " +robot + ") ";
        }
    }


}
