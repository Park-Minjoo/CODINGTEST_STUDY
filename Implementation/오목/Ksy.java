import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 틀린코드 -> 13 퍼에서 자꾸 틀립니다 ㅠ
// https://www.acmicpc.net/problem/2615

public class Ksy {

    private static final int MAP_LENGTH = 19;
    private static final int[] dx = {1, 0, 1, -1};
    private static final int[] dy = {0, 1, 1, 1};

    static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static String solution(int[][] map, List<Point> points) {
        for (Point point : points) {
            int x = point.x;
            int y = point.y;
            int number = map[x][y];

            for (int i = 0; i < 4; i++) {
                int count = 1;
                int currentX = x;
                int currentY = y;

                while (true) {
                    currentX += dx[i];
                    currentY += dy[i];

                    if (currentX < 0 || MAP_LENGTH <= currentX || currentY < 0 || MAP_LENGTH <= currentY) {
                        break;
                    }

                    if (number != map[currentX][currentY]) {
                        break;
                    }

                    count++;
                }

                if (count == 5) {
                    return number + "\n"
                            + (x + 1) + " " + (y + 1);
                }
            }
        }

        return "0";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int[][] map = new int[MAP_LENGTH][MAP_LENGTH];
            List<Point> points = new ArrayList<>();

            for (int i = 0; i < MAP_LENGTH; i++) {
                String[] line = reader.readLine().split(" ");

                for (int j = 0; j < MAP_LENGTH; j++) {
                    int number = Integer.parseInt(line[j]);
                    map[i][j] = number;
                    if (number != 0) {
                        points.add(new Point(i, j));
                    }
                }
            }

            System.out.println(solution(map, points));
        }
    }
}


