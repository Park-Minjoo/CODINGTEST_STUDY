import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팀 결성
public class LeeMoonGi {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     *
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 1 <= n,m <= 100,000
        int n = Integer.parseInt(st.nextToken()); // n + 1 팀
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            boolean bol = Integer.parseInt(st.nextToken()) == 1;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 같은 팀 여부 확인
            if (bol) {
                if (find(arr, a) == find(arr, b)) { // 부모가 같은면 한팀
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }

                // 팀 합치기
            } else {
                union(arr, a, b);
            }

        }
    }

    public static int find(int[] parent, int i) {
        // 루트 노드를 찾을 때까지 재귀
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]); //
    }

    public static void union(int[] parent, int a, int b) {
        int aParent = find(parent, a);
        int bParent = find(parent, b);

        if (aParent < bParent) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }

}

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

 */