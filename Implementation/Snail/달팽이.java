import java.io.*;
import java.util.*;

class Main {

    public static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        drowMap(N);
        printMapTarget(target, N);
    }

    private static void drowMap(int N) {
        map = new int[N+2][N+2];
        int center = (N+1)/2;
        map[center][center] = 1; // 가운데는 1
        map[center -1][center] = 2;

        Node node = new Node(center -1,center, 2); // 두번째
        int n = 2;
        while(n<=N*N) {
            node = move(node, N);
            map[node.i][node.j] = node.value;
            n++;
        }
    }

    private static Node move(Node node, int N) {
        int i = node.i;
        int j = node.j;

        int up = map[i-1][j];
        int down = map[i+1][j];
        int left = map[i][j-1];
        int right = map[i][j+1];

        Node nextNode = null;

        // 오른쪽 이동
        if (up == 0 && right == 0 && down != 0) {
            nextNode = new Node(i, j+1, node.value+1);
            // 아래쪽 이동
        } else if (down == 0  && right == 0 && left != 0) {
            nextNode =  new Node(i+1, j, node.value+1);
            // 왼쪽 이동
        } else if (left == 0 && down == 0 &&up != 0 ) {
            nextNode = new Node(i, j-1, node.value+1);
            // 위쪽 이동
        } else if (up == 0  && left == 0 && right != 0) {
            nextNode = new Node(i-1, j, node.value+1);
        }
        return nextNode;
    }

    private static void printMapTarget(int target, int N) {
        StringBuilder sb = new StringBuilder();
        Node node = null;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                sb.append(map[i][j]).append(" ");
                if(map[i][j] == target) {
                    node = new Node(i, j, map[i][j]);
                }
            }
            sb.append("\n");
        }
        sb.append(node.i).append(" ").append(node.j);

        System.out.println(sb.toString());
    }

    private static class Node {
        int i;
        int j;
        int value;
        public Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

}
