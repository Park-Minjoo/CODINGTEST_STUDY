import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map = new int[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int lineCount = 0;
        int answer = 0; // 숫자를 부른 카운트
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                answer++;
                int number = Integer.parseInt(st.nextToken());
                Node node = findNode(number);
                lineCount += countLine(node);
                if (lineCount >= 3) break;
            }
            if (lineCount >= 3) break;
        }
        System.out.println(answer);
    }

    private static Node findNode(int number) {
        Node node = null;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == number) {
                    map[i][j] = 0;
                    node = new Node(i, j);
                    break;
                }
            }
        }
        return node;
    }

    private static int countLine(Node current) {
        int total = 0;
        int[][] di = {{-1,1},{0,0},{-1,1},{-1,1}};
        int[][] dj = {{0,0},{1,-1},{-1,1},{1,-1}};

        // 상하, 좌우, 대각1, 대각2
        for (int i=0; i<4; i++) {
            int count = 1;
            count += getCount(0, di[i][0], dj[i][0], current, current);
            count += getCount(0, di[i][1], dj[i][1], current, current);
            if (count == 5) {
                total++;
                if (total >= 3) break;
            }
        }

        return total;
    }

    private static int getCount(int count, int di, int dj, Node first, Node current) {
        int newI = di + current.i;
        int newJ = dj + current.j;

        // 방향 체크
        if (newI < 0 || newJ < 0 || newI > 4 || newJ > 4) {
            return count;
        }
        // 0이면 체크된거
        if (map[newI][newJ] != 0) {
            return count;
        }

        return getCount(count+1, di, dj, first, new Node(newI, newJ));
    }

    private static class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}

