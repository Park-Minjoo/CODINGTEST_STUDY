import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ksy {

    private static int[] solution(int n, long[] levels, int q, int[][] pairs) {
        int[] counter = createCounter(n, levels);
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int start = pairs[i][0];
            int end = pairs[i][1];

            result[i] = counter[end] - counter[start];
        }

        return result;
    }

    private static int[] createCounter(int n, long[] levels) {
        int[] counter = new int[n];

        for (int i = 1; i < n; i++) {
            long current = levels[i];
            long pre = levels[i - 1];
            counter[i] = counter[i - 1];

            if (current < pre) {
                counter[i] += 1;
            }
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            long[] levels = getLevels(n, reader.readLine().split(" "));
            int q = Integer.parseInt(reader.readLine());
            int[][] pairs = getPairs(q, reader);

            int[] results = solution(n, levels, q, pairs);
            StringBuilder answer = new StringBuilder();

            for (int result : results) {
                answer.append(result)
                        .append("\n");
            }

            System.out.println(answer);
        }
    }

    private static int[][] getPairs(int q, BufferedReader reader) throws IOException {
        int[][] pairs = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] input = reader.readLine().split(" ");
            pairs[i][0] = Integer.parseInt(input[0]) - 1;
            pairs[i][1] = Integer.parseInt(input[1]) - 1;
        }

        return pairs;
    }

    private static long[] getLevels(int n, String[] levels) {
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            result[i] = Long.parseLong(levels[i]);
        }

        return result;
    }
}
