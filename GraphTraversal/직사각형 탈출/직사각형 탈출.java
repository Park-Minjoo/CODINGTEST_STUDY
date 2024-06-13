import java.io.*;
import java.util.*;


public class Main {

    public static int N, M, H, W;
    public static int[][] map;
    public static boolean[][] visited;
    public static Node start, end;
    public static List<Node> wall = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 입력 */
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    wall.add(new Node(i, j));
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int result = BFS();

        System.out.println(result);
    }

    private static int BFS() {
        Queue<Node> queue = new LinkedList();
        queue.add(start);

        int count = 0;

        while (!queue.isEmpty()) {
            int[] di = {1, -1, 0, 0};
            int[] dj = {0, 0, 1, -1};

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                visited[poll.getI()][poll.getJ()] = true;

                // 목적지 도착
                if (poll.i == end.i && poll.j == end.j)
                    return count;

                for (int k = 0; k < 4; k++) {
                    int newI = poll.i + di[k];
                    int newJ = poll.j + dj[k];

                    if (newI < 1 || newJ < 1 || newI + H - 1 > N || newJ + W - 1 > M) continue;
                    if (visited[newI][newJ]) continue;
                    if (isWall(newI, newJ)) continue;

                    visited[newI][newJ] = true;
                    queue.add(new Node(newI, newJ));
                }
            }
            count++;
        }

        return -1;
    }

    private static boolean isWall(int newI, int newJ) {
        for (Node w : wall) {
            if (newI <= w.getI() && newJ <= w.getJ() && newI + H - 1 >= w.getI() && newJ + W - 1 >= w.getJ()) {
                return true;
            }
        }

        return false;
    }

    public static class Node {
        int i;
        int j;

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}