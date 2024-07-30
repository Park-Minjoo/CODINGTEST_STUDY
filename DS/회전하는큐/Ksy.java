import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Ksy {

    private static int solution(int n, int[] numbers) {
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            deque.offer(i);
        }

        int count = 0;
        first: for (int number : numbers) {
            int index = deque.indexOf(number);

            if (index + 1 <= deque.size() - index) {
                while (!deque.isEmpty()) {
                    int current = deque.pollFirst();

                    if (current == number) {
                        continue first;
                    }

                    count++;
                    deque.offerLast(current);
                }
            }

            if (index + 1 > deque.size() - index) {
                while (!deque.isEmpty()) {
                    int current = deque.pollLast();
                    count++;

                    if (current == number) {
                        continue first;
                    }

                    deque.offerFirst(current);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);

            String[] secondLine = reader.readLine().split(" ");
            int[] numbers = new int[secondLine.length];
            for (int i = 0; i < secondLine.length; i++) {
                numbers[i] = Integer.parseInt(secondLine[i]);
            }

            System.out.println(solution(n, numbers));
        }
    }
}
