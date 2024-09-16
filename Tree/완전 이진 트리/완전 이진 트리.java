import java.io.*;
import java.util.*;

public class Main {

    private static int K, N;
    private static int[] tree;
    private static StringBuilder[] sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2,K)-1; // 노드의 개수
        tree = new int[N];
        sb = new StringBuilder[K]; // 깊이 만큼

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<K; i++) {
            sb[i] = new StringBuilder();
        }

        findNode(0, N-1, 0);
        for (int i=0; i<K; i++) {
            System.out.println(sb[i].toString());
        }
    }

    private static void findNode(int start, int end, int depth) {
        if (depth == K) return;

        int mid = (start + end) / 2;
        sb[depth].append(tree[mid]).append(" ");

        findNode(start, mid-1, depth+1); // 왼쪽 트리
        findNode(mid+1, end, depth+1); // 오른쪽 트리
    }
}
