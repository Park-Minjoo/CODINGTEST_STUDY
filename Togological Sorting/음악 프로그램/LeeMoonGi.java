import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 음악프로그램 2623번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }


    /**
     *  반례 존재
     *  1. 큐가 끝나지 않은 경우 -> 사이클이 존재
     *  2. 노드를 전부 방문하지 않았는데 큐 종료 -> 연결이 안된 경우
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가수
        int m = Integer.parseInt(st.nextToken()); // 피디

        int[] arr = new int[n + 1]; // 진입차수 배열
        ArrayList<Integer> result = new ArrayList<>(); // 순서 결과값
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 방향 정보
        int visited = 0;


        // 2차원 ArrayList 초기화
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입차수 카운트 / 그래프 방향 추가
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int length = Integer.parseInt(split[0]);
            for (int j = 1; j < length; j++) {
                int a = Integer.parseInt(split[j]);
                int b = Integer.parseInt(split[j + 1]);

                arr[b]++;
                graph.get(a).add(b);
            }
        }

        // 진입차수가 0인 노드 큐에 추가
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            // 노드를 전부 방문했는데 안끝나면 사이클이 존재한다
            if (visited == n) {
                result = new ArrayList<>();
                break;
            }

            // 현제 노드
            Integer nowNode = queue.poll();
            // 결과리스트에 추가
            result.add(nowNode);
            visited++;

            // 방향 정보를 처리
            ArrayList<Integer> edge = graph.get(nowNode);
            for (int i = 0; i < edge.size(); i++) {
                Integer nodeNum = edge.get(i);
                arr[nodeNum]--;
                if (arr[nodeNum] == 0){
                    queue.add(nodeNum);
                }
            }
        }

        // 출력값 기 모으기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + "\n");
        }

        if (result.isEmpty() || visited != n)
            System.out.println("0");
        else
            System.out.println(sb);
    }


/*
6 2
2 2 2
4 6 2 5 4
2 2 3

2 2
2 1 2
2 2 1

*/
}
