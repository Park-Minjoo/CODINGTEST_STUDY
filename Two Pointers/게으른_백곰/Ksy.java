import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 게으른 백곰
 * 메모리: 50740 KB
 * 시간: 504 ms
 *
 * https://www.acmicpc.net/problem/10025
 */

public class Ksy {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);

            int[] buckets = new int[1_000_001];
            int min = 1_000_001;
            int max = 0;
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                int g = Integer.parseInt(line[0]);
                int x = Integer.parseInt(line[1]);

                buckets[x] = g;
                min = Math.min(min, x);
                max = Math.max(max, x);
            }

            System.out.println(solution(k, min, max, buckets));
        }
    }

    private static int solution(int k, int min, int max, int[] buckets) {
        int left = min;
        int right = min;
        int sum = 0;
        int maxSum = 0;

        while (right <= max) {
            if (2 * k + 1 == right - left) {
                sum -= buckets[left];
                left++;
            }

            sum += buckets[right];
            right++;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // Map -> 시간 초과
//    private static int solution(int k, HashMap<Integer, Integer> buckets) {
//        int left = Collections.min(buckets.keySet());
//        int right = left;
//        int sum = 0;
//        int maxSum = 0;
//
//        while (left <= right && right <= Collections.max(buckets.keySet())) {
//            if (right - left == k * 2 + 1) {
//                sum -= buckets.getOrDefault(left, 0);
//                left++;
//            }
//
//            if (buckets.containsKey(right)) {
//                sum += buckets.get(right);
//            }
//
//            maxSum = Math.max(maxSum, sum);
//            right++;
//        }
//
//        return maxSum;
//    }
}
