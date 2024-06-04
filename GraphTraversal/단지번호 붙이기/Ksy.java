import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ksy {

    static int count = 0;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[][] graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }

            List<Integer> numbers = solution(n, graph);
            numbers.sort(Comparator.comparingInt(a -> a));

            System.out.println(numbers.size());
            for (Integer number : numbers) {
                System.out.println(number);
            }
        }
    }

    private static List<Integer> solution(int n, int[][] graph) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }
                dfs(i, j, n, graph);

                result.add(count);
                count = 0;
            }
        }

        return result;
    }

    private static void dfs(int x, int y, int n, int[][] graph) {
        if (x < 0 || y < 0 || n <= x || n <= y || graph[x][y] == 0) {
            return;
        }

        count++;
        graph[x][y] = 0;

        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];

            dfs(newX, newY, n, graph);
        }
    }
}
