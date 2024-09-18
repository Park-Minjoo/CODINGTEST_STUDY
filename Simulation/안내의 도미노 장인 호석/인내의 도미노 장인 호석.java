import java.io.*;
import java.util.*;

public class Main {

    private static String[][] map, originMap;
    private static int N, M, R, down;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new String[N+1][M+1];
        originMap = new String[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                String str = st.nextToken();
                map[i][j] = str;
                originMap[i][j] = str;
            }
        }

        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            if (!"F".equals(type)) {
                attack(x,y,type,Integer.parseInt(originMap[x][y]));
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            defense(x,y);

//            printMap();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if ("F".equals(map[i][j])) {
                    sb.append("F").append(" ");
                } else {
                    sb.append("S").append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(down);
        System.out.println(sb.toString());
    }


    private static void attack(int x, int y, String type, int nextCount) {
        // 범위 체크
        if (x > N || y > M || x < 1 || y < 1) {
            return;
        }
        if (nextCount == 0) {
            return;
        }

        // 넘어진 도미노가 아니면 앞으로 더 넘어갈 도미노수를 확인한다
        int currentHeight = Integer.parseInt(originMap[x][y]);
        if (!"F".equals(map[x][y])) {
            map[x][y] = "F";
            if (nextCount < currentHeight) {
                nextCount = currentHeight;
            }
            down++;
        }

        // 다음 방향 좌표
        if ("N".equals(type)) {
            x = x - 1;
        } else if ("S".equals(type)) {
            x = x + 1;
        } else if ("E".equals(type)) {
            y = y + 1;
        } else if ("W".equals(type)) {
            y = y - 1;
        }

        attack(x, y, type, nextCount-1);
    }

    private static void defense(int x, int y) {
        // 세우기
        if ("F".equals(map[x][y])) {
            map[x][y] = originMap[x][y];
        }
    }

//    private static void printMap() {
//        StringBuilder sb = new StringBuilder();
//        for (int i=1; i<=N; i++) {
//
//            sb.append("\n");
//            for (int j=1; j<=M; j++) {
//                sb.append(map[i][j]).append(" ");
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
}
