import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static Node[][] map;
    private static List<HashSet<Integer>> favoritOrder = new ArrayList<HashSet<Integer>>();
    private static List<Integer> order = new ArrayList<Integer>();

    private static int di[] = {1, -1, 0, 0};
    private static int dj[] = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        init();
        sit();
        int answer = satisfaction();

        System.out.print(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new Node[N][N];

        for (int i=0; i<=N*N; i++) {
            favoritOrder.add(new HashSet<Integer>());
        }

        for (int i=1; i<=N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int number  = Integer.parseInt(st.nextToken());
            order.add(number);
            Set set = favoritOrder.get(number);
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            int f3 = Integer.parseInt(st.nextToken());
            int f4 = Integer.parseInt(st.nextToken());
            set.add(f1);
            set.add(f2);
            set.add(f3);
            set.add(f4);
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = new Node(i,j);
            }
        }
    }

    private static void sit() {
        for (int p=0; p<N*N; p++) {
            int orderNum = (int) order.get(p);
            HashSet favorit = favoritOrder.get(orderNum);
            Integer n = 2;

            Node bestNode = null;

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    Node current = map[i][j];
                    if (current.stduentNumber != 0) continue; // 이미 앉아 있음
                    current.friends= 0;
                    current.empty= 0;
                    if (bestNode == null) bestNode = current;

                    setNode(current, favorit);

                    // 0 보다 작게 나오면 current가 더 큼
                    if (bestNode.compareTo(current) < 0){
                        bestNode = current;
                    }
                }
            }

            bestNode.stduentNumber = orderNum;
            map[bestNode.i][bestNode.j] = bestNode;
        }
    }

    private static int satisfaction() {
        int satisfaction = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                Node current = map[i][j];
                int stduentNumber = current.stduentNumber;
                HashSet favorit = favoritOrder.get(stduentNumber);

                current.friends = 0;
                current.empty = 0;

                setNode(current, favorit);

                switch (current.friends) {
                    case 0 : satisfaction += 0; break;
                    case 1 : satisfaction += 1; break;
                    case 2 : satisfaction += 10; break;
                    case 3 : satisfaction += 100; break;
                    case 4 : satisfaction += 1000; break;
                }
            }
        }
        return satisfaction;
    }
    
    private static void setNode(Node current, HashSet favorit) {

        for(int k=0; k<4; k++) {
            int newI = current.i + di[k];
            int newJ = current.j + dj[k];

            if (newI < 0 || newI >= N || newJ < 0 || newJ >= N) continue;
            // 비어있는 거
            int nearNumber = map[newI][newJ].stduentNumber;
            if(nearNumber == 0) {
                current.empty++;
                // 좋아하는 거
            } else if (favorit.contains(nearNumber)) {
                current.friends++;
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int stduentNumber = 0;
        int i;
        int j;
        int friends = 0; // 근처 친구수
        int empty = 0;  // 근처 비어있는 자리수
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node other) {
            // 좋아하는 학생
            if (this.friends != other.friends) {
                return this.friends - other.friends;
            }
            // 근처 빈 자리
            if (this.empty != other.empty) {
                return this.empty - other.empty;
            }
            // 행번호가 가장 작은
            if (this.i != other.i) {
                return other.i - this.i;
            }
            // 열번호가 가장 작은
            if (this.j != other.j) {
                return other.j - this.j;
            }
            return 0;
        }
    }

}
