import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] train;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        train = new int[N + 1][21]; // 0번 기차, 0번 좌석은 계산하기 편하라고 넣음
        boolean[] falseList = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int seat = 0;
            if (order == 1 || order == 2)
                seat = Integer.parseInt(st.nextToken());

            if (order == 1) {
                train[number][seat] = 1;
            } else if (order == 2) {
                train[number][seat] = 0;
            } else if (order == 3) {
                for (int j = 20; j > 1; j--) {
                    train[number][j] = train[number][j - 1];
                }
                train[number][1] = 0;
            } else if (order == 4) {
                for (int j = 1; j < 20; j++) {
                    train[number][j] = train[number][j + 1];
                }
                train[number][20] = 0;
            }
        }

        /**
         *  set의 특성을 이용한다. ( 중복 X )
         *  기차를 문자열로 만든다음 set에 추가합니다.
         *  set에 카운트를 리턴하면 됩니다.
         */
        HashSet<String> set = new HashSet();
        for (int i = 1; i < N + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < 21; j++) {
                sb.append(train[i][j]);
            }
            String trainStr = sb.toString();
            set.add(trainStr);
        }

        System.out.println(set.size());
    }

}
