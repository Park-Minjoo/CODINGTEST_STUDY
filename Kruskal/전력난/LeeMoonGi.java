import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 전력난 6497번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     * 이미 연결된 노드의 경우 -> 절약해도 되는 길 -> result 값에다 더해준다
     */
    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    public static void union(int[] parent, int a, int b) {
        // 부모 찾아서 다르면 더하기
        int aParent = find(parent, a);
        int bParent = find(parent, b);

        if(aParent < bParent) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }

    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 집
            int m = Integer.parseInt(st.nextToken()); // 길

            // 종료 조건
            if (n == 0 && m == 0)
                break;

            long result = 0;
            int[] parent = new int[n + 1];
            ArrayList<Edge> list = new ArrayList<>();

            // 부모 노드 초기화
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            // 길이 정보 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.add(new Edge(start, end, cost));
            }

            Collections.sort(list);

            // 부모가 같으면 연결되어 있다
            for (int i = 0; i < m; i++) {
                Edge edge = list.get(i);
                int startParent = find(parent, edge.start);
                int endParent = find(parent, edge.end);

                // 부모가 다르면 아직 연결 안된거
                if (startParent != endParent) {
                    union(parent, edge.start, edge.end);
                } else {
                    // 절약한 값을 구하는 거라서
                    result = result + edge.cost;
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

/**
 7 11
 0 1 7
 0 3 5
 1 2 8
 1 3 9
 1 4 7
 2 4 5
 3 4 15
 3 5 6
 4 5 8
 4 6 9
 5 6 11
 0 0

 */
}
