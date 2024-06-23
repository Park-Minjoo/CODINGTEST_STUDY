import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Ksy {

    static class Point implements Comparable<Point> {

        private final long location;
        private final long distance;

        Point(long location, long distance) {
            this.location = location;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return Long.compare(this.distance, o.distance);
        }
    }

    private static long solution(int k, PriorityQueue<Point> pq, Set<Long> visited) {
        long result = 0;

        first:
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Point point = pq.poll();
                long distance = point.distance;
                long location = point.location;
                long left = location - 1;
                long right = location + 1;

                if (!visited.contains(left)) {
                    pq.offer(new Point(left, distance + 1));
                    visited.add(left);
                    result += distance + 1;
                    k--;

                    if (k == 0) {
                        return result;
                    }
                }

                if (!visited.contains(right)) {
                    pq.offer(new Point(right, distance + 1));
                    visited.add(right);
                    result += distance + 1;
                    k--;

                    if (k == 0) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine());
            PriorityQueue<Point> pq = new PriorityQueue<>();
            Set<Long> visited = new HashSet<>();

            for (int i = 0; i < n; i++) {
                long location = Long.parseLong(tokenizer.nextToken());
                pq.offer(new Point(location, 0));
                visited.add(location);
            }

            System.out.println(solution(k, pq, visited));
        }
    }
}
