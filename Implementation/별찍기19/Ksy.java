import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ksy {

    public static final char STAR = '*';

    private static boolean[][] solution(int n, int length) {
        boolean[][] result = new boolean[length][length];
        int level = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = level; j < length - level; j++) {
                result[level][j] = true; // 젤 윗줄
                result[length - 1 - level][j] = true; // 젤 아랫줄
                result[j][level] = true; // 젤 왼쪽
                result[j][length - 1 - level] = true; // 젤 오른쪽
            }

            level += 2;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            int length = 4 * (n - 1) + 1;
            boolean[][] result = solution(n, length);

            System.out.println(resultToString(result));
        }
    }

    private static String resultToString(boolean[][] result) {
        StringBuilder output = new StringBuilder();

        for (boolean[] line : result) {
            for (boolean element : line) {
                if (element) {
                    output.append(STAR);
                    continue;
                }
                output.append(' ');
            }
            output.append('\n');
        }

        return output.toString();
    }
}
