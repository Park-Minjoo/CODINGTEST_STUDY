import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Ksy {

    private static String solution(int n, int[] commands) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (o1, o2) -> -Integer.compare(o1, o2)
        );

        for (int command : commands) {
            if (command == 0) {
                if (maxHeap.isEmpty()) {
                    result.append(0);
                } else {
                    result.append(maxHeap.poll());
                }
                result.append("\n");
            } else {
                maxHeap.offer(command);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            int[] commands = new int[n];

            for (int i = 0; i < n; i++) {
                commands[i] = Integer.parseInt(reader.readLine());
            }

            System.out.println(solution(n, commands));
        }
    }
}
