import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ksy {

    private static String solution(int n, int[] numbers) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        int targetIndex = 0;
        for (int current = 1; current <= n; current++) {
            stack.addLast(current);
            result.append("+\n");

            while (!stack.isEmpty() && stack.peekLast() == numbers[targetIndex]) {
                stack.pollLast();
                result.append("-\n");
                targetIndex++;

                if (n <= targetIndex) {
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(reader.readLine());
            }

            System.out.println(solution(n, numbers));
        }
    }
}
