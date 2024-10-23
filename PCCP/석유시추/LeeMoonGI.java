import java.util.*;

class LeeMoonGi {

    public int solution(int[][] land) {

        int[] result = new int[land[0].length]; // 땅에 들어있는 석유 크기
        boolean[] resultVisited = new boolean[land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];

        for (int i=0; i<land[0].length; i++) {
            for (int j=0; j<land.length; j++) {
                if (!visited[j][i] && land[j][i] == 1) {
                    int count = BFS(j, i, land, result, resultVisited, visited);
                    addResult(result, resultVisited, count);
                }
            }
        }

        int answer = 0;
        for (int i=0; i<result.length; i++) {
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }

    public int BFS(int x, int y, int[][] land, int[] result, boolean[] resultVisited, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x, y);
        queue.add(node);
        visited[x][y] = true;
        resultVisited[y] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            count++;

            // 4가지 방향 조회
            int[] dx = {1,-1,0,0};
            int[] dy= {0,0,1,-1};
            for (int k=0; k<4; k++) {
                // 배열 범위 체크
                int newX = cur.x + dx[k];
                int newY = cur.y + dy[k];
                if (newX < 0 || newY < 0 || newX >= land.length || newY >= land[0].length) {
                    continue;
                }

                // 이미 방문했거나 석유아님
                if (visited[newX][newY] || land[newX][newY] == 0) {
                    continue;
                }

                queue.offer(new Node(newX, newY));
                visited[newX][newY] = true;

                // 오른쪽으로 이동했을 경우
                if (k==2 && !resultVisited[newY]) {
                    resultVisited[newY] = true;
                }
            }
        }

        return count;
    }

    public class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void addResult(int[] result, boolean[] resultVisited, int count) {

        // 배열에 값 더하기
        int length = result.length;
        for (int i=0; i<length; i++) {
            if (resultVisited[i]) {
                result[i] += count;
            }
        }

        // visited 초기화
        Arrays.fill(resultVisited, false);
    }

    public void print(int[][] land) {
        System.out.println("===================");
        for (int i=0; i<land.length; i++) {
            System.out.println();
            for(int j=0; j<land[0].length; j++) {
                System.out.print(land[i][j] + " ");
            }
        }
    }

    public void print(boolean[][] visited) {
        System.out.println("===================");
        for (int i=0; i<visited.length; i++) {
            System.out.println();
            for(int j=0; j<visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
        }
    }
}