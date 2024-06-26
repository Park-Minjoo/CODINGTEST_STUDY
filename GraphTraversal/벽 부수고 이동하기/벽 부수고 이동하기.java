import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map, brokenMap;
    public static boolean[][] visited, visited2;

    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        visited2 = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = charArray[j] - 48;
            }
        }

        int answer = BFS();

        System.out.println(answer);
    }

    private static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pi = poll.i;
            int pj = poll.j;
            boolean usedPower = poll.usedPower;

            if (pi == N -1 && pj == M -1)
                return poll.count;

            if (!usedPower) {
                for (int k = 0; k < 4; k++) {
                    int newI = pi + di[k];
                    int newJ = pj + dj[k];

                    if (newI < 0 || newJ < 0 || newI >= N || newJ >= M) continue;

                    if (map[newI][newJ] == 1 && !visited2[newI][newJ]) {
                        queue.add(new Node(newI, newJ, poll.count + 1, true));
                        visited2[newI][newJ] = true;
                    } else if (map[newI][newJ] == 0 && !visited[newI][newJ]) {
                        queue.add(new Node(newI, newJ, poll.count + 1, false));
                        visited[newI][newJ] = true;
                    }
                }
            } else {
                for (int k = 0; k < 4; k++) {
                    int newI = pi + di[k];
                    int newJ = pj + dj[k];

                    if (newI < 0 || newJ < 0 || newI >= N || newJ >= M) continue;
                    if (visited[newI][newJ] || visited2[newI][newJ]) continue;

                    if (map[newI][newJ] == 1) {
                        continue;
                    } else if (map[newI][newJ] == 0){
                        queue.add(new Node(newI, newJ, poll.count + 1, true));
                        visited2[newI][newJ] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        int i;
        int j;
        int count;
        boolean usedPower;

        public Node(int i, int j, int count, boolean usedPower) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.usedPower = usedPower;
        }
    }
/*
6 4
0001
1110
1000
0011
0111
0000
 */
}
