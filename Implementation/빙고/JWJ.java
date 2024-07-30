package org.woojin.impl;
import java.util.*;
import java.io.*;

public class 빙고 {
    static ArrayList<String[]> bingos;
    static ArrayList<String[]> speaks;
    static int[][] mask;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //빙고 입력
        bingos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String[] tmp = sc.nextLine().split(" ");
            bingos.add(tmp);
        }

        //사회자 입력
        speaks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String[] tmp = sc.nextLine().split(" ");
            speaks.add(tmp);
        }

        //입력완

        // 한번의 입력에 총 12번의 줄 확인을 하면됨
        // 최소 13번째 입력 부터 3빙고를 확인하면 됨
        mask = new int[5][5];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                int[] index = findIndex(speaks.get(i)[j]);
                mask[index[0]][index[1]] = 1;
            }
        }

        int count = 10;
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int[] index = findIndex(speaks.get(i)[j]);
                mask[index[0]][index[1]] = 1;

                count++;
                if (checkAll() >= 3) {
                    System.out.print(count);
                    return;
                }
            }
        }

        System.out.print(count);

    }


    public static int[] findIndex(String target) {
        int i = 0, j = 0;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (target.equals(bingos.get(i)[j])) {
                    int[] result = {i, j};
                    return result;
                }

            }
        }

        int[] result = {-1, -1};
        return result;
    }

    public static int checkAll() {

        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (check1(i)) count++; //가로
            if (check2(i)) count++; //세로
        }

        if (check3(0)) count++; //왼쪽 대각선
        if (check4(0)) count++;

        return count;

    }

    //가로
    public static boolean check1(int s) {

        for (int i = 0; i < 5; i++) {
            if (mask[s][i] == 0) {
                return false;
            }
        }

        return true;

    }

    //세로
    public static boolean check2(int s) {

        for (int i = 0; i < 5; i++) {
            if (mask[i][s] == 0) {
                return false;
            }
        }

        return true;

    }

    //왼쪽 대각선
    public static boolean check3(int s) {

        for (int i = 0; i < 5; i++) {
            if (mask[s + i][s + i] == 0) {
                return false;
            }
        }

        return true;

    }

    //오른쪽 대각선 (0,4) (1,3) (2,2) (1,4) (4,0)
    public static boolean check4(int s) {

        for (int i = 0; i < 5; i++) {
            if (mask[s + i][s + 4 - i] == 0) {
                return false;
            }
        }

        return true;

    }

}