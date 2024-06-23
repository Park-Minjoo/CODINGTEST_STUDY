import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 못 푼 문제 (실패한 코드)
public class Ksy {

    private final static int[] dx = {1, -1, 0, 0};
    private final static int[] dy = {0, 0, 1, -1};

    static class Movement {

        private final int x;
        private final int y;
        private final int distance;
        private boolean pass;

        Movement(int x, int y, int distance) {
            this(x, y, distance, false);
        }

        Movement(int x, int y, int distance, boolean pass) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.pass = pass;
        }
    }

    private static int solution(
            int n,
            int m,
            int[][] graph
    ) {
        int result = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][m];
        Queue<Movement> q = new LinkedList<>();
        q.offer(new Movement(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Movement current = q.poll();
            int x = current.x;
            int y = current.y;
            int distance = current.distance;

            if (x == n - 1 && y == m - 1) {
                result = Math.min(distance, result);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || n <= nx || ny < 0 || m <= ny) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (current.pass && graph[nx][ny] == 1) {
                    continue;
                }

                // 방문 처리
                visited[nx][ny] = true;

                // 벽 부시기
                if (!current.pass && graph[nx][ny] == 1) {
                    q.offer(new Movement(nx, ny, distance + 1, true));
                    continue;
                }

                q.offer(new Movement(nx, ny, distance + 1, current.pass));
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            int[][] graph = new int[n][m];

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();

                for (int j = 0; j < m; j++) {
                    graph[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }

            System.out.println(solution(n, m, graph));
        }
    }
}
