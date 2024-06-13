import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] copyMap;

    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        Node first = null;

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    first = new Node(i, j);
                }
            }
        }

        // bfs
        BFS(first);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) map[i][j] = -1;
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.getI()][node.getJ()] = true;

        int count = 0;

        while (!queue.isEmpty()) {

            int depth = queue.size();
            for (int z = 0; z < depth; z++) {
                Node poll = queue.poll();
                int i = poll.getI();
                int j = poll.getJ();

                // 4방향 처리
                for (int k = 0; k < 4; k++) {
                    int newI = i + di[k];
                    int newJ = j + dj[k];

                    if (newI < 0 || newJ < 0 || newI >= n || newJ >= m) continue;
                    if (visited[newI][newJ]) continue;

                    if (map[newI][newJ] == 1) {
                        visited[newI][newJ] = true;
                        queue.add(new Node(newI, newJ));
                    }
                }
                map[i][j] = count;
            }
            count++;
        }
    }


    private static class Node {
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