import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int max;
    private static boolean[][] visited = new boolean[N][M];
    private static int[][] map;
    private static List<Node> virus = new ArrayList<>();
    private static List<Node> wall = new ArrayList<>();
    private static boolean[] selected; // 뽑은 조합
    private static List<List<Node>> combinationResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        /* 입력받기 */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new Node(i, j));
                if (map[i][j] == 0) wall.add(new Node(i, j));
            }
        }

        /* 순열 구하기 */
        selected = new boolean[wall.size()];
        combination(0, 0); // combinationResult 벽을 생성할 수 있는 조합 리스트

        /* 바이러스 뿌리기 */
        BFS();

        System.out.println(max);
    }

    private static void combination(int count, int start) {
        // 벽 조합 3개를 찾으면 결과값을 combinationResult 에다 추가
        if (count == 3) {
            List<Node> selectNode = new ArrayList<>();

            for (int i = 0; i < wall.size(); i++) {
                if (selected[i])
                    selectNode.add(wall.get(i));
            }
            combinationResult.add(selectNode);
            return;
        }

        for (int i = start; i < wall.size(); i++) {
            selected[i] = true;
            combination(count + 1, i + 1);
            selected[i] = false;
        }
    }

    private static void BFS() {
        int count = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        Queue<Node> queue = new LinkedList<>();

        // 조합 개수만큼 반복
        for (int z = 0; z < combinationResult.size(); z++) {
            List<Node> nodes = combinationResult.get(z);
            int[][] copyMap = getCopyMap();
            visited = new boolean[N][M];

            // 벽 3개 새우기
            for (int i = 0; i < 3; i++) {
                Node node = nodes.get(i);
                copyMap[node.i][node.j] = 1;
            }

            queue.addAll(virus);

            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                int i = poll.i;
                int j = poll.j;

                if (visited[i][j]) continue;

                for (int k = 0; k < 4; k++) {
                    int newI = i + di[k];
                    int newJ = j + dj[k];

                    if (newI < 0 || newI >= N || newJ < 0 || newJ >= M) continue;

                    if (copyMap[newI][newJ] == 0) {
                        queue.add(new Node(newI, newJ));
                        copyMap[newI][newJ] = 2;
                    }
                }

                visited[i][j] = true;
             }

            // 안전영역 최대값 구하기
            setMax(count, copyMap);
        }
    }

    private static void setMax(int count, int[][] copyMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) count++;
            }
        }
        max = Math.max(count, max);
    }

    /* map 복사 */
    private static int[][] getCopyMap() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }


    private static class Node {
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
        int i;
        int j;
    }
}

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

 */