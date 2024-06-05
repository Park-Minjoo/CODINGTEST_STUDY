import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int result;
    public static int start = 1;
    public static int end = 100;
    public static boolean[] visited;
    public static Map<Integer, Integer> gameThings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        gameThings = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            gameThings.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            gameThings.put(x, y);
        }

        BFS();
        System.out.println(result);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;


        while (!q.isEmpty()) {
            result++;
            for (int i = 0, qSize = q.size(); i < qSize; i++) {
                int now = q.poll();

                for (int j = 1; j <= 6; j++) {
                    int move = now + j;
                    if (move == end) return;

                    if (move > end) continue;
                    if (visited[move]) continue;

                    visited[move] = true;
                    if (gameThings.containsKey(move)) { // 뱀이나 사다리를 만난 경우
                        move = gameThings.get(move);
                    }
                    q.add(move);
                }
            }
        }
    }
}