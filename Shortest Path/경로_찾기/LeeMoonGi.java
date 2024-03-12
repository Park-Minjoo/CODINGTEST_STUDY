import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로 찾기 11403번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }


    /**
     *  Dab = min(Dab, Dac + Dcb)
     *
     *  거쳐갈수 있으면 1로 바꿔주면 된다
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        StringTokenizer st;

        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {  // 거쳐가는 노드
            for (int j = 0; j < n; j++) { // 출발 노드
                for (int k = 0; k < n; k++) { // 도착 노드
                    // 거쳐서 도착할 수 있으면 ok
                    if (graph[j][i] == 1 && graph[i][k] == 1) {
                        graph[j][k] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j]+ " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}