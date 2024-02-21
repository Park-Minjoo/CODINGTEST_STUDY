package org.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 지구온난화 2606번
public class LeeMoonGi {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     *  상하좌우 중에 3개 이상이 바다라면 바다로 변경
     *  맵을 최소한으로 보여줄 꼭짓점 체크
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] map = new String[r + 2][c + 2]; // 현재 지도, 맨 가장자리에 바다를 추가함 계산하기 쉽게
        String[][] newMap = new String[r + 2][c + 2];

        // 나중에 출력할때 보여줄 범위
        int left = c + 2, right = 0, top = -1, bottom = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        // 입력값
        for (int i = 0; i < r; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i + 1][j + 1] = s[j]; // 맨 가장자리 바다 때문에 +1
            }
        }

        // 상하좌우 중에 3개 이상이 바다라면 변경
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                // 육지인 경우에만
                if (map[i][j].equals("X")) {
                    int countSea = 0;

                    // 4가지 방향 계산
                    for (int k = 0; k < 4; k++) {
                        String index = map[i + dx[k]][j + dy[k]];
                        if (index == null || index.equals("."))
                            countSea++;
                    }

                    // 3면 이상이 바다라면 바다로 변경
                    if(countSea >= 3) {
                        newMap[i][j] = ".";
                    } else {
                        newMap[i][j] = "X";

                        if(top == -1) top =  i;
                        bottom = i;
                        if(left > j) left = j;
                        if(right < j) right = j;
                    }
                }
            }
        }

        for (int i = top ; i < bottom + 1; i++) {
            for (int j = left; j < right + 1; j++) {
                if(newMap[i][j] == null || newMap[i][j].equals("."))
                    System.out.print(".");
                else
                    System.out.print(newMap[i][j]);
            }
            System.out.println("");
        }

        System.out.println("끝");
    }




    /**
     *
     */
    public static void answer() throws IOException {

    }
}
