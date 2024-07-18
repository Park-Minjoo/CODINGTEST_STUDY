import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] targets;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        targets = new int[N];
        arr = new int[N+1];

        for (int i=0; i<N; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<=N; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> statck = new Stack<Integer>();
        statck.push(0);

        int targetIdx = 0;
        int target = targets[targetIdx];
        int arrIdx = 0;

        while (true) {
            int current = statck.peek();

            if (target > current) {
                int nextNum = arr[++arrIdx];
                statck.push(nextNum);
                sb.append("+").append("\n");
            } else if (target == current) {
                statck.pop();
                sb.append("-").append("\n");
                targetIdx++;
                if(targetIdx == N) break;
                target = targets[targetIdx];
            } else {
                sb = new StringBuilder("NO");
                break;
            }
        }

        System.out.println(sb.toString());
    }

}
