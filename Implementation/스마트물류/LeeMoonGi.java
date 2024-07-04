import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N, K;
    public static char[] arr;
    public static boolean[] used; // 사용된 로봇팔
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        arr = br.readLine().toCharArray();
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            boolean found = false;
            if (arr[i] == 'P') continue;

            // 가장 왼쪽부터 찾아야 한다
            for (int j = K; j >= 1; j--) {
                int index = i - j;
                // 배열 범위 체크
                if (index < 0) continue;
                if (arr[index] == 'P' && !used[index]) {
                    used[index] = true;
                    answer++;
                    found = true;
                    break;
                }
            }

            // 왼쪽에서 못찾았으면 오른쪽 탐색
            if (!found) {
                for (int j = 1; j <= K; j++) {
                    int index = i + j;
                    // 배열 범위 체크
                    if (index >= N) continue;
                    if (arr[index] == 'P' && !used[index]) {
                        used[index] = true;
                        answer++;
                        break;
                    }
                }
            }

        }

        System.out.println(answer);
    }
}
