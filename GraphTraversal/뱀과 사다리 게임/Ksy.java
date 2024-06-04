import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Ksy {

    static class Point {

        private final int location;
        private final int count;

        Point(int location, int count) {
            this.location = location;
            this.count = count;
        }
    }

    private static int solution(Map<Integer, Integer> ways) {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[100 + 1];
        queue.offer(new Point(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int nextLocation = point.location + i;

                if (nextLocation > 100 || visited[nextLocation]) {
                    continue;
                }

                if (nextLocation == 100) {
                    return point.count + 1;
                }

                if (!ways.containsKey(nextLocation)) {
                    queue.offer(new Point(nextLocation, point.count + 1));
                    visited[nextLocation] = true;
                    continue;
                }

                queue.offer(new Point(ways.get(nextLocation), point.count + 1));
                visited[ways.get(nextLocation)] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            String[] countInfo = reader.readLine().split(" ");
            int ladderCount = Integer.parseInt(countInfo[0]);
            int snakeCount = Integer.parseInt(countInfo[1]);
            Map<Integer, Integer> ways = new HashMap<>();

            for (int i = 0; i < ladderCount + snakeCount; i++) {
                String[] way = reader.readLine().split(" ");
                int src = Integer.parseInt(way[0]);
                int dst = Integer.parseInt(way[1]);

                ways.put(src, dst);
            }

            System.out.println(solution(ways));
        }
    }
}
