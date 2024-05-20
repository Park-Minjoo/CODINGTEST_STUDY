import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    private static int count = 0;
    private static List<Integer> list = new ArrayList();
    private static int[][] map;
    private static int N;
    private static boolean[][] visited;
    private static int[] di = {1, -1, 0, 0};
    private static int[] dj = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = charArray[j] - 48;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(i, j);
            }
        }

        Collections.sort(list);
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            sb.append((list.get(i))).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int i, int j) {
        int house = 0;

        Queue<Node> queue = new LinkedList<>();
        if (visited[i][j]) return;
        if (map[i][j] == 0) {
            visited[i][j] = true;
            return;
        }
        queue.add(new Node(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            house++;

            for (int k = 0; k < 4; k++) {
                int newI = di[k] + node.getI();
                int newJ = dj[k] + node.getJ();
                if (newI < 0 || newJ < 0 || newI >= N || newJ >= N)
                    continue;

                if (map[newI][newJ] == 1 && !visited[newI][newJ]){
                    queue.add(new Node(newI, newJ));
                    visited[newI][newJ] = true;
                }
            }

        }

        count++;
        list.add(house);
    }

    private static class Node {
        public int i;
        public int j;

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

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

 */
}
