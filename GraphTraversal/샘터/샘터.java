import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, K;
    public static long[] map;
    public static HashSet<Long> visited = new HashSet<>();
    public static Queue<Node> queue = new LinkedList<>();
    public static long answer = 0;

    public static int[] d = {1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            queue.add(new Node(map[i], 0));
            visited.add(map[i]);
        }

        BFS();

        System.out.println(answer);
    }

    private static void BFS() {
        int count = -N;
        while (!queue.isEmpty()) {
            if (count >= K) break;

            Node poll = queue.poll();
            answer += poll.happy;

            for (int i = 0; i < 2; i++) {
                // 방문 여부 확인
                long newIndex = poll.index + d[i];
                if (visited.contains(newIndex)) continue;

                queue.add(new Node(newIndex, poll.happy + 1));
                visited.add(newIndex);
            }
            count++;
        }

    }

    private static class Node {
        long index;
        long happy;

        public Node(long index, long happy) {
            this.index = index;
            this.happy = happy;
        }
    }
}

