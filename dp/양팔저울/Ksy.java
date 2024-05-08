import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 양팔저울
 * 메모리: 15432 KB
 * 시간: 128 ms
 *
 * https://www.acmicpc.net/problem/2629
 */

public class Ksy {

    static boolean[][] isPossible;
    static int weightCount;

    // ----- dp 풀이 -----
    // dp로 어떻게 풀어야할지 몰라서 고민하다가 다른 사람 풀이 참고
    // 참고 링크: https://loosie.tistory.com/175
    private static String solution(int[] weights, int[] marbles) {
        StringBuilder result = new StringBuilder();
        isPossible = new boolean[weightCount + 1][40_000 + 1];
        dp(0, 0, weights);

        first: for (int marble : marbles) {
            for (int i = 0; i <= weightCount; i++) {
                if (isPossible[i][marble]) {
                    result.append("Y ");
                    continue first;
                }
            }
            result.append("N ");
        }
        return result.toString();
    }

    private static void dp(int count, int weight, int[] weights) {
        if (isPossible[count][weight]) {
            return;
        }
        isPossible[count][weight] = true;

        if (count == weightCount) {
            return;
        }

        dp(count + 1, weight + weights[count] , weights);
        dp(count + 1, weight, weights);
        dp(count + 1, Math.abs(weight - weights[count]) , weights);
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            weightCount = Integer.parseInt(reader.readLine());
            int[] weights = new int[weightCount];
            String[] weightLine = reader.readLine().split(" ");
            for (int i = 0; i < weightCount; i++) {
                weights[i] = Integer.parseInt(weightLine[i]);
            }

            int marbleCount = Integer.parseInt(reader.readLine());
            int[] marbles = new int[marbleCount];
            String[] marbleLine = reader.readLine().split(" ");
            for (int i = 0; i < marbleCount; i++) {
                marbles[i] = Integer.parseInt(marbleLine[i]);
            }

            System.out.println(solution(weights, marbles));
        }
    }
}
