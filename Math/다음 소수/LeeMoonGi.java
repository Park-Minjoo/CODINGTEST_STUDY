import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다음 소수 4134번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    public static boolean isPrimeNumber(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     *  소수인지는 제곱근까지만 확인하면 된다
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());

            // 0,1 예외처리
            if (n == 0 | n == 1) {
                sb.append(2 + "\n");
                continue;
            }
            for (long j = n; j <= 5000000000L; j++) {
                if (isPrimeNumber(j)) {
                    sb.append(j + "\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
