import java.io.*;
import java.util.*;


public class Main {

    public static int R, C, N;
    public static char[][] map;
    public static char[][] tmpMap;
    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        tmpMap = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = charArray[j];
                tmpMap[i][j] = charArray[j];
            }
        }


        /* 계산 */
        int n = N % 4;

        if (n == 0 || n == 2) {
            setAllMap('O');
        } else if (N == 1) {
        } else if (n % 4 == 3) {
            setAllMap('O');
            explosion();
        } else if (n % 4 == 1) {
            setAllMap('O');
            explosion();
            copyMap();
            setAllMap('O');
            explosion();
        }

        /* 출력 */
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void copyMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
    }

    private static void explosion() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (tmpMap[i][j] == 'O') {
                    map[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int newI = i + di[k];
                        int newJ = j + dj[k];
                        if ( newI < 0 || newJ < 0 || newI >= R || newJ >= C) continue;

                        map[newI][newJ] = '.';
                    }
                }
            }
        }
    }

    private static void setAllMap(char c) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = c;
            }
        }
    }


}