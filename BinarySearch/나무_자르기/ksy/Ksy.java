import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ksy {

    private static long solution(int n, long m, long[] heights) {
        Arrays.sort(heights);

        long left = 0;
        long right = heights[n - 1];

        while (left <= right) {
            long mid = (right + left) / 2;
            long sum = sum(heights, mid);

            if (sum == m) {
                return mid;
            }

            if (sum < m) {
                right = mid - 1;
                continue;
            }

            left = mid + 1;
        }
        return right;
    }

    private static long sum(long[] heights, long mid) {
        long sum = 0;

        for (long height : heights) {
            if (mid < height) {
                sum += height - mid;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            long m = Long.parseLong(firstLine[1]);

            String[] secondLine = reader.readLine().split(" ");
            long[] heights = new long[n];

            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(secondLine[i]);
            }

            System.out.println(solution(n, m, heights));
        }
    }
}
