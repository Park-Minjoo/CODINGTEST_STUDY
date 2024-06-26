import java.io.*;
import java.util.*;

public class Main {

    public static int R, C;
    public static int lamb, wolf;
    public static char[][] map;
    public static boolean[][] visited;

    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);

        initMap(br);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j])
                    BFS(i, j);
            }
        }


        System.out.println(lamb + " " + wolf);
    }

    private static void initMap(BufferedReader br) throws IOException {
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = charArray[j];
            }
        }
    }

    private static void BFS(int i, int j) {
        int tmpLamb = 0;
        int tmpWolf = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        
        if (map[i][j] == 'o') tmpLamb++;
        if (map[i][j] == 'v') tmpWolf++;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pi = poll.i;
            int pj = poll.j;
            visited[pi][pj] = true;

            for (int k = 0; k < 4; k++) {
                int newI = pi + di[k];
                int newJ = pj + dj[k];

                if (newI < 0 || newJ < 0 || newI >= R || newJ >= C) continue;
                if (visited[newI][newJ]) continue;
                if (map[newI][newJ] == '#') continue;
                else if (map[newI][newJ] == 'o') tmpLamb++;
                else if (map[newI][newJ] == 'v') tmpWolf++;

                queue.add(new Node(newI, newJ));
                visited[newI][newJ] = true;
            }
        }

        if (tmpWolf >= tmpLamb){
            wolf += tmpWolf;
        } else {
            lamb += tmpLamb;
        }
    }
    
    
    private static class Node {
        int i;
        int j;
        
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}