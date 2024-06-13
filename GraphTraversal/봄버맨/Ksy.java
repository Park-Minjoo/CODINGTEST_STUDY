import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};


    private static String solution(int r, int c, int n, char[][] graph) {
        StringBuilder result = new StringBuilder();

        //1, 5, 9 ... 는 입력값 그대로
        if (n % 4 == 1) {
            for (int i = 0; i < r; i++) {
                result.append(graph[i])
                        .append("\n");
            }
        } else if (n % 2 == 0) { // 짝수는 전체 O으로 차 있음
            for (int i = 0; i < r; i++) {
                result.append("O".repeat(c))
                        .append("\n");
            }
        } else { // n % 4 == 3 이면 
            char[][] newGraph = makeVersion2(r, c, graph);
            for (int i = 0; i < r; i++) {
                result.append(newGraph[i])
                        .append("\n");
            }
        }

        return result.toString();
    }

    private static char[][] makeVersion2(int r, int c, char[][] graph) {
        char[][] newGraph = new char[r][c];
        // 초기화
        for (int i = 0; i < r; i++) {
            Arrays.fill(newGraph[i], 'O');
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] == 'O') {
                    newGraph[i][j] = '.';

                    for (int k = 0; k < 4; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];

                        if (0 <= newX && newX < r && 0 <= newY && newY < c) {
                            newGraph[newX][newY] = '.';
                        }
                    }
                }
            }
        }
        return newGraph;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            char[][] graph = new char[r][c];

            for (int i = 0; i < r; i++) {
                graph[i] = reader.readLine().toCharArray();
            }

            System.out.println(solution(r, c, n, graph));
        }
    }
}
