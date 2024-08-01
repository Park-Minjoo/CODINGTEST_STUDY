import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        while (queue.size() > 1) {
            int deak1 = queue.poll();
            int deak2 = queue.poll();

            int sum = deak1 + deak2;
            queue.offer(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}
