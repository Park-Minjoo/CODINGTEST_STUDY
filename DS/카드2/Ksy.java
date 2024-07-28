import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ksy {

    private static int solution(int n) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            q.offer(i);
        }

        boolean offerFlag = false;
        while (q.size() > 1) {
            Integer current = q.poll();
            if (offerFlag) {
                q.offer(current);
            }
            offerFlag = !offerFlag;
        }

        return q.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(solution(n));
        }
    }
}
