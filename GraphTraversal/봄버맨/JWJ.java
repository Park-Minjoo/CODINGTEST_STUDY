package org.woojin.graphSearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 붐버맨 {
    static char[][][] versionMap;		//1초, 3초, 5초 격자판 상태 저장 배열
    static int[] dr = { -1, 1, 0, 0 };	//상하좌우 y변경값
    static int[] dc = { 0, 0, -1, 1 };	//상하좌우 x변경값
    static int R, C;

    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        versionMap = new char[3][R][C];
        //1초뒤 격자판 상태 저장
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++)
                versionMap[0][i][j] = str.charAt(j);
        }
        //3초, 5초 뒤 격자판 상태 저장
        for(int i=0;i<2;i++){
            setting(i, i+1);
            fill(i+1);
        }

        //N이 2의 배수일 때 : 모든 격자판 'O'
        if (N % 2 == 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++)
                    sb.append('O');
                sb.append("\n");
            }
        }else {
            //N이 1일 때 : 1초뒤 격자판 상태
            if (N == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++)
                        sb.append(versionMap[0][i][j]);
                    sb.append("\n");

                }
            }else if (N % 4 == 3) {	//N mod 4 == 3일 때 : 3초 뒤 격자판 상태
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++)
                        sb.append(versionMap[1][i][j]);
                    sb.append("\n");
                }
            }else {	//N>1 And N mod 4 == 1일 때 : 5초 뒤 격자판 상태
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++)
                        sb.append(versionMap[2][i][j]);
                    sb.append("\n");
                }
            }
        }
        //격자판 상태 BufferedWriter 저장
        bw.write(sb.toString());
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //폭탄이 터졌을 때 사방탐색으로 '.'으로 변경하는 함수
    static void setting(int v1, int v2){
        //v1 : 이전 상태 버전, v2 : 현재가 될 상태 버전
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (versionMap[v1][i][j] == 'O') {
                    versionMap[v2][i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int tempR = i + dr[d];
                        int tempC = j + dc[d];
                        if (inSpace(tempR, tempC))
                            versionMap[v2][tempR][tempC] = '.';
                    }
                }
            }
        }
    }
    //폭탄이 터진 후 남은 칸 'O'으로 채우는 함수
    static void fill(int version){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (versionMap[version][i][j] == '.')
                    continue;
                versionMap[version][i][j] = 'O';
            }
        }
    }
    //격자판에 존재하는 좌표인지 확인하는 함수
    static boolean inSpace(int r, int c) {
        if (r >= 0 && c >= 0 && r < R && c < C)
            return true;
        return false;
    }
}