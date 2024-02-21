package org.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주유소 13305번
public class LeeMoonGi {

    public static void main(String[] args) throws IOException {
        mySolution();
    }


    /**
     * 지금보다 앞에 도시의 가스가 싸면 그까지 계산
     * 아니면 다음 그 다음 도시 가스값 확인
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine());   // 도시 수
        int[] road = new int[city]; // 도로 길이
        int[] gas = new int[city];  // 가스 가격
        String[] roadInput = br.readLine().split(" ");
        String[] gasInput = br.readLine().split(" ");

        int result = 0;
        int minGas = 0; // 중간에 정산할 최소 가스
        int tmpRoad = 0;

        // 입력 받는 부분
        for (int i = 0; i < city - 1; i++) {
            road[i] = Integer.parseInt(roadInput[i]);
            gas[i] = Integer.parseInt(gasInput[i]);
        }
        gas[city - 1] = Integer.parseInt(gasInput[city - 1]);

        for (int i = 0; i < city - 1; i++) {
            if (minGas == 0)
                minGas = gas[i];

            // 최소가스 값 보다 바로 앞도시 가스가 싸면 그 까지만 정산
            if (minGas >= gas[i + 1]) {
                result = result + minGas * (tmpRoad + road[i]);
                minGas = 0;
                tmpRoad = 0;

                // 최소가스 값 보다 앞에 도시가 비싸면 다음도시를 확인해야 한다
            } else {
                tmpRoad = tmpRoad + road[i];
            }
        }

        System.out.println(result);
    }


    /**
     *
     */
    public static void answer() throws IOException {

    }
}