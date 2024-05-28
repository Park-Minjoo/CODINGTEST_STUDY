import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 공주님을 구해라
     */

    public static int N;
    public static int M;
    public static int T;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[][] map;
    public static boolean[][] visited;
    public static boolean[][] gramVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        gramVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int time = node.getTime();
            int x = node.getX();
            int y = node.getY();
            boolean isGram = node.isGram();

            // T시간 이내에 못들어옴
            if (time > T)
                return "Fail";

            // 공주한테 도착 종료
            if (x == M - 1 && y == N - 1) {
                return String.valueOf(time);
            }

            // 큐 삽입
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 범위 체크
                if (newX < 0 || newY < 0 || newX >= M || newY >= N)
                    continue;

                // 큐 삽입
                Node newNode = new Node(newX, newY, time + 1);
                if (isGram) {
                    if (gramVisited[newY][newX]) continue;
                    newNode.setGram(true);
                    gramVisited[newY][newX] = true;
                } else {
                    int nodeValue = map[newY][newX];

                    if (visited[newY][newX]) continue;
                    if (nodeValue == 1) continue;
                    else if (nodeValue == 2) newNode.setGram(true);

                    visited[newY][newX] = true;
                }
                queue.offer(newNode);
            }

        }
        return "Fail";
    }

    public static class Node {
        int x;
        int y;
        int time;
        boolean gram;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public boolean isGram() {
            return gram;
        }

        public void setGram(boolean gram) {
            this.gram = gram;
        }

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.gram = false;
        }
    }



}





