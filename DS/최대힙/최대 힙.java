import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            queue.add(n);

            if (n == 0) {
                sb.append(queue.poll()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
