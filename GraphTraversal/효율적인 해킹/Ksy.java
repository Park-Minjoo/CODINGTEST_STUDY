import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Ksy {

    static int[] countByComputer;


    private static String solution(int n, List<Integer>[] graph) {
        countByComputer = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            boolean[] visited = new boolean[n + 1];
            bfs(i, graph, visited);
        }

        int max = 0;
        for (int count : countByComputer) {
            max = Math.max(count, max);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (countByComputer[i] == max) {
                result.append(i)
                        .append(" ");
            }
        }

        return result.toString();
    }

    private static void bfs(int start, List<Integer>[] graph, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            for (Integer nextNode : graph[currentNode]) {
                if (!visited[nextNode]) {
                    queue.offer(nextNode);
                    countByComputer[nextNode]++;
                    visited[nextNode] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            List<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                line = reader.readLine().split(" ");
                int computer1 = Integer.parseInt(line[0]);
                int computer2 = Integer.parseInt(line[1]);

                graph[computer1].add(computer2);
            }

            System.out.println(solution(n, graph));
        }
    }

}
