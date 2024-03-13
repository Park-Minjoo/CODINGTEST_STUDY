import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 도시 분할 계획 1647번
public class LeeMoonGi {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     * 최소신장트리 문제로 선을 하나만 남겨 두고
     * 제일 유지비가 높은 선 하나 제거 하면 마을이 2개가 된다
     */
    public static int find(int[] parent , int i) {
        if (parent[i] == i) // 부모노드
            return i;
        return parent[i] = find(parent, parent[i]);
    }
    public static void union(int[] parent, int a, int b) {
        int aParent = find(parent, a);
        int bParent = find(parent, b);

        // 작은 숫자가 부모
        if (aParent < bParent)
            parent[bParent] = aParent;
        else
            parent[aParent] = bParent;
    }
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 2이상 100,000이하인 정수이고, M은 1이상 1,000,000이하인 정수
        int n = Integer.parseInt(st.nextToken()); // 집 개수
        int m = Integer.parseInt(st.nextToken()); // 길 개수

        int[] parent = new int[n + 1]; // 부모 노드
        ArrayList<Edge> list = new ArrayList(); // 간선간의 길이 정보를 가지고 있는 리스트
        int result = 0;
        int maxCost = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            list.add(new Edge(cost, nodeA, nodeB));
        }

        Collections.sort(list);

        // 부모노드 초기화
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            Edge edge = list.get(i);
            int startParent = find(parent, edge.getStart());
            int endParent = find(parent, edge.getEnd());

            // 같은 집합이 아니면 합쳐라
            if (startParent != endParent){
                union(parent, edge.getStart(), edge.getEnd());
                result = result + edge.getCost();
                maxCost = Math.max(maxCost, edge.getCost());
            }
        }

        System.out.println(result - maxCost);
    }
}

// 간선간의 관계를 나타내는 객체
class Edge implements Comparable<Edge> {

    private int start;
    private int end;
    private int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4

 */