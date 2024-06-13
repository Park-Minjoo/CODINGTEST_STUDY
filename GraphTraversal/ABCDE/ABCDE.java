import java.io.*;
import java.util.*;


public class Main {

    public static int N, M;
    public static List[] relation;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relation = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            relation[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relation[index].add(value);
            relation[value].add(index);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (DFS(i, 1)) {
                answer = 1;
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean DFS(int start, int depth) {
        if (depth == 5) {
            return true;
        }

        visited[start] = true;
        List<Integer> list = relation[start];
        for (Integer index : list) {
            if (!visited[index] && DFS(index, depth + 1))
                return true;
        }
        visited[start] = false;
        return false;
    }

}