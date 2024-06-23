import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 양
public class Ksy {

    private final static int[] dx = {1, -1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};

    private static int sheepCount = 0;
    private static int wolfCount = 0;

    static class Point {

        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static String solution(int r, int c, char[][] graph, List<Point> wolf) {
        boolean[][] visited = new boolean[r][c];
        Queue<Point> queue = new LinkedList<>();

        for (Point wolfPoint : wolf) {
            if (visited[wolfPoint.x][wolfPoint.y]) {
                continue;
            }

            queue.offer(wolfPoint);
            visited[wolfPoint.x][wolfPoint.y] = true;

            int currentWolfCount = 1;
            int currentSheepCount = 0;

            while (!queue.isEmpty()) {
                Point current = queue.poll();
                int x = current.x;
                int y = current.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || r <= nx || ny < 0 || c < ny || visited[nx][ny]) {
                        continue;
                    }

                    if (graph[nx][ny] == '#') {
                        continue;
                    }

                    if (graph[nx][ny] == 'o') {
                        currentSheepCount++;
                    }

                    if (graph[nx][ny] == 'v') {
                        currentWolfCount++;
                    }

                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }

            if (currentWolfCount < currentSheepCount) {
                wolfCount -= currentWolfCount;
            } else {
                sheepCount -= currentSheepCount;
            }

            if (sheepCount * wolfCount == 0) {
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(sheepCount)
                .append(" ")
                .append(wolfCount);

        return result.toString();
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            char[][] graph = new char[r][c];
            List<Point> wolf = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                String line = reader.readLine();

                for (int j = 0; j < c; j++) {
                    char element = line.charAt(j);
                    graph[i][j] = element;

                    if (element == 'o') {
                        sheepCount++;
                        continue;
                    }

                    if (element == 'v') {
                        wolf.add(new Point(i, j));
                        wolfCount++;
                    }
                }
            }

            System.out.println(
                    solution(r,
                            c,
                            graph,
                            wolf
                    ));
        }
    }
}
