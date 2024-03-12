import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 계단오르기 2579번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     * 맨 마지막 칸에서 아래쪽으로 해야하는 듯?
     *
     * 1. 계단은 최대 2칸 가능
     * 2. 연속된 세개 계단은 불가능 ( 시작 계단은 포함 x )
     * 3. 마지막 계단은 밟아야 한다
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 계단 수
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            dp[0] = 0;
            dp[1] = arr[1];
        } else if(n == 2){
            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
        } else {
            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i < n + 1; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
            }
        }

        System.out.println(dp[n]);
    }
}
