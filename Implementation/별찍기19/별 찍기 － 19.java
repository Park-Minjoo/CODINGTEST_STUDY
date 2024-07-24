import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int size = 1 + ((N-1) * 4);
        map = new char[size+1][size+1]; // 인덱스 계산하기 편하게 하기위해 1을 더한다

        for (int i=0; i<size+1; i++) {
            Arrays.fill(map[i], ' ');
        }

        for (int i = 0; i < N; i++) {
            int index1 = 1 + (i * 2);
            int index2 = size - (i * 2);
            borderDraw(index1, index2);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void borderDraw(int index1, int index2) {

        for (int i=index1; i<=index2; i++) {
            map[index1][i] = '*';
            map[index2][i] = '*';
            map[i][index1] = '*';
            map[i][index2] = '*';
        }
    }
}
