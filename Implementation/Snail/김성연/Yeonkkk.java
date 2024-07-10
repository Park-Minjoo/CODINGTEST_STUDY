import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yeonkkkk {

    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    private static String solution(int n, int target) {
        int[][] snail = new int[n][n];
        int x = 0;
        int y = 0;
        int directionIndex = 0;
        int targetX = 0;
        int targetY = 0;

        for (int i = n * n; 0 < i; i--) {
            // 값 채워주기
            if (snail[x][y] == 0) {
                snail[x][y] = i;

                if (i == target) {
                    targetX = x + 1;
                    targetY = y + 1;
                }
            }

            // 방향 바꿀지 결정
            int nextX = x + dx[directionIndex];
            int nextY = y + dy[directionIndex];

            if (nextX < 0 || n <= nextX || nextY < 0 || n <= nextY || snail[nextX][nextY] != 0) {
                if (directionIndex == 3) {
                    directionIndex = 0;
                } else {
                    directionIndex += 1;
                }

                x += dx[directionIndex];
                y += dy[directionIndex];
                continue;
            }

            x = nextX;
            y = nextY;
        }

        // 결과값
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(snail[i][j]);

                if (j == n - 1) {
                    result.append("\n");
                    continue;
                }
                result.append(" ");
            }
        }

        result.append(targetX)
                .append(" ")
                .append(targetY);

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            int target = Integer.parseInt(reader.readLine());

            System.out.println(solution(n, target));
        }
    }
}
