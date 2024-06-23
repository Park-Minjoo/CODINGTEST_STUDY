import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ksy {

    static int h;
    static int w;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());

            for (int i = 0; i < t; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                h = Integer.parseInt(tokenizer.nextToken());
                w = Integer.parseInt(tokenizer.nextToken());
                graph = new char[h][w];

                for (int j = 0; j < h; j++) {
                    graph[j] = reader.readLine().toCharArray();
                }

                System.out.println(solution());
            }
        }
    }

    private static int solution() {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ('.' == graph[i][j]) {
                    continue;
                }

                dfs(i, j);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || h <= x || w <= y || '.' == graph[x][y]) {
            return;
        }

        graph[x][y] = '.';

        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);
    }
}
