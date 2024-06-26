import java.io.*;
import java.util.*;

public class Main {

    public static int T, H, W;
    public static char[][] map;
    public static boolean[][] visited;
    public static List answer = new ArrayList<Integer>();
    public static int count = 0;
    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            initMap(br);

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '#' && !visited[i][j]) {
                        BFS(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
            count = 0;
        }

        System.out.println(sb.toString());

    }

    private static void initMap(BufferedReader br) throws IOException {
        map = new char[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                map[i][j] = charArray[j];
            }
        }
    }

    private static void BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pi = poll.i;
            int pj = poll.j;
            visited[pi][pj] = true;

            for (int k = 0; k < 4; k++) {
                int newI = pi + di[k];
                int newJ = pj + dj[k];

                // 4가지 방향
                if (newI < 0 || newJ < 0 || newI >= H || newJ >= W) continue;
                if (visited[newI][newJ]) continue;
                if (map[newI][newJ] == '.') continue;

                // 방문 여부 확인
                queue.add(new Node(newI, newJ));
                visited[newI][newJ] = true;
            }

        }

        count++;
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