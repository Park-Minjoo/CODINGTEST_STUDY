import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static Deque<Integer> deque = new LinkedList<Integer>();
    private static int[] arr;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            deque.offer(i);
        }

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while (count != M) {
            int firstTop = deque.peek();
            int target = arr[count];

            int count1 = firstToLast(target);
            LastToFirst(firstTop); // 큐 원복

            int count2 = LastToFirst(target);
            firstToLast(firstTop); // 큐 원복

            if (count1 < count2) {
                answer += count1;
                firstToLast(target);
            } else {
                answer += count2;
                LastToFirst(target);
            }

            deque.poll();
            count++;
        }

        System.out.println(answer);
    }

    // 앞 -> 뒤
    private static int firstToLast(int target) {
        int count = 0;
        while (target != deque.peek()) {
            deque.offerLast(deque.pollFirst());
            count++;
        }
        return count;
    }
    // 뒤 -> 앞
    private static int LastToFirst(int target) {
        int count = 0;
        while (target != deque.peek()) {
            deque.offerFirst(deque.pollLast());
            count++;
        }
        return count;
    }


}
