import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ksy {

    public static final int TARGET = 2;
    public static final int[] dx = {1, -1, 0, 0};
    public static final int[] dy = {0, 0, 1, -1};

    public static int n;
    public static int m;

    static class Point {

        private final int x;
        private final int y;

        Point() {
            this(0, 0);
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static String solution(int[][] graph, Point targetPoint) {
        Queue<Point> queue = new LinkedList<>();
        int[][] distances = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // 초기화
        queue.offer(targetPoint);
        visited[targetPoint.x][targetPoint.y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];

                if (x < 0 || n <= x || y < 0 || m <= y || visited[x][y] || graph[x][y] == 0) {
                    continue;
                }

                queue.offer(new Point(x, y));
                distances[x][y] = distances[point.x][point.y] + 1;
                visited[x][y] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    result.append(-1)
                            .append(" ");
                    continue;
                }

                result.append(distances[i][j])
                        .append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = reader.readLine().split(" ");
            n = Integer.parseInt(firstLine[0]);
            m = Integer.parseInt(firstLine[1]);
            int[][] graph = new int[n][m];
            Point targetPoint = new Point();

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < m; j++) {
                    int number = Integer.parseInt(tokenizer.nextToken());
                    graph[i][j] = number;

                    if (number == TARGET) {
                        targetPoint = new Point(i, j);
                    }
                }
            }

            System.out.println(solution(graph, targetPoint));
        }
    }
}
